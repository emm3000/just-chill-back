package com.emm.justchill.features.category.application

import com.emm.justchill.features.category.domain.CategoryRepository

class CategoryDeleter(private val repository: CategoryRepository) {

    fun delete(categoryId: String) {
        repository.delete(categoryId)
    }
}