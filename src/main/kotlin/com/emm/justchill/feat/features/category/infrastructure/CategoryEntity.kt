package com.emm.justchill.feat.features.category.infrastructure

import com.emm.justchill.feat.features.category.domain.Category
import org.springframework.data.annotation.Id
import org.springframework.data.annotation.Transient
import org.springframework.data.domain.Persistable
import org.springframework.data.relational.core.mapping.Column
import org.springframework.data.relational.core.mapping.MappedCollection
import org.springframework.data.relational.core.mapping.Table

@Table(name = "categories")
class CategoryEntity(
    @Id
    @Column("category_id",)
    val categoryId: String,
    @MappedCollection
    val name: String,
): Persistable<String> {

    @Transient
    private var isNew: Boolean = false

    companion object {

        fun from(categoryEntity: CategoryEntity) = Category(
            id = categoryEntity.categoryId,
            name = categoryEntity.name
        )
    }

    fun markAsNew(): CategoryEntity {
        this.isNew = true
        return this
    }

    override fun getId(): String = categoryId

    override fun isNew(): Boolean = isNew
}