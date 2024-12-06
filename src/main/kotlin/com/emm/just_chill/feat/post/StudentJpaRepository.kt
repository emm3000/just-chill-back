package com.emm.just_chill.feat.post

import org.springframework.data.jpa.repository.JpaRepository

interface StudentJpaRepository : JpaRepository<StudentEntity, String>