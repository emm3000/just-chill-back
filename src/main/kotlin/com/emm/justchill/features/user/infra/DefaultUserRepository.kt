package com.emm.justchill.features.user.infra

import com.emm.justchill.features.user.domain.User
import com.emm.justchill.features.user.domain.UserRepository

class DefaultUserRepository(private val dbRepository: CrudUserRepository) : UserRepository {

    override fun create(user: User): User {
        val userEntity = UserEntity(
            userId = user.userId,
            name = user.name,
            email = user.email,
            password = user.password,
        )
        userEntity.markAsNew()
        dbRepository.save(userEntity)
        return user
    }
}