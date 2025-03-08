package com.emm.justchill.feat.features.category.application

import com.emm.justchill.feat.features.category.domain.CategoryRepository

class CategoryDeleter(private val repository: CategoryRepository) {

    fun delete(categoryId: String) {
        repository.delete(categoryId)
    }
}