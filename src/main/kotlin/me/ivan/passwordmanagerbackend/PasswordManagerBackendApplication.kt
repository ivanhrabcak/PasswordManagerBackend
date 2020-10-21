package me.ivan.passwordmanagerbackend

import me.ivan.passwordmanagerbackend.controllers.PasswordController
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.ConfigurationPropertiesScan
import org.springframework.boot.runApplication

@SpringBootApplication
@ConfigurationPropertiesScan
class PasswordManagerBackendApplication

fun main(args: Array<String>) {
	runApplication<PasswordManagerBackendApplication>(*args)

	// var db = Database("coxhofhjrmimai", "110490a42272c17b42677f24a99cba246ec8bd7d47b6f44a06c380e25c713449")
}
