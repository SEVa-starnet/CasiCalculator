package com.seva.starnet.casicalculator.common.base

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

abstract class CustomDispatchers {
    abstract val main: CoroutineDispatcher
    abstract val io: CoroutineDispatcher
    abstract val default: CoroutineDispatcher
    abstract val unconfined: CoroutineDispatcher

    class Base : CustomDispatchers() {
        override val main: CoroutineDispatcher
            get() = Dispatchers.Main
        override val io: CoroutineDispatcher
            get() = Dispatchers.IO
        override val default: CoroutineDispatcher
            get() = Dispatchers.Default
        override val unconfined: CoroutineDispatcher
            get() = Dispatchers.Unconfined
    }
}