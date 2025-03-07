package com.emm.just_chill.feat.financial.category.application

import com.emm.just_chill.feat.financial.category.domain.Category
import com.emm.just_chill.feat.financial.category.domain.CategoryRepository

class CategoryFinder(private val repository: CategoryRepository) {

    fun findBy(id: String): Category {
        val category: Category = repository.findById(id)
            ?: throw IllegalArgumentException("Category with id $id not found")
        return category
    }
}