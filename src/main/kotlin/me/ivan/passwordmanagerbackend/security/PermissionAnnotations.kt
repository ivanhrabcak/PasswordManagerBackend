package me.ivan.passwordmanagerbackend.security

import org.springframework.security.access.prepost.PreAuthorize

@PreAuthorize("isAuthenticated()")
annotation class isAuthenticated