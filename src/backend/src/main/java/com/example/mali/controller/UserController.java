package com.example.mali.controller;

import com.example.mali.model.User;
import com.example.mali.repository.UserRepository;
import com.example.mali.dto.LoginRequest;
import com.example.mali.dto.RegisterRequest;
import com.example.mali.dto.AuthenticationResponse;
import com.example.mali.security.JwtTokenProvider;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class UserController {

  @Autowired
  private AuthenticationManager authenticationManager;

  @Autowired
  private JwtTokenProvider jwtTokenProvider;


  @Autowired
  private UserRepository userRepository;

   @GetMapping
  public ResponseEntity<List<User>> getAllUsers() {
    List<User> users = userRepository.findAll();
    return ResponseEntity.ok(users);
  }

@GetMapping("/{id}")
  public ResponseEntity<User> getUserById(@PathVariable Long id) {
    Optional<User> optionalUser = userRepository.findById(id);
    if (optionalUser.isPresent()) {
      User user = optionalUser.get();
      return ResponseEntity.ok(user);
    } else {
      return ResponseEntity.notFound().build();
    }
  }

  @PostMapping
  public ResponseEntity<User> createUser(@RequestBody User user) {
    User createdUser = userRepository.save(user);
    return ResponseEntity.status(HttpStatus.CREATED).body(createdUser);
  }

  @PutMapping("/{id}")
  public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User user) {
    Optional<User> optionalUser = userRepository.findById(id);
    if (optionalUser.isPresent()) {
      User existingUser = optionalUser.get();
      existingUser.setUsername(user.getUsername());
      existingUser.setEmail(user.getEmail());
      // Update other properties as needed
      User updatedUser = userRepository.save(existingUser);
      return ResponseEntity.ok(updatedUser);
    } else {
      return ResponseEntity.notFound().build();
    }
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
    Optional<User> optionalUser = userRepository.findById(id);
    if (optionalUser.isPresent()) {
      User user = optionalUser.get();
      userRepository.delete(user);
      return ResponseEntity.noContent().build();
    } else {
      return ResponseEntity.notFound().build();
    }
  }
  
  @PostMapping("/login")
  public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
    try {
      Authentication authentication = authenticationManager.authenticate(
        new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));
      
      SecurityContextHolder.getContext().setAuthentication(authentication);
      String jwt = jwtTokenProvider.generateToken(authentication);
      
      return ResponseEntity.ok(new AuthenticationResponse(jwt));
    } catch (AuthenticationException e) {
      return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
    }
  }

  @PostMapping("/register")
  public ResponseEntity<?> register(@RequestBody RegisterRequest registerRequest) {
    if (userRepository.existsByUsername(registerRequest.getUsername())) {
      return ResponseEntity.status(HttpStatus.CONFLICT).body("Username already exists");
    }
    
    User user = new User();
    user.setUsername(registerRequest.getUsername());
    user.setPassword(registerRequest.getPassword());
    userRepository.save(user);
    
    return ResponseEntity.ok("User registered successfully");
  }
}
