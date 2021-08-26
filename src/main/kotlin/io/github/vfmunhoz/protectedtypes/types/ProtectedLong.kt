package io.github.vfmunhoz.protectedtypes.types

import com.fasterxml.jackson.annotation.JsonValue
import io.github.vfmunhoz.protectedtypes.extensions.obfuscate

@JvmInline
value class ProtectedLong(@JsonValue val value: Long) : Comparable<ProtectedLong> {

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

    operator fun plus(other: ProtectedByte): ProtectedLong = this.plus(other.value)
    operator fun plus(other: ProtectedShort): ProtectedLong = this.plus(other.value)
    operator fun plus(other: ProtectedInt): ProtectedLong = this.plus(other.value)
    operator fun plus(other: ProtectedLong): ProtectedLong = this.plus(other.value)
    operator fun plus(other: ProtectedFloat): ProtectedFloat = this.plus(other.value)
    operator fun plus(other: ProtectedDouble): ProtectedDouble = this.plus(other.value)

    // Minus
    operator fun minus(other: Byte): ProtectedLong = ProtectedLong(value - other)
    operator fun minus(other: Short): ProtectedLong = ProtectedLong(value - other)
    operator fun minus(other: Int): ProtectedLong = ProtectedLong(value - other)
    operator fun minus(other: Long): ProtectedLong = ProtectedLong(value - other)
    operator fun minus(other: Float): ProtectedFloat = ProtectedFloat(value - other)
    operator fun minus(other: Double): ProtectedDouble = ProtectedDouble(value - other)

    operator fun minus(other: ProtectedByte): ProtectedLong = this.minus(other.value)
    operator fun minus(other: ProtectedShort): ProtectedLong = this.minus(other.value)
    operator fun minus(other: ProtectedInt): ProtectedLong = this.minus(other.value)
    operator fun minus(other: ProtectedLong): ProtectedLong = this.minus(other.value)
    operator fun minus(other: ProtectedFloat): ProtectedFloat = this.minus(other.value)
    operator fun minus(other: ProtectedDouble): ProtectedDouble = this.minus(other.value)

    // Times
    operator fun times(other: Byte): ProtectedLong = ProtectedLong(value * other)
    operator fun times(other: Short): ProtectedLong = ProtectedLong(value * other)
    operator fun times(other: Int): ProtectedLong = ProtectedLong(value * other)
    operator fun times(other: Long): ProtectedLong = ProtectedLong(value * other)
    operator fun times(other: Float): ProtectedFloat = ProtectedFloat(value * other)
    operator fun times(other: Double): ProtectedDouble = ProtectedDouble(value * other)

    operator fun times(other: ProtectedByte): ProtectedLong = this.times(other.value)
    operator fun times(other: ProtectedShort): ProtectedLong = this.times(other.value)
    operator fun times(other: ProtectedInt): ProtectedLong = this.times(other.value)
    operator fun times(other: ProtectedLong): ProtectedLong = this.times(other.value)
    operator fun times(other: ProtectedFloat): ProtectedFloat = this.times(other.value)
    operator fun times(other: ProtectedDouble): ProtectedDouble = this.times(other.value)

    // Div
    operator fun div(other: Byte): ProtectedLong = ProtectedLong(value / other)
    operator fun div(other: Short): ProtectedLong = ProtectedLong(value / other)
    operator fun div(other: Int): ProtectedLong = ProtectedLong(value / other)
    operator fun div(other: Long): ProtectedLong = ProtectedLong(value / other)
    operator fun div(other: Float): ProtectedFloat = ProtectedFloat(value / other)
    operator fun div(other: Double): ProtectedDouble = ProtectedDouble(value / other)

    operator fun div(other: ProtectedByte): ProtectedLong = this.div(other.value)
    operator fun div(other: ProtectedShort): ProtectedLong = this.div(other.value)
    operator fun div(other: ProtectedInt): ProtectedLong = this.div(other.value)
    operator fun div(other: ProtectedLong): ProtectedLong = this.div(other.value)
    operator fun div(other: ProtectedFloat): ProtectedFloat = this.div(other.value)
    operator fun div(other: ProtectedDouble): ProtectedDouble = this.div(other.value)

    // Rem
    operator fun rem(other: Byte): ProtectedLong = ProtectedLong(value % other)
    operator fun rem(other: Short): ProtectedLong = ProtectedLong(value % other)
    operator fun rem(other: Int): ProtectedLong = ProtectedLong(value % other)
    operator fun rem(other: Long): ProtectedLong = ProtectedLong(value % other)
    operator fun rem(other: Float): ProtectedFloat = ProtectedFloat(value % other)
    operator fun rem(other: Double): ProtectedDouble = ProtectedDouble(value % other)

    operator fun rem(other: ProtectedByte): ProtectedLong = this.rem(other.value)
    operator fun rem(other: ProtectedShort): ProtectedLong = this.rem(other.value)
    operator fun rem(other: ProtectedInt): ProtectedLong = this.rem(other.value)
    operator fun rem(other: ProtectedLong): ProtectedLong = this.rem(other.value)
    operator fun rem(other: ProtectedFloat): ProtectedFloat = this.rem(other.value)
    operator fun rem(other: ProtectedDouble): ProtectedDouble = this.rem(other.value)

    operator fun compareTo(other: Long): Int = value.compareTo(other)
    override operator fun compareTo(other: ProtectedLong): Int = compareTo(other.value)

    override fun toString(): String = value.obfuscate()
}

fun Long.toProtected() = ProtectedLong(this)

// Primitive + protected
operator fun Long.plus(protectedValue: ProtectedByte): Long = this + protectedValue.value
operator fun Long.plus(protectedValue: ProtectedShort): Long = this + protectedValue.value
operator fun Long.plus(protectedValue: ProtectedInt): Long = this + protectedValue.value
operator fun Long.plus(protectedValue: ProtectedLong): Long = this + protectedValue.value
operator fun Long.plus(protectedValue: ProtectedFloat): Float = this + protectedValue.value
operator fun Long.plus(protectedValue: ProtectedDouble): Double = this + protectedValue.value

// Primitive - protected
operator fun Long.minus(protectedValue: ProtectedByte): Long = this - protectedValue.value
operator fun Long.minus(protectedValue: ProtectedShort): Long = this - protectedValue.value
operator fun Long.minus(protectedValue: ProtectedInt): Long = this - protectedValue.value
operator fun Long.minus(protectedValue: ProtectedLong): Long = this - protectedValue.value
operator fun Long.minus(protectedValue: ProtectedFloat): Float = this - protectedValue.value
operator fun Long.minus(protectedValue: ProtectedDouble): Double = this - protectedValue.value

// Primitive * protected
operator fun Long.times(protectedValue: ProtectedByte): Long = this * protectedValue.value
operator fun Long.times(protectedValue: ProtectedShort): Long = this * protectedValue.value
operator fun Long.times(protectedValue: ProtectedInt): Long = this * protectedValue.value
operator fun Long.times(protectedValue: ProtectedLong): Long = this * protectedValue.value
operator fun Long.times(protectedValue: ProtectedFloat): Float = this * protectedValue.value
operator fun Long.times(protectedValue: ProtectedDouble): Double = this * protectedValue.value

// Primitive / protected
operator fun Long.div(protectedValue: ProtectedByte): Long = this / protectedValue.value
operator fun Long.div(protectedValue: ProtectedShort): Long = this / protectedValue.value
operator fun Long.div(protectedValue: ProtectedInt): Long = this / protectedValue.value
operator fun Long.div(protectedValue: ProtectedLong): Long = this / protectedValue.value
operator fun Long.div(protectedValue: ProtectedFloat): Float = this / protectedValue.value
operator fun Long.div(protectedValue: ProtectedDouble): Double = this / protectedValue.value

// Primitive % protected
operator fun Long.rem(protectedValue: ProtectedByte): Long = this % protectedValue.value
operator fun Long.rem(protectedValue: ProtectedShort): Long = this % protectedValue.value
operator fun Long.rem(protectedValue: ProtectedInt): Long = this % protectedValue.value
operator fun Long.rem(protectedValue: ProtectedLong): Long = this % protectedValue.value
operator fun Long.rem(protectedValue: ProtectedFloat): Float = this % protectedValue.value
operator fun Long.rem(protectedValue: ProtectedDouble): Double = this % protectedValue.value
