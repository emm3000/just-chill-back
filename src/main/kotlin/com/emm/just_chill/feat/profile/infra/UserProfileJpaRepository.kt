package com.emm.just_chill.feat.profile.infra

import org.springframework.data.jpa.repository.JpaRepository

interface UserProfileJpaRepository: JpaRepository<UserProfileEntity, String>