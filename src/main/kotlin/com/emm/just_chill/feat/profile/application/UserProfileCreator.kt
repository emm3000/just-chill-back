package com.emm.just_chill.feat.profile.application

import com.emm.just_chill.feat.profile.domain.UserProfile
import com.emm.just_chill.feat.profile.domain.UserProfileRepository
import com.emm.just_chill.feat.user.application.UserFinder
import com.emm.just_chill.feat.user.domain.User
import java.time.LocalDate
import java.util.UUID

class UserProfileCreator(
    private val repository: UserProfileRepository,
    private val userFinder: UserFinder
) {

    fun create(
        address: String,
        birthDate: LocalDate,
        profilePicture: String,
        userId: String,
    ): UserProfile {
        val userFind: User = userFinder.find(userId) ?: throw IllegalStateException("User not found")
        val newUser = UserProfile(
            id = UUID.randomUUID().toString(),
            address = address,
            birthDate = birthDate,
            profilePicture = profilePicture,
            user = userFind
        )
        return repository.create(newUser)
    }
}