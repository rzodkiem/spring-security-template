package com.rzodkiewicz.michal.security;


interface UserService {

    User findOneByUsername(String username);

    User createUser(UserDto dto);

    void validateUserDto(UserDto dto) throws UserException;

}
