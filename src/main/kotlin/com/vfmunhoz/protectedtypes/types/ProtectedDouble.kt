package com.vfmunhoz.protectedtypes.types

@JvmInline
value class ProtectedDouble(val value: Double) : Comparable<ProtectedDouble> {

    operator fun unaryPlus(): ProtectedDouble = ProtectedDouble(value.unaryPlus())
    operator fun unaryMinus(): ProtectedDouble = ProtectedDouble(value.unaryMinus())

    operator fun inc(): ProtectedDouble = ProtectedDouble(value.inc())
    operator fun dec(): ProtectedDouble = ProtectedDouble(value.dec())

    // Plus
    operator fun plus(other: Byte): ProtectedDouble = ProtectedDouble(value + other)
    operator fun plus(other: Short): ProtectedDouble = ProtectedDouble(value + other)
    operator fun plus(other: Int): ProtectedDouble = ProtectedDouble(value + other)
    operator fun plus(other: Long): ProtectedDouble = ProtectedDouble(value + other)
    operator fun plus(other: Float): ProtectedDouble = ProtectedDouble(value + other)
    operator fun plus(other: Double): ProtectedDouble = ProtectedDouble(value + other)

    operator fun plus(other: ProtectedByte): ProtectedDouble = this.plus(other.value)
    operator fun plus(other: ProtectedShort): ProtectedDouble = this.plus(other.value)
    operator fun plus(other: ProtectedInt): ProtectedDouble = this.plus(other.value)
    operator fun plus(other: ProtectedLong): ProtectedDouble = this.plus(other.value)
    operator fun plus(other: ProtectedFloat): ProtectedDouble = this.plus(other.value)
    operator fun plus(other: ProtectedDouble): ProtectedDouble = this.plus(other.value)

    // Minus
    operator fun minus(other: Byte): ProtectedDouble = ProtectedDouble(value - other)
    operator fun minus(other: Short): ProtectedDouble = ProtectedDouble(value - other)
    operator fun minus(other: Int): ProtectedDouble = ProtectedDouble(value - other)
    operator fun minus(other: Long): ProtectedDouble = ProtectedDouble(value - other)
    operator fun minus(other: Float): ProtectedDouble = ProtectedDouble(value - other)
    operator fun minus(other: Double): ProtectedDouble = ProtectedDouble(value - other)

    operator fun minus(other: ProtectedByte): ProtectedDouble = this.minus(other.value)
    operator fun minus(other: ProtectedShort): ProtectedDouble = this.minus(other.value)
    operator fun minus(other: ProtectedInt): ProtectedDouble = this.minus(other.value)
    operator fun minus(other: ProtectedLong): ProtectedDouble = this.minus(other.value)
    operator fun minus(other: ProtectedFloat): ProtectedDouble = this.minus(other.value)
    operator fun minus(other: ProtectedDouble): ProtectedDouble = this.minus(other.value)

    // Times
    operator fun times(other: Byte): ProtectedDouble = ProtectedDouble(value * other)
    operator fun times(other: Short): ProtectedDouble = ProtectedDouble(value * other)
    operator fun times(other: Int): ProtectedDouble = ProtectedDouble(value * other)
    operator fun times(other: Long): ProtectedDouble = ProtectedDouble(value * other)
    operator fun times(other: Float): ProtectedDouble = ProtectedDouble(value * other)
    operator fun times(other: Double): ProtectedDouble = ProtectedDouble(value * other)

    operator fun times(other: ProtectedByte): ProtectedDouble = this.times(other.value)
    operator fun times(other: ProtectedShort): ProtectedDouble = this.times(other.value)
    operator fun times(other: ProtectedInt): ProtectedDouble = this.times(other.value)
    operator fun times(other: ProtectedLong): ProtectedDouble = this.times(other.value)
    operator fun times(other: ProtectedFloat): ProtectedDouble = this.times(other.value)
    operator fun times(other: ProtectedDouble): ProtectedDouble = this.times(other.value)

    // Div
    operator fun div(other: Byte): ProtectedDouble = ProtectedDouble(value / other)
    operator fun div(other: Short): ProtectedDouble = ProtectedDouble(value / other)
    operator fun div(other: Int): ProtectedDouble = ProtectedDouble(value / other)
    operator fun div(other: Long): ProtectedDouble = ProtectedDouble(value / other)
    operator fun div(other: Float): ProtectedDouble = ProtectedDouble(value / other)
    operator fun div(other: Double): ProtectedDouble = ProtectedDouble(value / other)

    operator fun div(other: ProtectedByte): ProtectedDouble = this.div(other.value)
    operator fun div(other: ProtectedShort): ProtectedDouble = this.div(other.value)
    operator fun div(other: ProtectedInt): ProtectedDouble = this.div(other.value)
    operator fun div(other: ProtectedLong): ProtectedDouble = this.div(other.value)
    operator fun div(other: ProtectedFloat): ProtectedDouble = this.div(other.value)
    operator fun div(other: ProtectedDouble): ProtectedDouble = this.div(other.value)

    // Rem
    operator fun rem(other: Byte): ProtectedDouble = ProtectedDouble(value % other)
    operator fun rem(other: Short): ProtectedDouble = ProtectedDouble(value % other)
    operator fun rem(other: Int): ProtectedDouble = ProtectedDouble(value % other)
    operator fun rem(other: Long): ProtectedDouble = ProtectedDouble(value % other)
    operator fun rem(other: Float): ProtectedDouble = ProtectedDouble(value % other)
    operator fun rem(other: Double): ProtectedDouble = ProtectedDouble(value % other)

    operator fun rem(other: ProtectedByte): ProtectedDouble = this.rem(other.value)
    operator fun rem(other: ProtectedShort): ProtectedDouble = this.rem(other.value)
    operator fun rem(other: ProtectedInt): ProtectedDouble = this.rem(other.value)
    operator fun rem(other: ProtectedLong): ProtectedDouble = this.rem(other.value)
    operator fun rem(other: ProtectedFloat): ProtectedDouble = this.rem(other.value)
    operator fun rem(other: ProtectedDouble): ProtectedDouble = this.rem(other.value)

    operator fun compareTo(other: Double): Int = value.compareTo(other)
    override operator fun compareTo(other: ProtectedDouble): Int = compareTo(other.value)

    override fun toString(): String = "###$value###"
}

// Primitive + protected
operator fun Double.plus(protectedValue: ProtectedByte): Double = this + protectedValue.value
operator fun Double.plus(protectedValue: ProtectedShort): Double = this + protectedValue.value
operator fun Double.plus(protectedValue: ProtectedInt): Double = this + protectedValue.value
operator fun Double.plus(protectedValue: ProtectedLong): Double = this + protectedValue.value
operator fun Double.plus(protectedValue: ProtectedFloat): Double = this + protectedValue.value
operator fun Double.plus(protectedValue: ProtectedDouble): Double = this + protectedValue.value

// Primitive - protected
operator fun Double.minus(protectedValue: ProtectedByte): Double = this - protectedValue.value
operator fun Double.minus(protectedValue: ProtectedShort): Double = this - protectedValue.value
operator fun Double.minus(protectedValue: ProtectedInt): Double = this - protectedValue.value
operator fun Double.minus(protectedValue: ProtectedLong): Double = this - protectedValue.value
operator fun Double.minus(protectedValue: ProtectedFloat): Double = this - protectedValue.value
operator fun Double.minus(protectedValue: ProtectedDouble): Double = this - protectedValue.value

// Primitive * protected
operator fun Double.times(protectedValue: ProtectedByte): Double = this * protectedValue.value
operator fun Double.times(protectedValue: ProtectedShort): Double = this * protectedValue.value
operator fun Double.times(protectedValue: ProtectedInt): Double = this * protectedValue.value
operator fun Double.times(protectedValue: ProtectedLong): Double = this * protectedValue.value
operator fun Double.times(protectedValue: ProtectedFloat): Double = this * protectedValue.value
operator fun Double.times(protectedValue: ProtectedDouble): Double = this * protectedValue.value

// Primitive / protected
operator fun Double.div(protectedValue: ProtectedByte): Double = this / protectedValue.value
operator fun Double.div(protectedValue: ProtectedShort): Double = this / protectedValue.value
operator fun Double.div(protectedValue: ProtectedInt): Double = this / protectedValue.value
operator fun Double.div(protectedValue: ProtectedLong): Double = this / protectedValue.value
operator fun Double.div(protectedValue: ProtectedFloat): Double = this / protectedValue.value
operator fun Double.div(protectedValue: ProtectedDouble): Double = this / protectedValue.value

// Primitive % protected
operator fun Double.rem(protectedValue: ProtectedByte): Double = this % protectedValue.value
operator fun Double.rem(protectedValue: ProtectedShort): Double = this % protectedValue.value
operator fun Double.rem(protectedValue: ProtectedInt): Double = this % protectedValue.value
operator fun Double.rem(protectedValue: ProtectedLong): Double = this % protectedValue.value
operator fun Double.rem(protectedValue: ProtectedFloat): Double = this % protectedValue.value
operator fun Double.rem(protectedValue: ProtectedDouble): Double = this % protectedValue.value
