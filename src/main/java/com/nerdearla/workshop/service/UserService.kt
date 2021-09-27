package com.nerdearla.workshop.service

import com.nerdearla.workshop.model.User
import org.springframework.stereotype.Service

@Service
class UserService {
    fun findValidUser(userId: String?): User {
        return User(userId)
    }
}
