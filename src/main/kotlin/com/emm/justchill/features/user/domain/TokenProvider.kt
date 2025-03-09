package com.emm.justchill.features.user.domain

fun interface TokenProvider {

    fun provide(user: User): String
}