package com.emm.just_chill.feat.user.application

import com.emm.just_chill.feat.user.domain.User
import com.emm.just_chill.feat.user.domain.UserRepository

class UserLister(private val repository: UserRepository) {

    fun list(): List<User> {
        return repository.all()
    }
}