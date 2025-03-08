package com.emm.justchill.features.category.infra

import com.emm.justchill.features.category.domain.Category

object CategoryEntityFactory {

    fun createFrom(category: Category): CategoryEntity {
        val categoryEntity = CategoryEntity(
            categoryId = category.id,
            userId = category.userId,
            name = category.name,
            type = category.type.name,
        )
        categoryEntity.markAsNew()
        return categoryEntity
    }
}