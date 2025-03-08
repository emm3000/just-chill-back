package com.emm.justchill.di

import com.emm.justchill.features.category.application.CategoryCreator
import com.emm.justchill.features.category.application.CategoryDeleter
import com.emm.justchill.features.category.application.CategoryFetcher
import com.emm.justchill.features.category.application.CategoryFinder
import com.emm.justchill.features.category.domain.CategoryRepository
import com.emm.justchill.features.category.infra.CrudCategoryRepository
import com.emm.justchill.features.category.infra.DefaultCategoryRepository
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class CategoryModule {

    @Bean
    fun categoryRepository(
        crudCategoryRepository: CrudCategoryRepository,
    ): CategoryRepository = DefaultCategoryRepository(crudCategoryRepository)

    @Bean
    fun categoryDeleter(repository: CategoryRepository) = CategoryDeleter(repository)

    @Bean
    fun categoryCreator(repository: CategoryRepository) = CategoryCreator(repository)

    @Bean
    fun categoryFinder(repository: CategoryRepository) = CategoryFinder(repository)

    @Bean
    fun categoryFetcher(repository: CategoryRepository) = CategoryFetcher(repository)
}