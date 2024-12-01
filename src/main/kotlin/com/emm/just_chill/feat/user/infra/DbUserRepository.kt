package com.emm.just_chill.feat.user.infra

import com.emm.just_chill.feat.user.domain.User
import com.emm.just_chill.feat.user.domain.UserRepository
import org.springframework.data.repository.findByIdOrNull

class DbUserRepository(
    private val repository: UserJpaRepository,
): UserRepository {

    override fun create(user: User): User {
        val newUser = UserEntity(
            id = user.id,
            name = user.name,
            email = user.email,
        )
        repository.save(newUser)
        return user
    }

    override fun all(): List<User> {
        return repository.findAll().map(::toDomain)
    }

    override fun findById(id: String): User? {
        val user: UserEntity? = repository.findByIdOrNull(id)
        return user?.let(::toDomain)
    }

    override fun delete(id: String): Boolean {
        repository.deleteById(id)
        return true
    }

    override fun update(user: User): User {
        val currentUser: User = repository.findByIdOrNull(user.id)?.let(::toDomain)
            ?: throw IllegalArgumentException("User with id ${user.id} not found")

        val userUpdated = currentUser.copy(name = user.name, email = user.email)
        val newUser = UserEntity(
            id = userUpdated.id,
            name = userUpdated.name,
            email = userUpdated.email,
        )
        repository.save(newUser)
        return userUpdated
    }

    private fun toDomain(userEntity: UserEntity) = User(
        id = userEntity.id,
        name = userEntity.name,
        email = userEntity.email,
    )
}