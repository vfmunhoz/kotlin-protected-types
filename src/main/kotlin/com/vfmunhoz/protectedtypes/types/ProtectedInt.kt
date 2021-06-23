package com.vfmunhoz.protectedtypes.types

@JvmInline
value class ProtectedInt(val value: Int) : Comparable<ProtectedInt> {

    operator fun unaryPlus(): ProtectedInt = ProtectedInt(value.unaryPlus())
    operator fun unaryMinus(): ProtectedInt = ProtectedInt(value.unaryMinus())

    operator fun inc(): ProtectedInt = ProtectedInt(value.inc())
    operator fun dec(): ProtectedInt = ProtectedInt(value.dec())

    // Plus
    operator fun plus(other: Byte): ProtectedInt = ProtectedInt(value + other)
    operator fun plus(other: Short): ProtectedInt = ProtectedInt(value + other)
    operator fun plus(other: Int): ProtectedInt = ProtectedInt(value + other)
    operator fun plus(other: Long): ProtectedLong = ProtectedLong(value + other)
    operator fun plus(other: Float): ProtectedFloat = ProtectedFloat(value + other)
    operator fun plus(other: Double): ProtectedDouble = ProtectedDouble(value + other)

    // Minus
    operator fun minus(other: Byte): ProtectedInt = ProtectedInt(value - other)
    operator fun minus(other: Short): ProtectedInt = ProtectedInt(value - other)
    operator fun minus(other: Int): ProtectedInt = ProtectedInt(value - other)
    operator fun minus(other: Long): ProtectedLong = ProtectedLong(value - other)
    operator fun minus(other: Float): ProtectedFloat = ProtectedFloat(value - other)
    operator fun minus(other: Double): ProtectedDouble = ProtectedDouble(value - other)

    // Times
    operator fun times(other: Byte): ProtectedInt = ProtectedInt(value * other)
    operator fun times(other: Short): ProtectedInt = ProtectedInt(value * other)
    operator fun times(other: Int): ProtectedInt = ProtectedInt(value * other)
    operator fun times(other: Long): ProtectedLong = ProtectedLong(value * other)
    operator fun times(other: Float): ProtectedFloat = ProtectedFloat(value * other)
    operator fun times(other: Double): ProtectedDouble = ProtectedDouble(value * other)

    // Div
    operator fun div(other: Byte): ProtectedInt = ProtectedInt(value / other)
    operator fun div(other: Short): ProtectedInt = ProtectedInt(value / other)
    operator fun div(other: Int): ProtectedInt = ProtectedInt(value / other)
    operator fun div(other: Long): ProtectedLong = ProtectedLong(value / other)
    operator fun div(other: Float): ProtectedFloat = ProtectedFloat(value / other)
    operator fun div(other: Double): ProtectedDouble = ProtectedDouble(value / other)

    // Rem
    operator fun rem(other: Byte): ProtectedInt = ProtectedInt(value % other)
    operator fun rem(other: Short): ProtectedInt = ProtectedInt(value % other)
    operator fun rem(other: Int): ProtectedInt = ProtectedInt(value % other)
    operator fun rem(other: Long): ProtectedLong = ProtectedLong(value % other)
    operator fun rem(other: Float): ProtectedFloat = ProtectedFloat(value % other)
    operator fun rem(other: Double): ProtectedDouble = ProtectedDouble(value % other)

    operator fun compareTo(other: Int): Int = value.compareTo(other)
    override operator fun compareTo(other: ProtectedInt): Int = compareTo(other.value)

    override fun toString(): String = "###$value###"
}
