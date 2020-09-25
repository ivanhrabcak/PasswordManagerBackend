package me.ivan.passwordmanagerbackend

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class PasswordManagerBackendApplication

fun main(args: Array<String>) {
	runApplication<PasswordManagerBackendApplication>(*args)
}
