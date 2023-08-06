package iam5akda.fakechef.core.realtime.di

import com.google.firebase.database.FirebaseDatabase
import dagger.Module
import dagger.Provides
import dagger.Reusable
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import iam5akda.fakechef.core.realtime.FirebaseDatabaseUtility
import iam5akda.fakechef.core.realtime.RealtimeDatabaseUtility

@Module
@InstallIn(SingletonComponent::class)
object RealtimeDatabaseModule {

    @Reusable
    @Provides
    fun providesFirebaseDatabase(): FirebaseDatabase = FirebaseDatabase.getInstance()

    @Reusable
    @Provides
    fun providesRealtimeDatabaseUtility(
        firebaseRealtimeUtility: FirebaseDatabaseUtility
    ): RealtimeDatabaseUtility = firebaseRealtimeUtility
}