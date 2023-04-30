/**
 * @author Hassan Refaat <hassan.refaat.dev@gmail.com>
 * @Created 4/25/2023 9:24 AM
 */
package io.nerd.twitter.service;

import io.nerd.twitter.models.ApplicationUser;
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

    public ApplicationUser registerUser(ApplicationUser user) {
        Set<Role> roles = user.getAuthorities();
        var responseRole = roleRepository.findByAuthority("USER")
                .orElseThrow(() -> new RuntimeException("USER role not found"));
        roles.add(responseRole);
        user.setAuthorities(roles);
        return userRepository.save(user);
    }
}
