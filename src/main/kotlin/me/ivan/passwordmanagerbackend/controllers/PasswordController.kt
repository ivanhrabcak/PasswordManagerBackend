package me.ivan.passwordmanagerbackend.controllers

import me.ivan.passwordmanagerbackend.AuthenticationUtils
import me.ivan.passwordmanagerbackend.ConfigProperties
import me.ivan.passwordmanagerbackend.services.PasswordService
import me.ivan.passwordmanagerbackend.models.PasswordModel
import me.ivan.passwordmanagerbackend.repositories.PasswordRepository
import org.springframework.security.access.prepost.PreAuthorize
import org.springframework.web.bind.annotation.*

// GET /password - getne vsetky passwrods
// GET /password/1 - getne password s id 1 (id je v ceste)
// POST /password - prida novy password s parametrami (parametre sa zvycajne v tele requestu)
// PUT /password/3 - prida/upadtne password s id 3 (posielas cely zoserializovany objekt)
// PATCH /password/3 - updatne password s id 3 (posielas iba casty ktore chces updatnut)
// DELETE /password/3 - zmaze password

data class AddPasswordRequest(val username: String, val password: String, val url: String)

@RestController
@RequestMapping("/password")
class PasswordController(val passwordService: PasswordService, val config: ConfigProperties, val authUtils: AuthenticationUtils) {
    @GetMapping("")
    fun get(): List<PasswordModel> {
        return passwordService.getAll()
    }

    @PreAuthorize("isAuthenticated()")
    @GetMapping("auth")
    fun getProperty(): String {
        return authUtils.getUsername() ?: "Nema username"
    }

    @GetMapping("open")
    fun getOpen(): String {
        return "Open"
    }

    @GetMapping("/{passwordId}")
    fun get(@PathVariable passwordId: Long): PasswordModel {
        return passwordService.findById(passwordId)
    }

    // @PostMapping("")
    // fun add(@RequestParam username: String, @RequestParam password: String, @RequestParam url: String): PasswordModel {
    //     return passwordService.add(username, password, url)
    // }
    @PostMapping("")
    fun add(@RequestBody request: AddPasswordRequest): PasswordModel {
        val (username, password, url) = request

        return passwordService.add(username, password, url)
    }

    @GetMapping("/query")
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
