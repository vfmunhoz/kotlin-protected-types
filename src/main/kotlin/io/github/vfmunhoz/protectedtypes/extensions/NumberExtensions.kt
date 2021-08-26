package io.github.vfmunhoz.protectedtypes.extensions

import kotlin.math.floor

fun Number.obfuscate(): String = toString().let {
    val from = floor(it.length / 2.0).toInt()
    val to = it.length - 1

    when(this) {
        is Float, is Double -> it.replaceFrom(from, to, "#", setOf('-', '.'))
        else -> it.replaceFrom(from, to, "#", setOf('-'))
    }
}
