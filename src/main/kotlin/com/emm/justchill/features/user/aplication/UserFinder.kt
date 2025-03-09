package com.emm.justchill.features.user.aplication

import com.emm.justchill.features.user.domain.TokenProvider
import com.emm.justchill.features.user.domain.User
import com.emm.justchill.features.user.domain.UserRepository
import org.springframework.data.crossstore.ChangeSetPersister

class UserFinder(
    private val repository: UserRepository,
    private val tokenProvider: TokenProvider,
) {

    fun findBy(email: String): UserResponse {
        val user: User = repository.findByEmail(email) ?: throw ChangeSetPersister.NotFoundException()
        val tokenProvide: String = tokenProvider.provide(user)
        return UserResponse(tokenProvide)
    }
}