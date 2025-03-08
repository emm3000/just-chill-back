package com.emm.justchill.features.user.infra

import com.emm.justchill.features.user.aplication.UserCreator
import com.emm.justchill.features.user.aplication.UserRequest
import com.emm.justchill.features.user.domain.User
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class RestController(
    private val userCreator: UserCreator,
) {

    @PostMapping("/users")
    fun create(user: UserRequest): ResponseEntity<User> {
        val userCreated: User = userCreator.create(
            name = user.name,
            email = user.email,
            password = user.password,
        )
        return ResponseEntity.ok().body(userCreated)
    }
}