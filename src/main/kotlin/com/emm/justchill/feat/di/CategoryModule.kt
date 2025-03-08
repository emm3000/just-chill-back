package com.emm.justchill.feat.di

import com.emm.justchill.feat.features.category.application.CategoryCreator
import com.emm.justchill.feat.features.category.application.CategoryDeleter
import com.emm.justchill.feat.features.category.application.CategoryFetcher
import com.emm.justchill.feat.features.category.application.CategoryFinder
import com.emm.justchill.feat.features.category.domain.CategoryRepository
import com.emm.justchill.feat.features.category.infrastructure.DbCategoryRepository
import com.emm.justchill.feat.features.category.infrastructure.DefaultCategoryRepository
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class CategoryModule {

    @Bean
    fun categoryRepository(
        dbCategoryRepository: DbCategoryRepository,
    ): CategoryRepository = DefaultCategoryRepository(dbCategoryRepository)

    @Bean
    fun categoryDeleter(repository: CategoryRepository) = CategoryDeleter(repository)

    @Bean
    fun categoryCreator(repository: CategoryRepository) = CategoryCreator(repository)

    @Bean
    fun categoryFinder(repository: CategoryRepository) = CategoryFinder(repository)

    @Bean
    fun categoryFetcher(repository: CategoryRepository) = CategoryFetcher(repository)
}