package me.ivan.passwordmanagerbackend

import me.ivan.passwordmanagerbackend.models.PasswordModel
import org.springframework.stereotype.Service

@Service
class PasswordService(var passwordRepository: PasswordRepository) {
    fun getAll(): List<PasswordModel> {
        return passwordRepository.findAll() as List<PasswordModel>;
    }

    fun add(username: String, password: String, url: String): PasswordModel {
        val passwordModel : PasswordModel = PasswordModel(username, password, url);
        return passwordRepository.save(passwordModel)
    }

    fun add(passwordModel: PasswordModel): PasswordModel {
        return passwordRepository.save(passwordModel)
    }
}