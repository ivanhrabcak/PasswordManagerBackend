package me.ivan.passwordmanagerbackend.services

import me.ivan.passwordmanagerbackend.repositories.PasswordRepository
import me.ivan.passwordmanagerbackend.models.PasswordModel
import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import java.util.*

fun <T> Optional<T>.unwrap(): T? = orElse(null)

@Service
class PasswordService(var passwordRepository: PasswordRepository) {
    fun getAllWithUsername(username: String?): List<PasswordModel> {
        return passwordRepository.findAllByOwnerUsername(username).toList();
    }

    @GetMapping
    fun findById(id: Long): PasswordModel? {
        return passwordRepository.findById(id).unwrap()
    }

    fun add(username: String, password: String, url: String, ownerUsername: String?): PasswordModel {
        val passwordModel = PasswordModel(null, username, password, ownerUsername, url);
        return passwordRepository.save(passwordModel)
    }

    fun add(passwordModel: PasswordModel): PasswordModel {
        return passwordRepository.save(passwordModel)
    }
}