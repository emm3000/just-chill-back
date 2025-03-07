package com.emm.just_chill.feat.financial.category.application

import com.emm.just_chill.feat.financial.category.domain.Category
import com.emm.just_chill.feat.financial.category.domain.CategoryRepository

class CategoryFetcher(private val categoryRepository: CategoryRepository) {

    fun fetch(): List<Category> = categoryRepository.findAll()
}