package com.emm.just_chill.feat.user.application

import com.emm.just_chill.feat.user.domain.User
import com.emm.just_chill.feat.user.domain.UserRepository

class UserFinder(private val repository: UserRepository) {

    fun find(id: String): User? {
        return repository.findById(id)
    }
}