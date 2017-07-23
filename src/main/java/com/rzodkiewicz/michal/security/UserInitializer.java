package com.rzodkiewicz.michal.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
class UserInitializer {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder encoder;

    private final static String USERNAME = "michal";
    private final static String PASSWORD = "my$ecretPa$$";

    @Autowired
    public UserInitializer(UserRepository userRepository, BCryptPasswordEncoder encoder){
        this.userRepository = userRepository;
        this.encoder = encoder;
    }

    @PostConstruct
    public void init(){
        User user = createUser(USERNAME, PASSWORD);
        /*Role role = new Role();
        roleRepository.save(role);
        user.setRole(role);*/
        userRepository.save(user);
    }


    private User createUser(String username, String password){
        return User.builder()
                .username(username)
                .passwordHash(encoder.encode(password))
                .role(new Role())
                .build();

    }
}
