package com.emm.justchill.features.user.infra

import com.emm.justchill.features.share.infra.BasePersist
import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Column
import org.springframework.data.relational.core.mapping.Table
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.UserDetails

@Table("users")
class UserEntity(

    @Id
    @Column("user_id")
    val userId: String,

    val name: String,

    val email: String,

    @Column("password_hash")
    @JvmField
    val password: String,

    val role: String,

) : BasePersist<String>(userId), UserDetails {

    override fun getAuthorities(): List<SimpleGrantedAuthority> {
        return listOf(SimpleGrantedAuthority(role))
    }

    override fun getPassword(): String = password

    override fun getUsername(): String = email
}