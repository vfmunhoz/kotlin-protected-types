package com.vfmunhoz.protectedtypes.types

import com.vfmunhoz.protectedtypes.extensions.replaceFrom

class ProtectedString(
    val value: String,
    private val splitToken: String? = null,
    private val replaceToken: String = "*"
) : Comparable<ProtectedString> {

    operator fun plus(other: String): ProtectedString = ProtectedString(value + other)

    operator fun plus(other: ProtectedString): ProtectedString = plus(other.value)

    override fun toString(): String =
        if(splitToken.isNullOrEmpty()) { maskValue(value, value.length / 2, value.length - 1) }
        else { maskWithSplit() }

    private fun maskWithSplit() = StringBuilder().let { builder ->
        value.split(splitToken!!).forEach { slice ->
            builder.append(splitToken)
            builder.append(maskValue(slice, slice.length / 2, slice.length - 1))
        }

        builder.toString().trim()
    }

    private fun maskValue(valueToMask: String, start: Int, end: Int): String = valueToMask.replaceFrom(start, end, replaceToken)

    override fun equals(other: Any?): Boolean = value == when(other) {
        is ProtectedString -> other.value
        else -> other
    }

    override fun hashCode(): Int = value.hashCode()

    override fun compareTo(other: ProtectedString): Int = value.compareTo(other.value)
}

fun String.toProtected() = ProtectedString(this)
