package com.emm.justchill.features.category.infra

import org.springframework.data.repository.CrudRepository

interface CrudCategoryRepository : CrudRepository<CategoryEntity, String>