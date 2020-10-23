package me.ivan.passwordmanagerbackend.repositories

import me.ivan.passwordmanagerbackend.models.PasswordModel
import org.springframework.data.repository.CrudRepository

interface PasswordRepository : CrudRepository<PasswordModel, Long> {
    fun findAllByOwnerUsername(username: String?): List<PasswordModel>
}