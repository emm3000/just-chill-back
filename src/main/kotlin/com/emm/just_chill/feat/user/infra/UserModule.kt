package com.emm.just_chill.feat.user.infra

import com.emm.just_chill.feat.user.application.UserCreator
import com.emm.just_chill.feat.user.application.UserDeleter
import com.emm.just_chill.feat.user.application.UserFinder
import com.emm.just_chill.feat.user.application.UserLister
import com.emm.just_chill.feat.user.application.UserUpdater
import com.emm.just_chill.feat.user.domain.UserRepository
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class UserModule {

    @Bean
    fun provideUserRepository(
        repository: UserJpaRepository,
    ): UserRepository = DbUserRepository(repository)

    @Bean
    fun provideUserCreator(repository: UserRepository): UserCreator = UserCreator(repository)

    @Bean
    fun provideUserLister(repository: UserRepository) = UserLister(repository)

    @Bean
    fun provideUserUpdater(repository: UserRepository) = UserUpdater(repository)

    @Bean
    fun provideUserDeleter(repository: UserRepository) = UserDeleter(repository)

    @Bean
    fun provideUserFinder(repository: UserRepository) = UserFinder(repository)
}