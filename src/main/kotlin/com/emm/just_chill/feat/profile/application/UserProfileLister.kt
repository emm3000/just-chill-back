package com.emm.just_chill.feat.profile.application

import com.emm.just_chill.feat.profile.domain.UserProfile
import com.emm.just_chill.feat.profile.domain.UserProfileRepository

class UserProfileLister(private val repository: UserProfileRepository) {

    fun list(): List<UserProfile> {
        return repository.findAll()
    }
}