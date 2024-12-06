package com.emm.just_chill.feat.post

import org.springframework.data.jpa.repository.JpaRepository

interface PostJpaRepository : JpaRepository<PostEntity, String>