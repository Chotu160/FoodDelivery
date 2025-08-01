package com.fooddelivery.config;

import com.fooddelivery.model.User;
import com.fooddelivery.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;

@Component
@RequiredArgsConstructor
public class DataInitializer {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @PostConstruct
    public void init() {
        // Find existing user or create new one
        User admin = userRepository.findByUsername("sheik")
                .orElse(new User());

        // Set/Update admin properties
        admin.setUsername("sheik");
        admin.setEmail("sheikjilani29@gmail.com");
        admin.setPassword(passwordEncoder.encode("password"));
        admin.setRole("ADMIN");  // Force ADMIN role

        userRepository.save(admin);
        System.out.println("Admin user 'sheik' created/updated - Full access to manipulate data");
    }
}