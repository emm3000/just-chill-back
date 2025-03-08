package com.emm.justchill.features.category.application

import com.emm.justchill.features.category.domain.Category
import com.emm.justchill.features.category.domain.CategoryRepository

class CategoryFinder(private val repository: CategoryRepository) {

    fun findBy(id: String): Category {
        val category: Category = repository.findById(id)
            ?: throw IllegalArgumentException("Category with id $id not found")
        return category
    }
}