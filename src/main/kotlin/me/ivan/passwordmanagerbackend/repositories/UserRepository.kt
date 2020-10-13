package me.ivan.passwordmanagerbackend.repositories

import me.ivan.passwordmanagerbackend.models.UserModel
import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository : JpaRepository<UserModel, Long> {
    fun findUserModelsByUsernameEqualsAndPasswordEquals(username: String, password: String): List<UserModel> // :DD
}