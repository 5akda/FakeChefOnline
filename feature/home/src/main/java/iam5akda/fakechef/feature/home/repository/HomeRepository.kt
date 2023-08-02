package iam5akda.fakechef.feature.home.repository

import kotlinx.coroutines.flow.Flow

interface HomeRepository {
    fun getAnimatedAppName(repetition: Int): Flow<String>
}