package com.emm.justchill.feat.features.category.infrastructure

import org.springframework.data.repository.CrudRepository

interface DbCategoryRepository : CrudRepository<CategoryEntity, String>