package com.emm.justchill.features.user.domain

fun interface Transformable {

    fun transform(input: String): String
}