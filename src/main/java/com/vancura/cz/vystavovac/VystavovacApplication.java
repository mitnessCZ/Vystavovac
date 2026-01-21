package com.vancura.cz.vystavovac;

import com.vancura.cz.vystavovac.model.User;
import com.vancura.cz.vystavovac.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class VystavovacApplication {

    private final UserService userService;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public VystavovacApplication(UserService userService, PasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
    }

    @Bean
    public CommandLineRunner demo() {
        return (args) -> {
            addUser("admin", "test", "ADMIN");
            addUser("mit","mitt","POSUZOVATEL");
            addUser("mat","matt","CHOVATEL");
            userService.getAllUsers().forEach(user -> {
                System.out.println("User: " + user.getUsername() + ", Role: " + user.getRole());
            });

        };
    }

    private void addUser(String username, String password, String role) {
        if (userService.findByUsername(username) == null) {
            User user = new User();
            user.setUsername(username);
            user.setPassword(password);
            user.setRole(role);
            userService.createUser(user);
        }
    }

    public static void main(String[] args) {
        SpringApplication.run(VystavovacApplication.class, args);
    }
}
