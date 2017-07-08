package com.rzodkiewicz.michal.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
class UserInitializer {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final BCryptPasswordEncoder encoder;

    private final static String USER_ROLE = "USER";
    private final static String USERNAME = "michal";
    private final static String PASSWORD = "my$ecretPa$$";

    @Autowired
    public UserInitializer(UserRepository userRepository, RoleRepository roleRepository, BCryptPasswordEncoder encoder){
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.encoder = encoder;
    }

    @PostConstruct
    public void init(){
        Role userRole = createAndSaveRole(USER_ROLE);
        User user = createUser(USERNAME, PASSWORD);
        user.setRole(userRole);
        userRepository.save(user);
    }

    private Role createAndSaveRole(String name){
        Role role = Role.builder()
                .name(name)
                .build();
        roleRepository.save(role);
        return role;
    }

    private User createUser(String username, String password){
        return User.builder()
                .username(username)
                .passwordHash(encoder.encode(password))
                .build();

    }
}
