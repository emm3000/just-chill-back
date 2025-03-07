package com.emm.just_chill.feat.financial.category.domain

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