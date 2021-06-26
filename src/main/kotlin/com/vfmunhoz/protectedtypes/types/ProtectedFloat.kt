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

    operator fun plus(other: ProtectedByte): ProtectedFloat = this.plus(other.value)
    operator fun plus(other: ProtectedShort): ProtectedFloat = this.plus(other.value)
    operator fun plus(other: ProtectedInt): ProtectedFloat = this.plus(other.value)
    operator fun plus(other: ProtectedLong): ProtectedFloat = this.plus(other.value)
    operator fun plus(other: ProtectedFloat): ProtectedFloat = this.plus(other.value)
    operator fun plus(other: ProtectedDouble): ProtectedDouble = this.plus(other.value)

    // Minus
    operator fun minus(other: Byte): ProtectedFloat = ProtectedFloat(value - other)
    operator fun minus(other: Short): ProtectedFloat = ProtectedFloat(value - other)
    operator fun minus(other: Int): ProtectedFloat = ProtectedFloat(value - other)
    operator fun minus(other: Long): ProtectedFloat = ProtectedFloat(value - other)
    operator fun minus(other: Float): ProtectedFloat = ProtectedFloat(value - other)
    operator fun minus(other: Double): ProtectedDouble = ProtectedDouble(value - other)

    operator fun minus(other: ProtectedByte): ProtectedFloat = this.minus(other.value)
    operator fun minus(other: ProtectedShort): ProtectedFloat = this.minus(other.value)
    operator fun minus(other: ProtectedInt): ProtectedFloat = this.minus(other.value)
    operator fun minus(other: ProtectedLong): ProtectedFloat = this.minus(other.value)
    operator fun minus(other: ProtectedFloat): ProtectedFloat = this.minus(other.value)
    operator fun minus(other: ProtectedDouble): ProtectedDouble = this.minus(other.value)

    // Times
    operator fun times(other: Byte): ProtectedFloat = ProtectedFloat(value * other)
    operator fun times(other: Short): ProtectedFloat = ProtectedFloat(value * other)
    operator fun times(other: Int): ProtectedFloat = ProtectedFloat(value * other)
    operator fun times(other: Long): ProtectedFloat = ProtectedFloat(value * other)
    operator fun times(other: Float): ProtectedFloat = ProtectedFloat(value * other)
    operator fun times(other: Double): ProtectedDouble = ProtectedDouble(value * other)

    operator fun times(other: ProtectedByte): ProtectedFloat = this.times(other.value)
    operator fun times(other: ProtectedShort): ProtectedFloat = this.times(other.value)
    operator fun times(other: ProtectedInt): ProtectedFloat = this.times(other.value)
    operator fun times(other: ProtectedLong): ProtectedFloat = this.times(other.value)
    operator fun times(other: ProtectedFloat): ProtectedFloat = this.times(other.value)
    operator fun times(other: ProtectedDouble): ProtectedDouble = this.times(other.value)

    // Div
    operator fun div(other: Byte): ProtectedFloat = ProtectedFloat(value / other)
    operator fun div(other: Short): ProtectedFloat = ProtectedFloat(value / other)
    operator fun div(other: Int): ProtectedFloat = ProtectedFloat(value / other)
    operator fun div(other: Long): ProtectedFloat = ProtectedFloat(value / other)
    operator fun div(other: Float): ProtectedFloat = ProtectedFloat(value / other)
    operator fun div(other: Double): ProtectedDouble = ProtectedDouble(value / other)

    operator fun div(other: ProtectedByte): ProtectedFloat = this.div(other.value)
    operator fun div(other: ProtectedShort): ProtectedFloat = this.div(other.value)
    operator fun div(other: ProtectedInt): ProtectedFloat = this.div(other.value)
    operator fun div(other: ProtectedLong): ProtectedFloat = this.div(other.value)
    operator fun div(other: ProtectedFloat): ProtectedFloat = this.div(other.value)
    operator fun div(other: ProtectedDouble): ProtectedDouble = this.div(other.value)

    // Rem
    operator fun rem(other: Byte): ProtectedFloat = ProtectedFloat(value % other)
    operator fun rem(other: Short): ProtectedFloat = ProtectedFloat(value % other)
    operator fun rem(other: Int): ProtectedFloat = ProtectedFloat(value % other)
    operator fun rem(other: Long): ProtectedFloat = ProtectedFloat(value % other)
    operator fun rem(other: Float): ProtectedFloat = ProtectedFloat(value % other)
    operator fun rem(other: Double): ProtectedDouble = ProtectedDouble(value % other)

    operator fun rem(other: ProtectedByte): ProtectedFloat = this.rem(other.value)
    operator fun rem(other: ProtectedShort): ProtectedFloat = this.rem(other.value)
    operator fun rem(other: ProtectedInt): ProtectedFloat = this.rem(other.value)
    operator fun rem(other: ProtectedLong): ProtectedFloat = this.rem(other.value)
    operator fun rem(other: ProtectedFloat): ProtectedFloat = this.rem(other.value)
    operator fun rem(other: ProtectedDouble): ProtectedDouble = this.rem(other.value)

    operator fun compareTo(other: Float): Int = value.compareTo(other)
    override operator fun compareTo(other: ProtectedFloat): Int = compareTo(other.value)

    override fun toString(): String = "###$value###"
}

// Primitive + protected
operator fun Float.plus(protectedValue: ProtectedByte): Float = this + protectedValue.value
operator fun Float.plus(protectedValue: ProtectedShort): Float = this + protectedValue.value
operator fun Float.plus(protectedValue: ProtectedInt): Float = this + protectedValue.value
operator fun Float.plus(protectedValue: ProtectedLong): Float = this + protectedValue.value
operator fun Float.plus(protectedValue: ProtectedFloat): Float = this + protectedValue.value
operator fun Float.plus(protectedValue: ProtectedDouble): Double = this + protectedValue.value

// Primitive - protected
operator fun Float.minus(protectedValue: ProtectedByte): Float = this - protectedValue.value
operator fun Float.minus(protectedValue: ProtectedShort): Float = this - protectedValue.value
operator fun Float.minus(protectedValue: ProtectedInt): Float = this - protectedValue.value
operator fun Float.minus(protectedValue: ProtectedLong): Float = this - protectedValue.value
operator fun Float.minus(protectedValue: ProtectedFloat): Float = this - protectedValue.value
operator fun Float.minus(protectedValue: ProtectedDouble): Double = this - protectedValue.value

// Primitive * protected
operator fun Float.times(protectedValue: ProtectedByte): Float = this * protectedValue.value
operator fun Float.times(protectedValue: ProtectedShort): Float = this * protectedValue.value
operator fun Float.times(protectedValue: ProtectedInt): Float = this * protectedValue.value
operator fun Float.times(protectedValue: ProtectedLong): Float = this * protectedValue.value
operator fun Float.times(protectedValue: ProtectedFloat): Float = this * protectedValue.value
operator fun Float.times(protectedValue: ProtectedDouble): Double = this * protectedValue.value

// Primitive / protected
operator fun Float.div(protectedValue: ProtectedByte): Float = this / protectedValue.value
operator fun Float.div(protectedValue: ProtectedShort): Float = this / protectedValue.value
operator fun Float.div(protectedValue: ProtectedInt): Float = this / protectedValue.value
operator fun Float.div(protectedValue: ProtectedLong): Float = this / protectedValue.value
operator fun Float.div(protectedValue: ProtectedFloat): Float = this / protectedValue.value
operator fun Float.div(protectedValue: ProtectedDouble): Double = this / protectedValue.value

// Primitive % protected
operator fun Float.rem(protectedValue: ProtectedByte): Float = this % protectedValue.value
operator fun Float.rem(protectedValue: ProtectedShort): Float = this % protectedValue.value
operator fun Float.rem(protectedValue: ProtectedInt): Float = this % protectedValue.value
operator fun Float.rem(protectedValue: ProtectedLong): Float = this % protectedValue.value
operator fun Float.rem(protectedValue: ProtectedFloat): Float = this % protectedValue.value
operator fun Float.rem(protectedValue: ProtectedDouble): Double = this % protectedValue.value
