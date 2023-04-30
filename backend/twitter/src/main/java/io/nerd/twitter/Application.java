package io.nerd.twitter;

import io.nerd.twitter.models.ApplicationUser;
import io.nerd.twitter.models.Role;
import io.nerd.twitter.repository.RoleRepository;
import io.nerd.twitter.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@Slf4j
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    CommandLineRunner run(RoleRepository roleRepository, UserService userService) {
        return args -> {
            roleRepository.save(new Role(1, "USER"));
//            var user = new ApplicationUser();
//            user.setUserId(1);
//            user.setFirstName("Hassan");
//            user.setLastName("Refaat");
//
//            userService.registerUser(user);
        };
    }
}
