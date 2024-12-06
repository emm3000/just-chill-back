package com.emm.just_chill.feat.profile

import com.emm.just_chill.feat.auth.UserEntity
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
class ProfileEntity(

    @Id
    val id: String,

    @Column(nullable = false)
    val address: String,

    @Column(nullable = false, columnDefinition = "DATE")
    val birthDate: LocalDate,

    @Column(nullable = true)
    val profilePicture: String,

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    val user: UserEntity,
)