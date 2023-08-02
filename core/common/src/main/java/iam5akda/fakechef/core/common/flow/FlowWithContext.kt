package iam5akda.fakechef.core.common.flow

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.FlowCollector
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

fun <T> flowWithContext(
    dispatcher: CoroutineDispatcher,
    block: suspend FlowCollector<T>.() -> Unit
): Flow<T> {
    return flow(block).flowOn(dispatcher)
}