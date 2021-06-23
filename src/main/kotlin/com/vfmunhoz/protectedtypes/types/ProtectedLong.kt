package com.vfmunhoz.protectedtypes.types

@JvmInline
value class ProtectedLong(val value: Long) : Comparable<ProtectedLong> {

    operator fun unaryPlus(): ProtectedLong = ProtectedLong(value.unaryPlus())
    operator fun unaryMinus(): ProtectedLong = ProtectedLong(value.unaryMinus())

    operator fun inc(): ProtectedLong = ProtectedLong(value.inc())
    operator fun dec(): ProtectedLong = ProtectedLong(value.dec())

    // Plus
    operator fun plus(other: Byte): ProtectedLong = ProtectedLong(value + other)
    operator fun plus(other: Short): ProtectedLong = ProtectedLong(value + other)
    operator fun plus(other: Int): ProtectedLong = ProtectedLong(value + other)
    operator fun plus(other: Long): ProtectedLong = ProtectedLong(value + other)
    operator fun plus(other: Float): ProtectedFloat = ProtectedFloat(value + other)
    operator fun plus(other: Double): ProtectedDouble = ProtectedDouble(value + other)

    // Minus
    operator fun minus(other: Byte): ProtectedLong = ProtectedLong(value - other)
    operator fun minus(other: Short): ProtectedLong = ProtectedLong(value - other)
    operator fun minus(other: Int): ProtectedLong = ProtectedLong(value - other)
    operator fun minus(other: Long): ProtectedLong = ProtectedLong(value - other)
    operator fun minus(other: Float): ProtectedFloat = ProtectedFloat(value - other)
    operator fun minus(other: Double): ProtectedDouble = ProtectedDouble(value - other)

    // Times
    operator fun times(other: Byte): ProtectedLong = ProtectedLong(value * other)
    operator fun times(other: Short): ProtectedLong = ProtectedLong(value * other)
    operator fun times(other: Int): ProtectedLong = ProtectedLong(value * other)
    operator fun times(other: Long): ProtectedLong = ProtectedLong(value * other)
    operator fun times(other: Float): ProtectedFloat = ProtectedFloat(value * other)
    operator fun times(other: Double): ProtectedDouble = ProtectedDouble(value * other)

    // Div
    operator fun div(other: Byte): ProtectedLong = ProtectedLong(value / other)
    operator fun div(other: Short): ProtectedLong = ProtectedLong(value / other)
    operator fun div(other: Int): ProtectedLong = ProtectedLong(value / other)
    operator fun div(other: Long): ProtectedLong = ProtectedLong(value / other)
    operator fun div(other: Float): ProtectedFloat = ProtectedFloat(value / other)
    operator fun div(other: Double): ProtectedDouble = ProtectedDouble(value / other)

    // Rem
    operator fun rem(other: Byte): ProtectedLong = ProtectedLong(value % other)
    operator fun rem(other: Short): ProtectedLong = ProtectedLong(value % other)
    operator fun rem(other: Int): ProtectedLong = ProtectedLong(value % other)
    operator fun rem(other: Long): ProtectedLong = ProtectedLong(value % other)
    operator fun rem(other: Float): ProtectedFloat = ProtectedFloat(value % other)
    operator fun rem(other: Double): ProtectedDouble = ProtectedDouble(value % other)

    operator fun compareTo(other: Long): Int = value.compareTo(other)
    override operator fun compareTo(other: ProtectedLong): Int = compareTo(other.value)

    override fun toString(): String = "###$value###"
}
