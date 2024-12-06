package com.emm.just_chill.feat.auth

import org.springframework.data.repository.findByIdOrNull
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import java.util.*

@RestController
class UserController(private val userRepository: UserRepository) {

    @PostMapping("/users")
    fun createUser(@RequestBody userRequest: UserRequest): ResponseEntity<UserEntity> {
        val userEntity = UserEntity(
            id = UUID.randomUUID().toString(),
            name = userRequest.name,
            email = userRequest.email,
            password = userRequest.password,
        )
        userRepository.save(userEntity)
        return ResponseEntity.ok().body(userEntity)
    }

    @GetMapping("/users")
    fun list(): ResponseEntity<List<UserResponse>> {
        val usersResponse: List<UserResponse> = userRepository.findAll().map(UserResponse::from)
        return ResponseEntity.ok().body(usersResponse)
    }

    @GetMapping("/users/{id}")
    fun find(@PathVariable id: String): ResponseEntity<UserResponse> {
        val maybeUser: UserEntity = userRepository
            .findByIdOrNull(id)
            ?: return ResponseEntity.notFound().build()
        val userResponse: UserResponse = UserResponse.from(maybeUser)
        return ResponseEntity.ok().body(userResponse)
    }

    @PutMapping("/users/{id}")
    fun updateUser(
        @RequestBody userRequest: UserRequest,
        @PathVariable id: String,
    ): ResponseEntity<UserEntity> {
        val userEntity = UserEntity(
            id = id,
            name = userRequest.name,
            email = userRequest.email,
            password = userRequest.password,
        )
        userRepository.save(userEntity)
        return ResponseEntity.ok().body(userEntity)
    }

    @DeleteMapping("/users/{id}")
    fun deleteUser(@PathVariable id: String): ResponseEntity<Map<*, *>> {
        userRepository.deleteById(id)
        val mapResponse: Map<String, Any> = mapOf("wasDeleted" to true)
        return ResponseEntity.ok().body(mapResponse)
    }
}