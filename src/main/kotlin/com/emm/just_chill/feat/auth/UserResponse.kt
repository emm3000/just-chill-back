package com.emm.just_chill.feat.auth

data class UserResponse(
    val id: String,
    val name: String,
    val email: String,
) {

    companion object {

        fun from(userEntity: UserEntity): UserResponse {
            return UserResponse(
                id = userEntity.id,
                name = userEntity.name,
                email = userEntity.email,
            )
        }
    }
}