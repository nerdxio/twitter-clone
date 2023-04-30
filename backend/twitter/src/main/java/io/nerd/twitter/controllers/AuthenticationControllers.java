/**
 * @author Hassan Refaat <hassan.refaat.dev@gmail.com>
 * @Created 4/30/2023 5:07 AM
 */
package io.nerd.twitter.controllers;

import io.nerd.twitter.models.ApplicationUser;
import io.nerd.twitter.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthenticationControllers {
    private final UserService userService;

    @PostMapping("/register")
    public ApplicationUser registerUser(@RequestBody ApplicationUser user) {
        return userService.registerUser(user);
    }
}
