package com.emm.just_chill.feat.auth

import org.springframework.data.repository.CrudRepository

interface UserRepository: CrudRepository<UserEntity, String>