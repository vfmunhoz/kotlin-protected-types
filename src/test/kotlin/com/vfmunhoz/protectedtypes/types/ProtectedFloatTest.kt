package com.vfmunhoz.protectedtypes.types

import kotlin.test.Test
import kotlin.test.assertEquals

internal class ProtectedFloatTest {

    private val primitiveByte: Byte = 10
    private val primitiveShort: Short = 12
    private val primitiveInt: Int = 14
    private val primitiveLong: Long = 16
    private val primitiveFloat: Float = 18.2f
    private val primitiveDouble: Double = 20.8

    private val protectedByte = ProtectedByte(primitiveByte)
    private val protectedShort = ProtectedShort(primitiveShort)
    private val protectedInt = ProtectedInt(primitiveInt)
    private val protectedLong = ProtectedLong(primitiveLong)
    private val protectedFloat = ProtectedFloat(primitiveFloat)
    private val protectedDouble = ProtectedDouble(primitiveDouble)

    private val maxProtectedFloat = ProtectedFloat(Float.MAX_VALUE)
    private val minProtectedFloat = ProtectedFloat(Float.MIN_VALUE)

    // Unary operators
    @Test
    fun `test the unary plus operator compared to Float type`() {
        assertEquals(+primitiveFloat, (+protectedFloat).value)
        assertEquals(primitiveFloat.unaryPlus(), protectedFloat.unaryPlus().value)

        assertEquals(+Float.MAX_VALUE, (+maxProtectedFloat).value)
        assertEquals(+Float.MIN_VALUE, (+minProtectedFloat).value)

        assertEquals(Float.MAX_VALUE.unaryPlus(), (maxProtectedFloat.unaryPlus()).value)
        assertEquals(Float.MIN_VALUE.unaryPlus(), (minProtectedFloat.unaryPlus()).value)
    }

    @Test
    fun `test the unary minus operator compared to Float type`() {
        assertEquals(-primitiveFloat, (-protectedFloat).value)
        assertEquals(primitiveFloat.unaryMinus(), protectedFloat.unaryMinus().value)

        assertEquals(-Float.MAX_VALUE, (-maxProtectedFloat).value)
        assertEquals(-Float.MIN_VALUE, (-minProtectedFloat).value)

        assertEquals(Float.MAX_VALUE.unaryMinus(), (maxProtectedFloat.unaryMinus()).value)
        assertEquals(Float.MIN_VALUE.unaryMinus(), (minProtectedFloat.unaryMinus()).value)
    }

    // Increment and decrement operators
    @Test
    fun `test the increment operator compared to Float type`() {
        var mutablePrimitiveFloat = primitiveFloat
        var mutableProtectedFloat = protectedFloat

        ++mutablePrimitiveFloat
        ++mutableProtectedFloat

        assertEquals(mutablePrimitiveFloat, mutableProtectedFloat.value)

        mutablePrimitiveFloat++
        mutableProtectedFloat++

        assertEquals(mutablePrimitiveFloat, mutableProtectedFloat.value)

        assertEquals(mutablePrimitiveFloat.inc(), mutableProtectedFloat.inc().value)

        var mutableMaxPrimitiveDouble = Float.MAX_VALUE
        var mutableMaxProtectedDouble = maxProtectedFloat

        assertEquals(++mutableMaxPrimitiveDouble, (++mutableMaxProtectedDouble).value)
    }

    @Test
    fun `test the decrement operator compared to Float type`() {
        var mutablePrimitiveFloat = primitiveFloat
        var mutableProtectedFloat = protectedFloat

        --mutablePrimitiveFloat
        --mutableProtectedFloat

        assertEquals(mutablePrimitiveFloat, mutableProtectedFloat.value)

        mutablePrimitiveFloat--
        mutableProtectedFloat--

        assertEquals(mutablePrimitiveFloat, mutableProtectedFloat.value)

        assertEquals(mutablePrimitiveFloat.dec(), mutableProtectedFloat.dec().value)

        var mutableMaxPrimitiveDouble = Float.MIN_VALUE
        var mutableMaxProtectedDouble = minProtectedFloat

        assertEquals(--mutableMaxPrimitiveDouble, (--mutableMaxProtectedDouble).value)
    }

    // Plus operator
    @Test
    fun `test the sum operator for ProtectedFloat + primitive value and compares the result with the same operation with native Float type`() {
        assertEquals(primitiveFloat + primitiveByte, (protectedFloat + primitiveByte).value, "protectedFloat.sum(primitiveByte)")
        assertEquals(primitiveFloat + primitiveShort, (protectedFloat + primitiveShort).value, "protectedFloat.sum(primitiveShort)")
        assertEquals(primitiveFloat + primitiveInt, (protectedFloat + primitiveInt).value, "protectedFloat.sum(primitiveInt)")
        assertEquals(primitiveFloat + primitiveLong, (protectedFloat + primitiveLong).value, "protectedFloat.sum(primitiveLong)")
        assertEquals(primitiveFloat + primitiveFloat, (protectedFloat + primitiveFloat).value, "protectedFloat.sum(primitiveFloat)")
        assertEquals(primitiveFloat + primitiveDouble, (protectedFloat + primitiveDouble).value, "protectedFloat.sum(primitiveDouble)")
    }

    @Test
    fun `test the sum operator for ProtectedFloat + protected value and compares the result with the same operation with native Float type`() {
        assertEquals(primitiveFloat + primitiveByte, (protectedFloat + protectedByte).value, "protectedFloat.sum(protectedByte)")
        assertEquals(primitiveFloat + primitiveShort, (protectedFloat + protectedShort).value, "protectedFloat.sum(protectedShort)")
        assertEquals(primitiveFloat + primitiveInt, (protectedFloat + protectedInt).value, "protectedFloat.sum(protectedInt)")
        assertEquals(primitiveFloat + primitiveLong, (protectedFloat + protectedLong).value, "protectedFloat.sum(protectedLong)")
        assertEquals(primitiveFloat + primitiveFloat, (protectedFloat + protectedFloat).value, "protectedFloat.sum(protectedFloat)")
        assertEquals(primitiveFloat + primitiveDouble, (protectedFloat + protectedDouble).value, "protectedFloat.sum(protectedDouble)")
    }

    @Test
    fun `test the sum operator for primitive value + protected value and compares the result with the same operation with native Float type`() {
        assertEquals(primitiveFloat + primitiveByte, primitiveFloat + protectedByte, "primitiveFloat.sum(protectedByte)")
        assertEquals(primitiveFloat + primitiveShort, primitiveFloat + protectedShort, "primitiveFloat.sum(protectedShort)")
        assertEquals(primitiveFloat + primitiveInt, primitiveFloat + protectedInt, "primitiveFloat.sum(protectedInt)")
        assertEquals(primitiveFloat + primitiveLong, primitiveFloat + protectedLong, "primitiveFloat.sum(protectedLong)")
        assertEquals(primitiveFloat + primitiveFloat, primitiveFloat + protectedFloat, "primitiveFloat.sum(protectedFloat)")
        assertEquals(primitiveFloat + primitiveDouble, primitiveFloat + protectedDouble, "primitiveFloat.sum(protectedDouble)")
    }
    
    // Minus operator
    @Test
    fun `test the minus operator for ProtectedFloat - primitive value and compares the result with the same operation with native Float type`() {
        assertEquals(primitiveFloat - primitiveByte, (protectedFloat - primitiveByte).value, "protectedFloat.minus(primitiveByte)")
        assertEquals(primitiveFloat - primitiveShort, (protectedFloat - primitiveShort).value, "protectedFloat.minus(primitiveShort)")
        assertEquals(primitiveFloat - primitiveInt, (protectedFloat - primitiveInt).value, "protectedFloat.minus(primitiveInt)")
        assertEquals(primitiveFloat - primitiveLong, (protectedFloat - primitiveLong).value, "protectedFloat.minus(primitiveLong)")
        assertEquals(primitiveFloat - primitiveFloat, (protectedFloat - primitiveFloat).value, "protectedFloat.minus(primitiveFloat)")
        assertEquals(primitiveFloat - primitiveDouble, (protectedFloat - primitiveDouble).value, "protectedFloat.minus(primitiveDouble)")
    }

    @Test
    fun `test the minus operator for ProtectedFloat - protected value and compares the result with the same operation with native Float type`() {
        assertEquals(primitiveFloat - primitiveByte, (protectedFloat - protectedByte).value, "protectedFloat.minus(protectedByte)")
        assertEquals(primitiveFloat - primitiveShort, (protectedFloat - protectedShort).value, "protectedFloat.minus(protectedShort)")
        assertEquals(primitiveFloat - primitiveInt, (protectedFloat - protectedInt).value, "protectedFloat.minus(protectedInt)")
        assertEquals(primitiveFloat - primitiveLong, (protectedFloat - protectedLong).value, "protectedFloat.minus(protectedLong)")
        assertEquals(primitiveFloat - primitiveFloat, (protectedFloat - protectedFloat).value, "protectedFloat.minus(protectedFloat)")
        assertEquals(primitiveFloat - primitiveDouble, (protectedFloat - protectedDouble).value, "protectedFloat.minus(protectedDouble)")
    }

    @Test
    fun `test the minus operator for primitive value - protected value and compares the result with the same operation with native Float type`() {
        assertEquals(primitiveFloat - primitiveByte, primitiveFloat - protectedByte, "primitiveFloat.minus(protectedByte)")
        assertEquals(primitiveFloat - primitiveShort, primitiveFloat - protectedShort, "primitiveFloat.minus(protectedShort)")
        assertEquals(primitiveFloat - primitiveInt, primitiveFloat - protectedInt, "primitiveFloat.minus(protectedInt)")
        assertEquals(primitiveFloat - primitiveLong, primitiveFloat - protectedLong, "primitiveFloat.minus(protectedLong)")
        assertEquals(primitiveFloat - primitiveFloat, primitiveFloat - protectedFloat, "primitiveFloat.minus(protectedFloat)")
        assertEquals(primitiveFloat - primitiveDouble, primitiveFloat - protectedDouble, "primitiveFloat.minus(protectedDouble)")
    }

    // Times operator
    @Test
    fun `test the times operator for ProtectedFloat times primitive value and compares the result with the same operation with native Float type`() {
        assertEquals(primitiveFloat * primitiveByte, (protectedFloat * primitiveByte).value, "protectedFloat.times(primitiveByte)")
        assertEquals(primitiveFloat * primitiveShort, (protectedFloat * primitiveShort).value, "protectedFloat.times(primitiveShort)")
        assertEquals(primitiveFloat * primitiveInt, (protectedFloat * primitiveInt).value, "protectedFloat.times(primitiveInt)")
        assertEquals(primitiveFloat * primitiveLong, (protectedFloat * primitiveLong).value, "protectedFloat.times(primitiveLong)")
        assertEquals(primitiveFloat * primitiveFloat, (protectedFloat * primitiveFloat).value, "protectedFloat.times(primitiveFloat)")
        assertEquals(primitiveFloat * primitiveDouble, (protectedFloat * primitiveDouble).value, "protectedFloat.times(primitiveDouble)")
    }

    @Test
    fun `test the times operator for ProtectedFloat times protected value and compares the result with the same operation with native Float type`() {
        assertEquals(primitiveFloat * primitiveByte, (protectedFloat * protectedByte).value, "protectedFloat.times(protectedByte)")
        assertEquals(primitiveFloat * primitiveShort, (protectedFloat * protectedShort).value, "protectedFloat.times(protectedShort)")
        assertEquals(primitiveFloat * primitiveInt, (protectedFloat * protectedInt).value, "protectedFloat.times(protectedInt)")
        assertEquals(primitiveFloat * primitiveLong, (protectedFloat * protectedLong).value, "protectedFloat.times(protectedLong)")
        assertEquals(primitiveFloat * primitiveFloat, (protectedFloat * protectedFloat).value, "protectedFloat.times(protectedFloat)")
        assertEquals(primitiveFloat * primitiveDouble, (protectedFloat * protectedDouble).value, "protectedFloat.times(protectedDouble)")
    }

    @Test
    fun `test the times operator for primitive value times protected value and compares the result with the same operation with native Float type`() {
        assertEquals(primitiveFloat * primitiveByte, primitiveFloat * protectedByte, "primitiveFloat.times(protectedByte)")
        assertEquals(primitiveFloat * primitiveShort, primitiveFloat * protectedShort, "primitiveFloat.times(protectedShort)")
        assertEquals(primitiveFloat * primitiveInt, primitiveFloat * protectedInt, "primitiveFloat.times(protectedInt)")
        assertEquals(primitiveFloat * primitiveLong, primitiveFloat * protectedLong, "primitiveFloat.times(protectedLong)")
        assertEquals(primitiveFloat * primitiveFloat, primitiveFloat * protectedFloat, "primitiveFloat.times(protectedFloat)")
        assertEquals(primitiveFloat * primitiveDouble, primitiveFloat * protectedDouble, "primitiveFloat.times(protectedDouble)")
    }

    // Div operator
    @Test
    fun `test the div operator for ProtectedFloat div primitive value and compares the result with the same operation with native Float type`() {
        assertEquals(primitiveFloat / primitiveByte, (protectedFloat / primitiveByte).value, "protectedFloat.div(primitiveByte)")
        assertEquals(primitiveFloat / primitiveShort, (protectedFloat / primitiveShort).value, "protectedFloat.div(primitiveShort)")
        assertEquals(primitiveFloat / primitiveInt, (protectedFloat / primitiveInt).value, "protectedFloat.div(primitiveInt)")
        assertEquals(primitiveFloat / primitiveLong, (protectedFloat / primitiveLong).value, "protectedFloat.div(primitiveLong)")
        assertEquals(primitiveFloat / primitiveFloat, (protectedFloat / primitiveFloat).value, "protectedFloat.div(primitiveFloat)")
        assertEquals(primitiveFloat / primitiveDouble, (protectedFloat / primitiveDouble).value, "protectedFloat.div(primitiveDouble)")
    }

    @Test
    fun `test the div operator for ProtectedFloat div protected value and compares the result with the same operation with native Float type`() {
        assertEquals(primitiveFloat / primitiveByte, (protectedFloat / protectedByte).value, "protectedFloat.div(protectedByte)")
        assertEquals(primitiveFloat / primitiveShort, (protectedFloat / protectedShort).value, "protectedFloat.div(protectedShort)")
        assertEquals(primitiveFloat / primitiveInt, (protectedFloat / protectedInt).value, "protectedFloat.div(protectedInt)")
        assertEquals(primitiveFloat / primitiveLong, (protectedFloat / protectedLong).value, "protectedFloat.div(protectedLong)")
        assertEquals(primitiveFloat / primitiveFloat, (protectedFloat / protectedFloat).value, "protectedFloat.div(protectedFloat)")
        assertEquals(primitiveFloat / primitiveDouble, (protectedFloat / protectedDouble).value, "protectedFloat.div(protectedDouble)")
    }

    @Test
    fun `test the div operator for primitive value div protected value and compares the result with the same operation with native Float type`() {
        assertEquals(primitiveFloat / primitiveByte, primitiveFloat / protectedByte, "primitiveFloat.div(protectedByte)")
        assertEquals(primitiveFloat / primitiveShort, primitiveFloat / protectedShort, "primitiveFloat.div(protectedShort)")
        assertEquals(primitiveFloat / primitiveInt, primitiveFloat / protectedInt, "primitiveFloat.div(protectedInt)")
        assertEquals(primitiveFloat / primitiveLong, primitiveFloat / protectedLong, "primitiveFloat.div(protectedLong)")
        assertEquals(primitiveFloat / primitiveFloat, primitiveFloat / protectedFloat, "primitiveFloat.div(protectedFloat)")
        assertEquals(primitiveFloat / primitiveDouble, primitiveFloat / protectedDouble, "primitiveFloat.div(protectedDouble)")
    }

    // Rem operator
    @Test
    fun `test the rem operator for ProtectedFloat rem primitive value and compares the result with the same operation with native Float type`() {
        assertEquals(primitiveFloat % primitiveByte, (protectedFloat % primitiveByte).value, "protectedFloat.rem(primitiveByte)")
        assertEquals(primitiveFloat % primitiveShort, (protectedFloat % primitiveShort).value, "protectedFloat.rem(primitiveShort)")
        assertEquals(primitiveFloat % primitiveInt, (protectedFloat % primitiveInt).value, "protectedFloat.rem(primitiveInt)")
        assertEquals(primitiveFloat % primitiveLong, (protectedFloat % primitiveLong).value, "protectedFloat.rem(primitiveLong)")
        assertEquals(primitiveFloat % primitiveFloat, (protectedFloat % primitiveFloat).value, "protectedFloat.rem(primitiveFloat)")
        assertEquals(primitiveFloat % primitiveDouble, (protectedFloat % primitiveDouble).value, "protectedFloat.rem(primitiveDouble)")
    }

    @Test
    fun `test the rem operator for ProtectedFloat rem protected value and compares the result with the same operation with native Float type`() {
        assertEquals(primitiveFloat % primitiveByte, (protectedFloat % protectedByte).value, "protectedFloat.rem(protectedByte)")
        assertEquals(primitiveFloat % primitiveShort, (protectedFloat % protectedShort).value, "protectedFloat.rem(protectedShort)")
        assertEquals(primitiveFloat % primitiveInt, (protectedFloat % protectedInt).value, "protectedFloat.rem(protectedInt)")
        assertEquals(primitiveFloat % primitiveLong, (protectedFloat % protectedLong).value, "protectedFloat.rem(protectedLong)")
        assertEquals(primitiveFloat % primitiveFloat, (protectedFloat % protectedFloat).value, "protectedFloat.rem(protectedFloat)")
        assertEquals(primitiveFloat % primitiveDouble, (protectedFloat % protectedDouble).value, "protectedFloat.rem(protectedDouble)")
    }

    @Test
    fun `test the rem operator for primitive value rem protected value and compares the result with the same operation with native Float type`() {
        assertEquals(primitiveFloat % primitiveByte, primitiveFloat % protectedByte, "primitiveFloat.rem(protectedByte)")
        assertEquals(primitiveFloat % primitiveShort, primitiveFloat % protectedShort, "primitiveFloat.rem(protectedShort)")
        assertEquals(primitiveFloat % primitiveInt, primitiveFloat % protectedInt, "primitiveFloat.rem(protectedInt)")
        assertEquals(primitiveFloat % primitiveLong, primitiveFloat % protectedLong, "primitiveFloat.rem(protectedLong)")
        assertEquals(primitiveFloat % primitiveFloat, primitiveFloat % protectedFloat, "primitiveFloat.rem(protectedFloat)")
        assertEquals(primitiveFloat % primitiveDouble, primitiveFloat % protectedDouble, "primitiveFloat.rem(protectedDouble)")
    }
}
