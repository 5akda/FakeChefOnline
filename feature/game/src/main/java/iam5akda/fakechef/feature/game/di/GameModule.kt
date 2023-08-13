package iam5akda.fakechef.feature.game.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent
import iam5akda.fakechef.core.common.facade.GameModuleFacade
import iam5akda.fakechef.feature.game.navigation.GameModuleFacadeImpl

@Module
@InstallIn(ActivityRetainedComponent::class)
object GameModule {

    @Provides
    fun provideModuleFacade(
        gameModuleFacadeImpl: GameModuleFacadeImpl
    ): GameModuleFacade = gameModuleFacadeImpl
}