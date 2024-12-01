package com.emm.just_chill.feat.profile.infra

data class UserProfileRequest(
    val address: String,
    val picture: String,
    val userId: String,
)