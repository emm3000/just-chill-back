package com.emm.just_chill.feat.profile

import java.time.LocalDate

data class ProfileResponse(
    val id: String,
    val address: String,
    val birthDate: LocalDate,
    val profilePicture: String,
) {

    companion object {

        fun from(profileEntity: ProfileEntity) = ProfileResponse(
            id = profileEntity.id,
            address = profileEntity.address,
            birthDate = profileEntity.birthDate,
            profilePicture = profileEntity.profilePicture,
        )
    }
}