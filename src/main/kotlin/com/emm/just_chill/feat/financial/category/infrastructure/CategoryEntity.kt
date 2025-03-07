package com.emm.just_chill.feat.financial.category.infrastructure

import com.emm.just_chill.feat.financial.category.domain.Category
import jakarta.persistence.Id
import org.springframework.data.relational.core.mapping.Table

@Table(name = "categories")
class CategoryEntity(
    @Id
    val id: String,
    val name: String,
) {

    companion object {

        fun from(categoryEntity: CategoryEntity) = Category(
            id = categoryEntity.id,
            name = categoryEntity.name
        )
    }
}