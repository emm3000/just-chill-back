package com.emm.justchill.features.user.infra

import com.emm.justchill.features.share.infra.BasePersist
import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Column
import org.springframework.data.relational.core.mapping.Table

@Table("users")
class UserEntity(

    @Id
    @Column("user_id")
    val userId: String,

    val name: String,

    val email: String,

    @Column("password_hash")
    val password: String,
) : BasePersist<String>(userId)