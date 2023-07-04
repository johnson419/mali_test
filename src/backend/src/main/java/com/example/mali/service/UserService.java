package com.example.mali.service;
import com.example.mali.repository.UserRepository;
import com.example.mali.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    boolean existsByUsername(String username) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Autowired
    private PasswordEncoder passwordEncoder;

    public User registerUser(String username, String password) {
        // Check if the username already exists
        if (userRepository.existsByUsername(username)) {
            throw new RuntimeException("Username already exists");
        }

        // Create a new user with encoded password
        User user = new User();
        user.setUsername(username);
        user.setPassword(passwordEncoder.encode(password));

        // Save the user to the database
        return userRepository.save(user);

    }
}
