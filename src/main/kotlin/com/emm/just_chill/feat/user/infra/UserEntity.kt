package com.emm.just_chill.feat.user.infra

import com.emm.just_chill.feat.post.infra.PostEntity
import com.emm.just_chill.feat.user.domain.User
import jakarta.persistence.CascadeType
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.OneToMany
import jakarta.persistence.Table

@Entity
@Table(name = "users")
data class UserEntity(

    @Id
    val id: String,

    @Column(nullable = false)
    val name: String,

    @Column(nullable = false)
    val email: String,

    @OneToMany(mappedBy = "user", cascade = [CascadeType.ALL], orphanRemoval = true)
    val posts: MutableList<PostEntity> = mutableListOf(),
) {

    companion object {

        fun from(user: User) = UserEntity(
            id = user.id,
            name = user.name,
            email = user.email,
        )
    }
}