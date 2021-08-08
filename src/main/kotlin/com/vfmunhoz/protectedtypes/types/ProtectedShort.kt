package com.vfmunhoz.protectedtypes.types

import com.fasterxml.jackson.annotation.JsonValue
import com.vfmunhoz.protectedtypes.extensions.obfuscate

@JvmInline
value class ProtectedShort(@JsonValue val value: Short) : Comparable<ProtectedShort> {

    operator fun unaryPlus(): ProtectedInt = ProtectedInt(value.unaryPlus())
    operator fun unaryMinus(): ProtectedInt = ProtectedInt(value.unaryMinus())

    operator fun inc(): ProtectedShort = ProtectedShort(value.inc())
    operator fun dec(): ProtectedShort = ProtectedShort(value.dec())

    // Plus
    operator fun plus(other: Byte): ProtectedInt = ProtectedInt(value + other)
    operator fun plus(other: Short): ProtectedInt = ProtectedInt(value + other)
    operator fun plus(other: Int): ProtectedInt = ProtectedInt(value + other)
    operator fun plus(other: Long): ProtectedLong = ProtectedLong(value + other)
    operator fun plus(other: Float): ProtectedFloat = ProtectedFloat(value + other)
    operator fun plus(other: Double): ProtectedDouble = ProtectedDouble(value + other)

    operator fun plus(other: ProtectedByte): ProtectedInt = this.plus(other.value)
    operator fun plus(other: ProtectedShort): ProtectedInt = this.plus(other.value)
    operator fun plus(other: ProtectedInt): ProtectedInt = this.plus(other.value)
    operator fun plus(other: ProtectedLong): ProtectedLong = this.plus(other.value)
    operator fun plus(other: ProtectedFloat): ProtectedFloat = this.plus(other.value)
    operator fun plus(other: ProtectedDouble): ProtectedDouble = this.plus(other.value)

    // Minus
    operator fun minus(other: Byte): ProtectedInt = ProtectedInt(value - other)
    operator fun minus(other: Short): ProtectedInt = ProtectedInt(value - other)
    operator fun minus(other: Int): ProtectedInt = ProtectedInt(value - other)
    operator fun minus(other: Long): ProtectedLong = ProtectedLong(value - other)
    operator fun minus(other: Float): ProtectedFloat = ProtectedFloat(value - other)
    operator fun minus(other: Double): ProtectedDouble = ProtectedDouble(value - other)

    operator fun minus(other: ProtectedByte): ProtectedInt = this.minus(other.value)
    operator fun minus(other: ProtectedShort): ProtectedInt = this.minus(other.value)
    operator fun minus(other: ProtectedInt): ProtectedInt = this.minus(other.value)
    operator fun minus(other: ProtectedLong): ProtectedLong = this.minus(other.value)
    operator fun minus(other: ProtectedFloat): ProtectedFloat = this.minus(other.value)
    operator fun minus(other: ProtectedDouble): ProtectedDouble = this.minus(other.value)

    // Times
    operator fun times(other: Byte): ProtectedInt = ProtectedInt(value * other)
    operator fun times(other: Short): ProtectedInt = ProtectedInt(value * other)
    operator fun times(other: Int): ProtectedInt = ProtectedInt(value * other)
    operator fun times(other: Long): ProtectedLong = ProtectedLong(value * other)
    operator fun times(other: Float): ProtectedFloat = ProtectedFloat(value * other)
    operator fun times(other: Double): ProtectedDouble = ProtectedDouble(value * other)
    
    operator fun times(other: ProtectedByte): ProtectedInt = this.times(other.value)
    operator fun times(other: ProtectedShort): ProtectedInt = this.times(other.value)
    operator fun times(other: ProtectedInt): ProtectedInt = this.times(other.value)
    operator fun times(other: ProtectedLong): ProtectedLong = this.times(other.value)
    operator fun times(other: ProtectedFloat): ProtectedFloat = this.times(other.value)
    operator fun times(other: ProtectedDouble): ProtectedDouble = this.times(other.value)

    // Div
    operator fun div(other: Byte): ProtectedInt = ProtectedInt(value / other)
    operator fun div(other: Short): ProtectedInt = ProtectedInt(value / other)
    operator fun div(other: Int): ProtectedInt = ProtectedInt(value / other)
    operator fun div(other: Long): ProtectedLong = ProtectedLong(value / other)
    operator fun div(other: Float): ProtectedFloat = ProtectedFloat(value / other)
    operator fun div(other: Double): ProtectedDouble = ProtectedDouble(value / other)

    operator fun div(other: ProtectedByte): ProtectedInt = this.div(other.value)
    operator fun div(other: ProtectedShort): ProtectedInt = this.div(other.value)
    operator fun div(other: ProtectedInt): ProtectedInt = this.div(other.value)
    operator fun div(other: ProtectedLong): ProtectedLong = this.div(other.value)
    operator fun div(other: ProtectedFloat): ProtectedFloat = this.div(other.value)
    operator fun div(other: ProtectedDouble): ProtectedDouble = this.div(other.value)

    // Rem
    operator fun rem(other: Byte): ProtectedInt = ProtectedInt(value % other)
    operator fun rem(other: Short): ProtectedInt = ProtectedInt(value % other)
    operator fun rem(other: Int): ProtectedInt = ProtectedInt(value % other)
    operator fun rem(other: Long): ProtectedLong = ProtectedLong(value % other)
    operator fun rem(other: Float): ProtectedFloat = ProtectedFloat(value % other)
    operator fun rem(other: Double): ProtectedDouble = ProtectedDouble(value % other)

    operator fun rem(other: ProtectedByte): ProtectedInt = this.rem(other.value)
    operator fun rem(other: ProtectedShort): ProtectedInt = this.rem(other.value)
    operator fun rem(other: ProtectedInt): ProtectedInt = this.rem(other.value)
    operator fun rem(other: ProtectedLong): ProtectedLong = this.rem(other.value)
    operator fun rem(other: ProtectedFloat): ProtectedFloat = this.rem(other.value)
    operator fun rem(other: ProtectedDouble): ProtectedDouble = this.rem(other.value)

    operator fun compareTo(other: Short): Int = value.compareTo(other)
    override operator fun compareTo(other: ProtectedShort): Int = compareTo(other.value)

    override fun toString(): String = value.obfuscate()
}

fun Short.toProtected() = ProtectedShort(this)

// Primitive + protected
operator fun Short.plus(protectedValue: ProtectedByte): Int = this + protectedValue.value
operator fun Short.plus(protectedValue: ProtectedShort): Int = this + protectedValue.value
operator fun Short.plus(protectedValue: ProtectedInt): Int = this + protectedValue.value
operator fun Short.plus(protectedValue: ProtectedLong): Long = this + protectedValue.value
operator fun Short.plus(protectedValue: ProtectedFloat): Float = this + protectedValue.value
operator fun Short.plus(protectedValue: ProtectedDouble): Double = this + protectedValue.value

// Primitive + protected
operator fun Short.minus(protectedValue: ProtectedByte): Int = this - protectedValue.value
operator fun Short.minus(protectedValue: ProtectedShort): Int = this - protectedValue.value
operator fun Short.minus(protectedValue: ProtectedInt): Int = this - protectedValue.value
operator fun Short.minus(protectedValue: ProtectedLong): Long = this - protectedValue.value
operator fun Short.minus(protectedValue: ProtectedFloat): Float = this - protectedValue.value
operator fun Short.minus(protectedValue: ProtectedDouble): Double = this - protectedValue.value

// Primitive + protected
operator fun Short.times(protectedValue: ProtectedByte): Int = this * protectedValue.value
operator fun Short.times(protectedValue: ProtectedShort): Int = this * protectedValue.value
operator fun Short.times(protectedValue: ProtectedInt): Int = this * protectedValue.value
operator fun Short.times(protectedValue: ProtectedLong): Long = this * protectedValue.value
operator fun Short.times(protectedValue: ProtectedFloat): Float = this * protectedValue.value
operator fun Short.times(protectedValue: ProtectedDouble): Double = this * protectedValue.value

// Primitive + protected
operator fun Short.div(protectedValue: ProtectedByte): Int = this / protectedValue.value
operator fun Short.div(protectedValue: ProtectedShort): Int = this / protectedValue.value
operator fun Short.div(protectedValue: ProtectedInt): Int = this / protectedValue.value
operator fun Short.div(protectedValue: ProtectedLong): Long = this / protectedValue.value
operator fun Short.div(protectedValue: ProtectedFloat): Float = this / protectedValue.value
operator fun Short.div(protectedValue: ProtectedDouble): Double = this / protectedValue.value

// Primitive + protected
operator fun Short.rem(protectedValue: ProtectedByte): Int = this % protectedValue.value
operator fun Short.rem(protectedValue: ProtectedShort): Int = this % protectedValue.value
operator fun Short.rem(protectedValue: ProtectedInt): Int = this % protectedValue.value
operator fun Short.rem(protectedValue: ProtectedLong): Long = this % protectedValue.value
operator fun Short.rem(protectedValue: ProtectedFloat): Float = this % protectedValue.value
operator fun Short.rem(protectedValue: ProtectedDouble): Double = this % protectedValue.value
