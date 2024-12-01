package com.emm.just_chill.feat.user.application

import com.emm.just_chill.feat.user.domain.UserRepository

class UserDeleter(private val repository: UserRepository) {

    fun delete(id: String): Boolean {
        return repository.delete(id)
    }
}