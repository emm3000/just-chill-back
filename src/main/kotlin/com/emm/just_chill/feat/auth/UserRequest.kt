package com.emm.just_chill.feat.auth

data class UserRequest(
    val name: String,
    val email: String,
    val password: String,
)