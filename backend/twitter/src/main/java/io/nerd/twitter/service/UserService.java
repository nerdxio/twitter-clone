/**
 * @author Hassan Refaat <hassan.refaat.dev@gmail.com>
 * @Created 4/25/2023 9:24 AM
 */
package io.nerd.twitter.service;

import io.nerd.twitter.exception.EmailAlreadyTakenException;
import io.nerd.twitter.exception.UserDoesNotExistException;
import io.nerd.twitter.models.ApplicationUser;
import io.nerd.twitter.models.RegistrationObject;
import io.nerd.twitter.models.Role;
import io.nerd.twitter.repository.RoleRepository;
import io.nerd.twitter.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

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
        userRepository.save(user);
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

    private long generateVerificationNumber(){
        return (long) (Math.random() * 100_000_000);
    }
}
