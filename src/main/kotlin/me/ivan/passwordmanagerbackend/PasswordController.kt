package me.ivan.passwordmanagerbackend

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping(value = ["/password"])
class PasswordController {
    @GetMapping(value = [""])
    fun get(@RequestParam test: String): String {
        return test
    }
}