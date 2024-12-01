package com.emm.just_chill.feat.profile.infra

import com.emm.just_chill.feat.profile.application.UserProfileCreator
import com.emm.just_chill.feat.profile.application.UserProfileLister
import com.emm.just_chill.feat.profile.domain.UserProfileRepository
import com.emm.just_chill.feat.user.application.UserFinder
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class UserProfileModule {

    @Bean
    fun provideUserProfileRepository(repository: UserProfileJpaRepository): UserProfileRepository {
        return DbUserProfileRepository(repository)
    }

    @Bean
    fun provideUserProfileCreator(
        userFinder: UserFinder,
        repository: UserProfileRepository,
    ): UserProfileCreator {
        return UserProfileCreator(repository, userFinder)
    }

    @Bean
    fun provideUserProfileLister(
        repository: UserProfileRepository,
    ): UserProfileLister {
        return UserProfileLister(repository)
    }
}