package org.sert2521.offseason2024.utils

import kotlin.reflect.KMutableProperty0
import kotlin.reflect.KParameter

class AutoLoggableInput<out T>(vararg val logInput: KMutableProperty0<@UnsafeVariance T>) {

    fun logUntyped(): Array<out KMutableProperty0<@UnsafeVariance T>> {
        return logInput
    }
}