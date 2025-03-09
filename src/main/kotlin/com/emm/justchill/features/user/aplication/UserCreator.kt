package com.emm.justchill.features.user.aplication

import com.emm.justchill.features.user.domain.Transformable
import com.emm.justchill.features.user.domain.Role
import com.emm.justchill.features.user.domain.TokenProvider
import com.emm.justchill.features.user.domain.User
import com.emm.justchill.features.user.domain.UserRepository
import java.util.UUID

class UserCreator(
    private val repository: UserRepository,
    private val transformable: Transformable,
    private val tokenProvider: TokenProvider,
) {

    fun create(name: String, email: String, password: String): UserResponse {
        val passwordEncoded: String = transformable.transform(password)
        val user = User(
            userId = UUID.randomUUID().toString(),
            name = name,
            email = email,
            password = passwordEncoded,
            role = Role.User,
        )
        repository.create(user)
        val token: String = tokenProvider.provide(user)
        return UserResponse(token)
    }
}