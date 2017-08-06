package com.rzodkiewicz.michal.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
class UserServiceImpl implements UserService{

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder){
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public User findOneByUsername(String username) {
        return userRepository.findOneByUsername(username);
    }

    @Override
    public User createUser(UserDto dto) {
        User newUser = User.builder()
                .username(dto.getUsername())
                .passwordHash(passwordEncoder.encode(dto.getPassword()))
                .role(new Role()) //handling only USER role initialized in Role constructor
        .build();
        userRepository.save(newUser);
        return newUser;
    }

    @Override
    public void validateUserDto(UserDto dto) throws UserException {
        if(!passwordsEquals(dto)){
            throw new UserException(UserException.UserError.PASSWORDS_NOT_MATCH);
        }

        if(usernameNonUnique(dto.getUsername())){
            throw new UserException(UserException.UserError.USER_ALREADY_EXISTS);
        }
    }

    boolean passwordsEquals(UserDto userDto){
        return userDto.getPassword().equals(userDto.getPasswordRepeated());
    }

    boolean usernameNonUnique(String username){
        return userRepository.findOneByUsername(username) != null;
    }
}
