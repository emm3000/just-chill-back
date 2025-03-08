package com.emm.justchill.features.user.aplication

import com.emm.justchill.features.user.domain.User
import com.emm.justchill.features.user.domain.UserRepository
import java.util.UUID

class UserCreator(private val repository: UserRepository) {

    fun create(name: String, email: String, password: String): User {
        val user = User(
            userId = UUID.randomUUID().toString(),
            name = name,
            email = email,
            password = password,
        )
        repository.create(user)
        return user
    }
}