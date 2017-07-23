package com.rzodkiewicz.michal.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping(value = "/user")
class UserController {

    private final UserService userService;

    @Autowired
    UserController(UserService userService){
        this.userService = userService;
    }


    @PostMapping(value = "/create", consumes = "application/json")
    ResponseEntity<Optional> createUser(UserDto dto){
        try {
            userService.validateUserDto(dto);
            User createdUser = userService.createUser(dto);
            return ResponseEntity.ok().body(Optional.of(createdUser));
        } catch (UserException e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Optional.of(e));
        }

    }



}
