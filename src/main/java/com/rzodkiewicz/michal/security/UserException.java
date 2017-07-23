package com.rzodkiewicz.michal.security;


class UserException extends Exception{

    UserException(String message){
        super(message);
    }

    UserException(UserError error){
        super(error.message);
    }

    enum UserError{

        PASSWORDS_NOT_MATCH("Passwords have to be the same"),
        USER_ALREADY_EXISTS("User with such username already exists");


        private String message;

        UserError(String message){
            this.message = message;
        }
    }
}
