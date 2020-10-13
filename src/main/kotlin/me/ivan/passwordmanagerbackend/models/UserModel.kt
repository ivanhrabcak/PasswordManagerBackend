package me.ivan.passwordmanagerbackend.models

import javax.persistence.*

@Entity
@Table(name = "users")
class UserModel(
        @GeneratedValue(strategy = GenerationType.AUTO)
        @Id
        var id: Long,

        var username: String,
        var password: String
)