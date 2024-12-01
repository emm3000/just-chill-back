package com.emm.just_chill.feat.user.infra

import org.springframework.data.jpa.repository.JpaRepository

interface UserJpaRepository: JpaRepository<UserEntity, String>