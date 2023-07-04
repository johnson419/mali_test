package com.example.mali.security;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

public class UserPrincipal implements UserDetails {

    private String username;
    private String password;

    // Constructor, getters, and setters

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // Return the user's authorities/roles
        // You can customize this method based on your application's logic
        return null;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    // Implement the remaining methods of UserDetails interface

    @Override
    public boolean isAccountNonExpired() {
        // Return whether the user's account is not expired
        // You can customize this method based on your application's logic
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        // Return whether the user's account is not locked
        // You can customize this method based on your application's logic
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        // Return whether the user's credentials are not expired
        // You can customize this method based on your application's logic
        return true;
    }

    @Override
    public boolean isEnabled() {
        // Return whether the user is enabled
        // You can customize this method based on your application's logic
        return true;
    }

    public String getUserName() {
        return username;
    }

}
