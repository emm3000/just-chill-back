package com.emm.justchill.features.user.infra

import org.springframework.data.repository.CrudRepository

interface CrudUserRepository: CrudRepository<UserEntity, String>