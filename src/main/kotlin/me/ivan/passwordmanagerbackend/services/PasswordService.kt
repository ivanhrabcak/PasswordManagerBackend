package me.ivan.passwordmanagerbackend.services

import me.ivan.passwordmanagerbackend.repositories.PasswordRepository
import me.ivan.passwordmanagerbackend.models.PasswordModel
import org.springframework.stereotype.Service

@Service
class PasswordService(var passwordRepository: PasswordRepository) {
    fun getAll(): List<PasswordModel> {
        return passwordRepository.findAll().toList();
    }

    fun add(userId: String, username: String, password: String, url: String): PasswordModel {
        val passwordModel : PasswordModel = PasswordModel(username, password, url);
        return passwordRepository.save(passwordModel)
    }

    fun add(passwordModel: PasswordModel): PasswordModel {
        return passwordRepository.save(passwordModel)
    }

    fun findById(id: Long): PasswordModel {
        return passwordRepository.findById(id).get()
    }

    fun findByUrl(url: String): List<PasswordModel> {
        return passwordRepository.findByUrlContains(url)
    }

    fun findByUsername(username: String): List<PasswordModel> {
        return passwordRepository.findByUsernameContains(username)
    }

    fun findByPassword(password: String): List<PasswordModel> {
        return passwordRepository.findByPasswordContains(password)
    }
}
