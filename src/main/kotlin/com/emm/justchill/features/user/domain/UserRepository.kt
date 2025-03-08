package com.emm.justchill.features.user.domain

interface UserRepository {

    fun create(user: User): User
}