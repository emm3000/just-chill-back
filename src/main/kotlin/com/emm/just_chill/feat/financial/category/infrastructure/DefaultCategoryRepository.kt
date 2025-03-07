package com.emm.just_chill.feat.financial.category.infrastructure

import com.emm.just_chill.feat.financial.category.domain.Category
import com.emm.just_chill.feat.financial.category.domain.CategoryRepository
import kotlin.jvm.optionals.getOrNull

class DefaultCategoryRepository(private val dbCategoryRepository: DbCategoryRepository) : CategoryRepository {

    override fun findAll(): List<Category> {
        val categoriesEntity: Iterable<CategoryEntity> = dbCategoryRepository.findAll()
        val categories: List<Category> = categoriesEntity.map(CategoryEntity::from)
        return categories
    }

    override fun findById(id: String): Category? {
        val dbCategory: CategoryEntity = dbCategoryRepository.findById(id).getOrNull() ?: return null
        val category = CategoryEntity.from(dbCategory)
        return category
    }

    override fun save(category: Category): Category {
        val categoryEntity = CategoryEntity(
            id = category.id,
            name = category.name,
        )
        dbCategoryRepository.save(categoryEntity)
        return category
    }

    override fun delete(id: String) {
        dbCategoryRepository.deleteById(id)
    }

    override fun update(category: Category): Category {
        val categoryEntity = CategoryEntity(
            id = category.id,
            name = category.name,
        )
        dbCategoryRepository.save(categoryEntity)
        return category
    }
}