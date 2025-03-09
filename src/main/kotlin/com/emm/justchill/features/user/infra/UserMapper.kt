package com.emm.justchill.features.user.infra

import com.emm.justchill.features.user.domain.Role
import com.emm.justchill.features.user.domain.User

fun UserEntity.toDomain() = User(
    userId = userId,
    name = name,
    email = email,
    role = Role.valueOf(role),
    password = password,
)