package me.ivan.passwordmanagerbackend.controllers

import me.ivan.passwordmanagerbackend.services.PasswordService
import me.ivan.passwordmanagerbackend.models.PasswordModel
import org.springframework.web.bind.annotation.*

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

    @PostMapping(value = ["/query"])
    fun query(@RequestParam token: String, @RequestParam query: String, @RequestParam field: String): List<PasswordModel> {
        if (field == "url") {
            return passwordService.findByUrl(query)
        }
        else if (field == "password") {
            return passwordService.findByPassword(query)
        }
        else if (field == "username") {
            return passwordService.findByUsername(query)
        }
        return emptyList()
    }

}