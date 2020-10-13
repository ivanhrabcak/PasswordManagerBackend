package me.ivan.passwordmanagerbackend.repositories

import me.ivan.passwordmanagerbackend.models.PasswordModel
import org.springframework.data.repository.CrudRepository

interface PasswordRepository : CrudRepository<PasswordModel, Long> {
    fun findByUrlContains(url: String): List<PasswordModel>
    fun findByPasswordContains(password: String): List<PasswordModel>
    fun findByUsernameContains(username: String): List<PasswordModel>
}