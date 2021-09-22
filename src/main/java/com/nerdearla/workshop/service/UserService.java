package com.nerdearla.workshop.service;

import com.nerdearla.workshop.model.User;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    public User findValidUser(String userId) {
        return new User(userId);
    }
}
