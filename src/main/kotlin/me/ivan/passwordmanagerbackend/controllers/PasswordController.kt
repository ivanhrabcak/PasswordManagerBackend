package me.ivan.passwordmanagerbackend.controllers

import me.ivan.passwordmanagerbackend.services.PasswordService
import me.ivan.passwordmanagerbackend.models.PasswordModel
import me.ivan.passwordmanagerbackend.security.AuthenticationUtils
import me.ivan.passwordmanagerbackend.security.isAuthenticated
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping(value = ["/password"])
class PasswordController(var passwordService: PasswordService) {
    @isAuthenticated
    @GetMapping(value = [""])
    fun get(): List<PasswordModel> {
        return passwordService.getAllWithUsername(AuthenticationUtils.getUsername())
    }

    @isAuthenticated
    @PostMapping(value = [""])
    fun add(@RequestParam username: String, @RequestParam password: String, @RequestParam url: String): PasswordModel {
        return passwordService.add(username, password, url, AuthenticationUtils.getUsername())
    }

    @isAuthenticated
    @GetMapping(value = ["/{passwordId}"])
    fun get(@PathVariable passwordId: Long): PasswordModel? {
        return passwordService.findById(passwordId)
    }
}