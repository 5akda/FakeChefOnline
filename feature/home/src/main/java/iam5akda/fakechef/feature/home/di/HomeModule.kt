package iam5akda.fakechef.feature.home.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent
import iam5akda.fakechef.core.common.facade.HomeModuleFacade
import iam5akda.fakechef.feature.home.navigation.HomeModuleFacadeImpl
import iam5akda.fakechef.feature.home.repository.HomeAnimationSource
import iam5akda.fakechef.feature.home.repository.HomeRepository

@Module
@InstallIn(ActivityRetainedComponent::class)
object HomeModule {

    @Provides
    fun provideRepository(
        animationSource: HomeAnimationSource
    ): HomeRepository = animationSource

    @Provides
    fun provideModuleFacade(
        homeModuleFacadeImpl: HomeModuleFacadeImpl
    ): HomeModuleFacade = homeModuleFacadeImpl
}