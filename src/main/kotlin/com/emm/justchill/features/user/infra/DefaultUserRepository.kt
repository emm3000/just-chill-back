package com.emm.justchill.features.user.infra

import com.emm.justchill.features.user.domain.Role
import com.emm.justchill.features.user.domain.User
import com.emm.justchill.features.user.domain.UserRepository
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException

class DefaultUserRepository(private val dbRepository: CrudUserRepository) : UserRepository {

    override fun create(user: User): User {
        val userEntity = UserEntity(
            userId = user.userId,
            name = user.name,
            email = user.email,
            password = user.password,
            role = Role.User.name
        )
        userEntity.markAsNew()
        dbRepository.save(userEntity)
        return user
    }

    override fun findByEmail(email: String): User {
        val userFound: UserEntity = dbRepository.findByEmail(email) ?: throw NotFoundException()
        return userFound.toDomain()
    }
}