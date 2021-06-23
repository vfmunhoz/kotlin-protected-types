package com.vfmunhoz.protectedtypes.types

@JvmInline
value class ProtectedFloat(val value: Float) : Comparable<ProtectedFloat> {

    operator fun unaryPlus(): ProtectedFloat = ProtectedFloat(value.unaryPlus())
    operator fun unaryMinus(): ProtectedFloat = ProtectedFloat(value.unaryMinus())

    operator fun inc(): ProtectedFloat = ProtectedFloat(value.inc())
    operator fun dec(): ProtectedFloat = ProtectedFloat(value.dec())

    // Plus
    operator fun plus(other: Byte): ProtectedFloat = ProtectedFloat(value + other)
    operator fun plus(other: Short): ProtectedFloat = ProtectedFloat(value + other)
    operator fun plus(other: Int): ProtectedFloat = ProtectedFloat(value + other)
    operator fun plus(other: Long): ProtectedFloat = ProtectedFloat(value + other)
    operator fun plus(other: Float): ProtectedFloat = ProtectedFloat(value + other)
    operator fun plus(other: Double): ProtectedDouble = ProtectedDouble(value + other)

    // Minus
    operator fun minus(other: Byte): ProtectedFloat = ProtectedFloat(value - other)
    operator fun minus(other: Short): ProtectedFloat = ProtectedFloat(value - other)
    operator fun minus(other: Int): ProtectedFloat = ProtectedFloat(value - other)
    operator fun minus(other: Long): ProtectedFloat = ProtectedFloat(value - other)
    operator fun minus(other: Float): ProtectedFloat = ProtectedFloat(value - other)
    operator fun minus(other: Double): ProtectedDouble = ProtectedDouble(value - other)

    // Times
    operator fun times(other: Byte): ProtectedFloat = ProtectedFloat(value * other)
    operator fun times(other: Short): ProtectedFloat = ProtectedFloat(value * other)
    operator fun times(other: Int): ProtectedFloat = ProtectedFloat(value * other)
    operator fun times(other: Long): ProtectedFloat = ProtectedFloat(value * other)
    operator fun times(other: Float): ProtectedFloat = ProtectedFloat(value * other)
    operator fun times(other: Double): ProtectedDouble = ProtectedDouble(value * other)

    // Div
    operator fun div(other: Byte): ProtectedFloat = ProtectedFloat(value / other)
    operator fun div(other: Short): ProtectedFloat = ProtectedFloat(value / other)
    operator fun div(other: Int): ProtectedFloat = ProtectedFloat(value / other)
    operator fun div(other: Long): ProtectedFloat = ProtectedFloat(value / other)
    operator fun div(other: Float): ProtectedFloat = ProtectedFloat(value / other)
    operator fun div(other: Double): ProtectedDouble = ProtectedDouble(value / other)

    // Rem
    operator fun rem(other: Byte): ProtectedFloat = ProtectedFloat(value % other)
    operator fun rem(other: Short): ProtectedFloat = ProtectedFloat(value % other)
    operator fun rem(other: Int): ProtectedFloat = ProtectedFloat(value % other)
    operator fun rem(other: Long): ProtectedFloat = ProtectedFloat(value % other)
    operator fun rem(other: Float): ProtectedFloat = ProtectedFloat(value % other)
    operator fun rem(other: Double): ProtectedDouble = ProtectedDouble(value % other)

    operator fun compareTo(other: Float): Int = value.compareTo(other)
    override operator fun compareTo(other: ProtectedFloat): Int = compareTo(other.value)

    override fun toString(): String = "###$value###"
}
