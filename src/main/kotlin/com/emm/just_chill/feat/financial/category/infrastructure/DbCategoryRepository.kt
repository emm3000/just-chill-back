package com.emm.just_chill.feat.financial.category.infrastructure

import org.springframework.data.repository.CrudRepository

interface DbCategoryRepository : CrudRepository<CategoryEntity, String>