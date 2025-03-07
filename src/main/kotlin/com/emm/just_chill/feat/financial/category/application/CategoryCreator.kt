package com.emm.just_chill.feat.financial.category.application

import com.emm.just_chill.feat.financial.category.domain.Category
import com.emm.just_chill.feat.financial.category.domain.CategoryRepository

class CategoryCreator(private val repository: CategoryRepository) {

    fun create(name: String): Category {
        val category = Category.create(name = name)
        repository.save(category)
        return category
    }
}