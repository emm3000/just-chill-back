package com.emm.just_chill.feat.financial.category.application

import com.emm.just_chill.feat.financial.category.domain.CategoryRepository

class CategoryDeleter(private val repository: CategoryRepository) {

    fun delete(categoryId: String) {
        repository.delete(categoryId)
    }
}