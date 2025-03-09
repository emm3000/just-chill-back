package com.emm.justchill.features.user.infra

import com.emm.justchill.features.user.aplication.LoginUserRequest
import com.emm.justchill.features.user.aplication.UserCreator
import com.emm.justchill.features.user.aplication.UserFinder
import com.emm.justchill.features.user.aplication.UserRequest
import com.emm.justchill.features.user.aplication.UserResponse
import org.springframework.http.ResponseEntity
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/auth")
class LoginController(
    private val userCreator: UserCreator,
    private val userFinder: UserFinder,
    private val authenticationManager: AuthenticationManager,
) {

    @PostMapping("/register")
    fun register(@RequestBody body: UserRequest): ResponseEntity<UserResponse> {
        val response: UserResponse = userCreator.create(body.name, body.email, body.password)
        return ResponseEntity.ok(response)
    }

    @PostMapping("/login")
    fun login(@RequestBody body: LoginUserRequest): ResponseEntity<UserResponse> {
        val authenticationToken = UsernamePasswordAuthenticationToken(body.email, body.password)
        authenticationManager.authenticate(authenticationToken)
        val response: UserResponse = userFinder.findBy(body.email)
        return ResponseEntity.ok(response)
    }
}