package com.vfmunhoz.protectedtypes.types

import com.vfmunhoz.protectedtypes.extensions.replaceFrom

@JvmInline
value class ProtectedString(val value: String) : Comparable<ProtectedString> {

    companion object {
        private const val SPLIT_TOKEN = " "
        private const val REPLACE_TOKEN = "*"
    }

    override fun toString(): String {
        val builder = StringBuilder()

        value.split(SPLIT_TOKEN).forEach { slice ->
            builder.append(SPLIT_TOKEN)
            builder.append(slice.replaceFrom(slice.length / 2, slice.length - 1, REPLACE_TOKEN))
        }

        return builder.toString().trim()
    }

    override fun compareTo(other: ProtectedString): Int = value.compareTo(other.value)
}
