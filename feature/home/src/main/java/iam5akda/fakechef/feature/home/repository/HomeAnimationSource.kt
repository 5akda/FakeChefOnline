package iam5akda.fakechef.feature.home.repository

import iam5akda.fakechef.core.common.annotation.IODispatcher
import iam5akda.fakechef.core.common.extension.createFlow
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class HomeAnimationSource @Inject constructor(
    @IODispatcher private val dispatcher: CoroutineDispatcher
) : HomeRepository {

    override fun getAnimatedAppName(repetition: Int): Flow<String> {
        val frame = listOf(
            "Fake Chef  ",
            "ake Chef  F",
            "ke Chef  Fa",
            "e Chef  Fak",
            " Chef  Fake",
            "Chef  Fake ",
            "hef  Fake C",
            "ef  Fake Ch",
            "f  Fake Che",
            "  Fake Chef",
            " Fake Chef ",
        )
        return dispatcher.createFlow {
            repeat(repetition * frame.size) {
                emit(frame[it % frame.size])
                delay(FRAME_DELAY)
            }
        }
    }

    companion object {
        private const val FRAME_DELAY = 100L
    }
}