package com.emm.just_chill.feat.financial.category.domain

interface CategoryRepository {

    fun findAll(): List<Category>

    fun findById(id: String): Category?

    fun save(category: Category): Category

    fun delete(id: String)

    fun update(category: Category): Category
}