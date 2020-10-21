package me.ivan.passwordmanagerbackend

import org.springframework.boot.context.properties.ConfigurationProperties

@ConfigurationProperties(prefix = "moje-vlastne-properties")
data class ConfigProperties(var username: String = "", var password: String = "")
