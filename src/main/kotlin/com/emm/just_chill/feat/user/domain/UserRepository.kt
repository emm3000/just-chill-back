package com.emm.just_chill.feat.user.domain

interface UserRepository {

    fun create(user: User): User

    fun all(): List<User>

    fun findById(id: String): User?

    fun delete(id: String): Boolean

    fun update(user: User): User
}