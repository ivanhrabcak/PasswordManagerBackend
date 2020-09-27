package me.ivan.passwordmanagerbackend

import me.ivan.passwordmanagerbackend.models.PasswordModel
import org.springframework.data.repository.CrudRepository

interface PasswordRepository : CrudRepository<PasswordModel, Long> {

}