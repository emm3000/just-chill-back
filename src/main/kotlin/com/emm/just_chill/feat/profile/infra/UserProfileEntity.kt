package com.emm.just_chill.feat.profile.infra

import com.emm.just_chill.feat.profile.domain.UserProfile
import com.emm.just_chill.feat.user.infra.UserEntity
import jakarta.persistence.CascadeType
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.FetchType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.OneToOne
import jakarta.persistence.Table
import java.time.LocalDate

@Entity
@Table(name = "user_profile")
class UserProfileEntity(

    @Id
    val id: String,

    @Column(nullable = false)
    val address: String,

    @Column(nullable = false, columnDefinition = "DATE")
    val birthDate: LocalDate,

    @Column(nullable = true)
    val profilePicture: String,

    @OneToOne(cascade = [CascadeType.ALL], fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    val user: UserEntity,
) {

    companion object {

        fun from(userProfile: UserProfile) = UserProfileEntity(
            id = userProfile.id,
            address = userProfile.address,
            birthDate = userProfile.birthDate,
            profilePicture = userProfile.profilePicture,
            user = UserEntity.from(userProfile.user),
        )
    }
}