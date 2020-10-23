package me.ivan.passwordmanagerbackend.models

import javax.persistence.*

@Entity
@Table(name = "passwords")
class PasswordModel(
        @GeneratedValue(strategy = GenerationType.AUTO)
        @Id
        var id: Long?,

        var ownerUsername: String?,

       var username: String?,
       var password: String?,
       var url: String?
)