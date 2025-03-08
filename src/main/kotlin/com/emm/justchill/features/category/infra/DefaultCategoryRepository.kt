package com.emm.justchill.features.category.infra

import com.emm.justchill.features.category.domain.Category
import com.emm.justchill.features.category.domain.CategoryRepository
import kotlin.jvm.optionals.getOrNull

class DefaultCategoryRepository(private val crudCategoryRepository: CrudCategoryRepository) : CategoryRepository {

    override fun findAll(): List<Category> {
        val categoriesEntity: Iterable<CategoryEntity> = crudCategoryRepository.findAll()
        val categories: List<Category> = categoriesEntity.map(CategoryEntity::toDomain)
        return categories
    }

    override fun findById(id: String): Category? {
        val dbCategory: CategoryEntity = crudCategoryRepository.findById(id).getOrNull() ?: return null
        val category = dbCategory.toDomain()
        return category
    }

    override fun save(category: Category): Category {
        val categoryEntity = CategoryEntityFactory.createFrom(category)
        categoryEntity.markAsNew()
        crudCategoryRepository.save(categoryEntity)
        return category
    }

    override fun delete(id: String) = crudCategoryRepository.deleteById(id)

    override fun update(category: Category): Category {
        val categoryEntity = CategoryEntityFactory.createFrom(category)
        crudCategoryRepository.save(categoryEntity)
        return category
    }
}