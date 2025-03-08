package com.emm.justchill.feat.features.category.application

import com.emm.justchill.feat.features.category.domain.Category
import com.emm.justchill.feat.features.category.domain.CategoryRepository

class CategoryCreator(private val repository: CategoryRepository) {

    fun create(name: String): Category {
        val category = Category.create(name = name)
        repository.save(category)
        return category
    }
}