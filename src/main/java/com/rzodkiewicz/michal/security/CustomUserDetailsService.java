package com.rzodkiewicz.michal.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
class CustomUserDetailsService implements UserDetailsService{

    private final UserService userService;

    @Autowired
    public CustomUserDetailsService(UserService userService){
        this.userService = userService;
    }

    
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if(username.trim().isEmpty()){
            throw new UsernameNotFoundException("username is an empty string");
        }

        User user = userService.findOneByUsername(username);

        if(null == user){
            throw new UsernameNotFoundException("User " + username + " not found");
        }

        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPasswordHash(), getGrantedAuthorities(user));


    }

    private List<GrantedAuthority> getGrantedAuthorities(User user){
        return Arrays.asList(new SimpleGrantedAuthority(user.getRole().getName()));
    }
}
