package com.emm.just_chill.feat.profile.domain

interface UserProfileRepository {

    fun create(userProfile: UserProfile): UserProfile

    fun fetchBy(id: String): UserProfile?

    fun delete(id: String): Boolean

    fun update(userProfile: UserProfile): UserProfile

    fun findAll(): List<UserProfile>
}