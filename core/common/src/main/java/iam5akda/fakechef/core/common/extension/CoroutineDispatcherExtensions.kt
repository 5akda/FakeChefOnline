package iam5akda.fakechef.core.common.extension

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.FlowCollector
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

fun <T> CoroutineDispatcher.createFlow(
    block: suspend FlowCollector<T>.() -> Unit
): Flow<T> {
    return flow(block).flowOn(this)
}