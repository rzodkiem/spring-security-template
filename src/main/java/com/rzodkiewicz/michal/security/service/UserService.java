package com.rzodkiewicz.michal.security.service;


import com.rzodkiewicz.michal.security.domain.User;

public interface UserService {

    User findOneByUsername(String username);

}
