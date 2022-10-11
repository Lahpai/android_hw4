package com.example.signin

import java.io.Serializable

data class User (var firstName: String, var lastName: String, var emailId: String, var passwordId: String) :
    Serializable {
    override fun toString(): String {
        return "firstName $firstName lastName $lastName email $emailId password $passwordId"
    }
}
