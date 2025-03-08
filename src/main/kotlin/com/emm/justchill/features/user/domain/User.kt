package com.emm.justchill.features.user.domain

data class User(
    val userId: String,
    val name: String,
    val email: String,
    val password: String,
)