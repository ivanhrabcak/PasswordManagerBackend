package me.ivan.passwordmanagerbackend

import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.security.oauth2.jwt.Jwt
import org.springframework.stereotype.Component

@Component
class AuthenticationUtils {
    companion object {
        private const val USERNAME_CLAIM_NAME = "sub"
    }

    fun getUsername(): String? {
        val authentication = SecurityContextHolder.getContext().authentication
        val principal = authentication.credentials as Jwt
        val claims = principal.claims
        if (!claims.containsKey(USERNAME_CLAIM_NAME)) {
            return null
        }

        return claims.get(USERNAME_CLAIM_NAME) as String
    }
}
