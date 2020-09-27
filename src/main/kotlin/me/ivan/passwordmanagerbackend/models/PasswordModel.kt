package me.ivan.passwordmanagerbackend.models

import javax.persistence.*

@Entity
@Table(name = "passwords")
class PasswordModel(
        @GeneratedValue(strategy = GenerationType.AUTO)
        @Id
        var id: Long,

       var username: String,
       var password: String,
       var url: String
) {
        constructor(username: String, password: String, url: String) : this(-1, username, password, url)
}