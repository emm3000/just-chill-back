package com.emm.just_chill.feat.profile.infra

import com.emm.just_chill.feat.profile.application.UserProfileCreator
import com.emm.just_chill.feat.profile.application.UserProfileLister
import com.emm.just_chill.feat.profile.domain.UserProfile
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import java.time.LocalDate

@RestController
class UserProfileController(
    private val userProfileCreator: UserProfileCreator,
    private val userProfileLister: UserProfileLister,
) {

    @PostMapping("/user-profile")
    fun createUser(@RequestBody userProfileRequest: UserProfileRequest): ResponseEntity<UserProfile> {
        val userProfileCreated: UserProfile = userProfileCreator.create(
            address = userProfileRequest.address,
            birthDate = LocalDate.now(),
            profilePicture = userProfileRequest.picture,
            userId = userProfileRequest.userId
        )
        return ResponseEntity.ok().body(userProfileCreated)
    }

    @GetMapping("/user-profile")
    fun list(): ResponseEntity<List<UserProfile>> {
        val list: List<UserProfile> = userProfileLister.list()
        return ResponseEntity.ok().body(list)
    }
}