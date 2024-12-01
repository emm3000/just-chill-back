package com.emm.just_chill.feat.profile.infra

import com.emm.just_chill.feat.profile.domain.UserProfile
import com.emm.just_chill.feat.profile.domain.UserProfileRepository
import com.emm.just_chill.feat.user.domain.User
import org.springframework.data.repository.findByIdOrNull

class DbUserProfileRepository(
    private val repository: UserProfileJpaRepository,
) : UserProfileRepository {

    override fun create(userProfile: UserProfile): UserProfile {
        val userProfileEntity = UserProfileEntity.from(userProfile)
        repository.save(userProfileEntity)
        return userProfile
    }

    override fun fetchBy(id: String): UserProfile? {
        val profile: UserProfile? = repository.findByIdOrNull(id)?.let(::toDomain)
        return profile
    }

    private fun toDomain(userProfileEntity: UserProfileEntity): UserProfile {
        val user = User(
            id = userProfileEntity.user.id,
            name = userProfileEntity.user.name,
            email = userProfileEntity.user.email,
        )
        return UserProfile(
            id = userProfileEntity.id,
            address = userProfileEntity.address,
            birthDate = userProfileEntity.birthDate,
            profilePicture = userProfileEntity.profilePicture,
            user = user,
        )
    }

    override fun delete(id: String): Boolean {
        repository.deleteById(id)
        return true
    }

    override fun update(userProfile: UserProfile): UserProfile {
        return userProfile
    }

    override fun findAll(): List<UserProfile> {
        return repository.findAll().map(::toDomain)
    }
}