package com.emm.justchill.features.category.infra

import com.emm.justchill.features.share.infra.BasePersist
import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Column
import org.springframework.data.relational.core.mapping.Table

@Table(name = "categories")
class CategoryEntity(

    @Id
    @Column("category_id")
    val categoryId: String,

    @Column("user_id")
    val userId: String,

    val name: String,

    val type: String,

) : BasePersist<String>(categoryId)