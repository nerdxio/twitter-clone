/**
 * @author Hassan Refaat <hassan.refaat.dev@gmail.com>
 * @Created 4/25/2023 9:24 AM
 */
package io.nerd.twitter.service;

import io.nerd.twitter.exception.EmailAlreadyTakenException;
import io.nerd.twitter.exception.EmailFailedToSendException;
import io.nerd.twitter.exception.IncorrectVerificationCodeException;
import io.nerd.twitter.exception.UserDoesNotExistException;
import io.nerd.twitter.models.ApplicationUser;
import io.nerd.twitter.models.RegistrationObject;
import io.nerd.twitter.models.Role;
import io.nerd.twitter.repository.RoleRepository;
import io.nerd.twitter.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final MailService mailService;
    private final PasswordEncoder passwordEncoder;

    public ApplicationUser getUserByUsername(String username) {
        return userRepository.findByUsername(username)
                .orElseThrow(UserDoesNotExistException::new);
    }

    public ApplicationUser updateUser(ApplicationUser user) {
        // todo better exception handling
        try {
            return userRepository.save(user);
        } catch (Exception e) {
            throw new EmailAlreadyTakenException();
        }
    }


    public ApplicationUser registerUser(RegistrationObject ro) {
        var user = new ApplicationUser();

        user.setFirstName(ro.firstName());
        user.setLastName(ro.lastName());
        user.setEmail(ro.email());
        user.setDateOfBirth(ro.dob());

        var username = generateUsername(ro.firstName());
        user.setUsername(username);

        Set<Role> roles = user.getAuthorities();
        var responseRole = roleRepository.findByAuthority("USER")
                .orElseThrow(() -> new RuntimeException("USER role not found"));
        roles.add(responseRole);
        user.setAuthorities(roles);
        try {
            return userRepository.save(user);
        } catch (Exception e) {
            throw new EmailAlreadyTakenException();
        }

    }

    public void generateEmailVerification(String username) {
        var user = userRepository.findByUsername(username)
                .orElseThrow(UserDoesNotExistException::new);
        user.setVerification(generateVerificationNumber());
        try {
            mailService.sendEmail(user.getEmail(), "Your Verification Code", "Verification Code is " + user.getVerification().toString());
            userRepository.save(user);
        } catch (Exception e) {
            throw new EmailFailedToSendException();
        }
        userRepository.save(user);
    }

    public ApplicationUser verifyEmail(String username, Long code) {
        var user = userRepository.findByUsername(username)
                .orElseThrow(UserDoesNotExistException::new);
        if (code.equals(user.getVerification())) {
            user.setEnabled(true);
            user.setVerification(null);
            return userRepository.save(user);
        } else {
            throw new IncorrectVerificationCodeException();

        }
    }

    public ApplicationUser setPassword(String username, String password) {
        var user = userRepository.findByUsername(username)
                .orElseThrow(UserDoesNotExistException::new);
        user.setPassword(passwordEncoder.encode(password));
        return userRepository.save(user);
    }

    private String generateUsername(String name) {
        var generateNumber = (long) (Math.random() * 1_000_000_000);
        var generateUsername = name + generateNumber;
        var nameTaken = true;
        while (nameTaken) {
            if (userRepository.findByUsername(generateUsername).isEmpty()) {
                nameTaken = false;
            }
        }
        return generateUsername;
    }

    private long generateVerificationNumber() {
        return (long) (Math.random() * 100_000_000);
    }


}
