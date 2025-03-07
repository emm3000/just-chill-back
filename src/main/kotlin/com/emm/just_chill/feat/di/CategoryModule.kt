package com.emm.just_chill.feat.di

import com.emm.just_chill.feat.financial.category.application.CategoryCreator
import com.emm.just_chill.feat.financial.category.application.CategoryDeleter
import com.emm.just_chill.feat.financial.category.application.CategoryFetcher
import com.emm.just_chill.feat.financial.category.application.CategoryFinder
import com.emm.just_chill.feat.financial.category.domain.CategoryRepository
import com.emm.just_chill.feat.financial.category.infrastructure.DbCategoryRepository
import com.emm.just_chill.feat.financial.category.infrastructure.DefaultCategoryRepository
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