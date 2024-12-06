package com.emm.just_chill.feat.profile

import com.emm.just_chill.feat.auth.UserEntity
import com.emm.just_chill.feat.auth.UserRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import java.time.LocalDate
import java.util.*

@RestController
class ProfileController(
    private val profileRepository: ProfileRepository,
    private val userRepository: UserRepository,
) {

    @PostMapping("/user-profile")
    fun createUser(@RequestBody profileRequest: ProfileRequest): ResponseEntity<ProfileEntity> {
        val userEntity: UserEntity = userRepository
            .findByIdOrNull(profileRequest.userId)
            ?: return ResponseEntity.notFound().build()

        val profileEntity = ProfileEntity(
            id = UUID.randomUUID().toString(),
            address = profileRequest.address,
            birthDate = LocalDate.now(),
            profilePicture = profileRequest.picture,
            user = userEntity,
        )
        profileRepository.save(profileEntity)
        return ResponseEntity.ok().body(profileEntity)
    }

    @GetMapping("/user-profile")
    fun list(): ResponseEntity<List<ProfileResponse>> {
        val profiles: List<ProfileResponse> = profileRepository.findAll().map(ProfileResponse::from)
        return ResponseEntity.ok().body(profiles)
    }
}