package com.emm.justchill.features.category.infra

import org.springframework.data.repository.CrudRepository

interface DbCategoryRepository : CrudRepository<CategoryEntity, String>