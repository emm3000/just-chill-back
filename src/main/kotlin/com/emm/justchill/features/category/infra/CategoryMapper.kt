package com.emm.justchill.features.category.infra

import com.emm.justchill.features.category.domain.Category
import com.emm.justchill.features.share.domain.TransactionType

fun CategoryEntity.toDomain() = Category(
    id = categoryId,
    name = name,
    userId = userId,
    type = TransactionType.valueOf(type),
)