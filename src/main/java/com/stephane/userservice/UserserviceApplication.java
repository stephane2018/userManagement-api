package com.stephane.userservice;

import com.stephane.userservice.models.Role;
import com.stephane.userservice.models.User;
import com.stephane.userservice.services.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;

@SpringBootApplication
public class UserserviceApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserserviceApplication.class, args);
    }
    @Bean
    CommandLineRunner run (UserService userService){
        return  args -> {
            userService.saveROle(new Role(null, "ROLE_USER"));
            userService.saveROle(new Role(null, "ROLE_MANAGER"));
            userService.saveROle(new Role(null, "ROLE_ADMIN"));
            userService.saveROle(new Role(null, "ROLE_SUPER_ADMIN"));

            userService.saveUser(new User(null, "stephane", "sukuna","123456", new ArrayList<>()));
            userService.saveUser(new User(null, "stephane", "sukuna","123456", new ArrayList<>()));
            userService.addToleToUser("sukuna", "ROLE_USER");
            userService.addToleToUser("will", "ROLE_ADMIN");
        };
    }
}
