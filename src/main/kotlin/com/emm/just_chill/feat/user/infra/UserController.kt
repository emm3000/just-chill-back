package com.emm.just_chill.feat.user.infra

import com.emm.just_chill.feat.user.application.UserCreator
import com.emm.just_chill.feat.user.application.UserDeleter
import com.emm.just_chill.feat.user.application.UserFinder
import com.emm.just_chill.feat.user.application.UserLister
import com.emm.just_chill.feat.user.application.UserUpdater
import com.emm.just_chill.feat.user.domain.User
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class UserController(
    private val userCreator: UserCreator,
    private val userLister: UserLister,
    private val userDeleter: UserDeleter,
    private val userUpdater: UserUpdater,
    private val userFinder: UserFinder,
) {

    @PostMapping("/users")
    fun createUser(@RequestBody userRequest: UserRequest): ResponseEntity<User> {
        val userCreate: User = userCreator.create(
            name = userRequest.name,
            email = userRequest.email
        )
        return ResponseEntity.ok().body(userCreate)
    }

    @GetMapping("/users")
    fun list(): ResponseEntity<List<User>> {
        val list: List<User> = userLister.list()
        return ResponseEntity.ok().body(list)
    }

    @GetMapping("/users/{id}")
    fun find(@PathVariable id: String): ResponseEntity<User?> {
        val find: User? = userFinder.find(id)
        return ResponseEntity.ok().body(find)
    }

    @PutMapping("/users/{id}")
    fun updateUser(
        @RequestBody userRequest: UserRequest,
        @PathVariable id: String,
    ): ResponseEntity<User> {
        val user = User(
            id = id,
            name = userRequest.name,
            email = userRequest.email,
        )
        val userUpdated: User = userUpdater.update(user)
        return ResponseEntity.ok().body(userUpdated)
    }

    @DeleteMapping("/users/{id}")
    fun deleteUser(@PathVariable id: String): ResponseEntity<Map<*, *>> {
        val wasDeleted: Boolean = userDeleter.delete(id)
        val mapResponse: Map<String, Any> = mapOf("wasDeleted" to wasDeleted)
        return ResponseEntity.ok().body(mapResponse)
    }
}