package com.rzodkiewicz.michal.security;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
class UserDto {

    private String username;

    private String password;

    private String passwordRepeated;
}
