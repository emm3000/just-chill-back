package com.emm.justchill.features.user.domain

interface UserRepository {

    fun create(user: User): User

    fun findByEmail(email: String): User?
}