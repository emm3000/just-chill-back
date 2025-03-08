package com.emm.justchill.features.category.application

import com.emm.justchill.features.category.domain.Category
import com.emm.justchill.features.category.domain.CategoryRepository
import com.emm.justchill.features.share.domain.TransactionType

class CategoryCreator(private val repository: CategoryRepository) {

    fun create(name: String, userId: String, type: String): Category {
        val category = Category.create(
            name = name,
            userId = userId,
            type = TransactionType.valueOf(type),
        )
        repository.save(category)
        return category
    }
}