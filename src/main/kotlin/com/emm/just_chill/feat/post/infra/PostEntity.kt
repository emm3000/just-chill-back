package com.emm.just_chill.feat.post.infra

import com.emm.just_chill.feat.user.infra.UserEntity
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.persistence.Table

@Entity
@Table(name = "posts")
data class PostEntity(

    @Id
    val id: String,

    @Column(nullable = false)
    val title: String,

    @Column(nullable = false)
    val content: String,

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    val user: UserEntity,
)