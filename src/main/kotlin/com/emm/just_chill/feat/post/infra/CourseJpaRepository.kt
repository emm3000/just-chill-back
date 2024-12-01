package com.emm.just_chill.feat.post.infra

import org.springframework.data.jpa.repository.JpaRepository

interface CourseJpaRepository : JpaRepository<CourseEntity, String>