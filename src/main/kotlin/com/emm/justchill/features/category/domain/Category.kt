package com.emm.justchill.features.category.domain

import com.emm.justchill.features.share.domain.TransactionType
import java.util.UUID

data class Category(
    val id: String,
    val userId: String,
    val name: String,
    val type: TransactionType,
) {

    companion object {

        fun create(name: String, userId: String, type: TransactionType): Category {
            val randomId: String = UUID.randomUUID().toString()
            return Category(randomId, userId, name, type)
        }
    }
}