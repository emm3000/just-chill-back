package com.emm.just_chill.feat.user.application

import com.emm.just_chill.feat.user.domain.User
import com.emm.just_chill.feat.user.domain.UserRepository

class UserUpdater(private val repository: UserRepository) {

    fun update(user: User): User {
        return repository.update(user)
    }
}