package com.emm.justchill.features.category.application

import com.emm.justchill.features.category.domain.Category
import com.emm.justchill.features.category.domain.CategoryRepository

class CategoryFetcher(private val categoryRepository: CategoryRepository) {

    fun fetch(): List<Category> = categoryRepository.findAll()
}