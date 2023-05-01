/**
 * @author Hassan Refaat <hassan.refaat.dev@gmail.com>
 * @Created 4/30/2023 5:07 AM
 */
package io.nerd.twitter.controllers;

import io.nerd.twitter.exception.EmailAlreadyTakenException;
import io.nerd.twitter.models.ApplicationUser;
import io.nerd.twitter.models.RegistrationObject;
import io.nerd.twitter.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthenticationControllers {
    private final UserService userService;

    @ExceptionHandler({EmailAlreadyTakenException.class})
    public ResponseEntity<String> handleEmailAlreadyTakenException() {
        return new ResponseEntity<>("The Email provided already taken", HttpStatus.CONFLICT);
    }
    @PostMapping("/register")
    public ApplicationUser registerUser(@RequestBody RegistrationObject ro) {
        return userService.registerUser(ro);
    }
}
