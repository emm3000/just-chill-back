package com.emm.justchill.feat.features.category.domain

import java.util.UUID

data class Category(
    val id: String,
    val name: String,
) {

    companion object {

        fun create(name: String): Category {
            val randomId: String = UUID.randomUUID().toString()
            return Category(randomId, name)
        }
    }
}