package me.ivan.passwordmanagerbackend.services

import me.ivan.passwordmanagerbackend.repositories.UserRepository
import org.springframework.stereotype.Service

@Service
class UserService(var userRepository: UserRepository) {
    fun getAll(): List<UserModel> {
        return userRepository.findAll()
    }

    fun findByUsernameAndPassword(username: String, password: String): List<UserModel> {
        return userRepository.findUserModelsByUsernameEqualsAndPasswordEquals(username, password)
    }
}