package com.emm.just_chill.feat.profile.domain

import com.emm.just_chill.feat.user.domain.User
import java.time.LocalDate

data class UserProfile(
    val id: String,
    val address: String,
    val birthDate: LocalDate,
    val profilePicture: String,
    val user: User,
)