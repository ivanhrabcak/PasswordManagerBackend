package me.ivan.passwordmanagerbackend

import me.ivan.passwordmanagerbackend.models.PasswordModel
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping(value = ["/password"])
class PasswordController(var passwordService: PasswordService) {
    @GetMapping(value = [""])
    fun get(): List<PasswordModel> {
        return passwordService.getAll()
    }

    @GetMapping(value = ["/add"])
    fun add(@RequestParam username: String, @RequestParam password: String, @RequestParam url: String): PasswordModel {
        return passwordService.add(username, password, url)
    }

}