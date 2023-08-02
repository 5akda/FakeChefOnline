package iam5akda.fakechef.feature.home.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent
import dagger.hilt.android.scopes.ActivityRetainedScoped
import iam5akda.fakechef.feature.home.repository.HomeAnimationSource
import iam5akda.fakechef.feature.home.repository.HomeRepository

@Module
@InstallIn(ActivityRetainedComponent::class)
object HomeModule {

    @Provides
    @ActivityRetainedScoped
    fun provideRepository(
        animationSource: HomeAnimationSource
    ): HomeRepository = animationSource
}