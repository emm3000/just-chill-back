package com.emm.just_chill.feat.user.application

import com.emm.just_chill.feat.user.domain.User
import com.emm.just_chill.feat.user.domain.UserRepository
import java.util.UUID

class UserCreator(private val repository: UserRepository) {

    fun create(name: String, email: String): User {
        val newUser = User(
            id = UUID.randomUUID().toString(),
            name = name,
            email = email,
        )
        return repository.create(newUser)
    }
}