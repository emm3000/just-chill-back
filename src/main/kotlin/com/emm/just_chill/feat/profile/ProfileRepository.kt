package com.emm.just_chill.feat.profile

import org.springframework.data.jpa.repository.JpaRepository

interface ProfileRepository: JpaRepository<ProfileEntity, String>