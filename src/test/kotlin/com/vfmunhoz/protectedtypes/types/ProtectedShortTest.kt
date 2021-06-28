package com.vfmunhoz.protectedtypes.types

import kotlin.test.Test
import kotlin.test.assertEquals

internal class ProtectedShortTest {

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

    private val maxProtected = ProtectedShort(Short.MAX_VALUE)
    private val minProtected = ProtectedShort(Short.MIN_VALUE)

    // Unary operators
    @Test
    fun `test the unary plus operator compared to Short type`() {
        assertEquals(+primitiveShort, (+protectedShort).value)
        assertEquals(primitiveShort.unaryPlus(), protectedShort.unaryPlus().value)

        assertEquals(+Short.MAX_VALUE, (+maxProtected).value)
        assertEquals(+Short.MIN_VALUE, (+minProtected).value)

        assertEquals(Short.MAX_VALUE.unaryPlus(), (maxProtected.unaryPlus()).value)
        assertEquals(Short.MIN_VALUE.unaryPlus(), (minProtected.unaryPlus()).value)
    }

    @Test
    fun `test the unary minus operator compared to Short type`() {
        assertEquals(-primitiveShort, (-protectedShort).value)
        assertEquals(primitiveShort.unaryMinus(), protectedShort.unaryMinus().value)

        assertEquals(-Short.MAX_VALUE, (-maxProtected).value)
        assertEquals(-Short.MIN_VALUE, (-minProtected).value)

        assertEquals(Short.MAX_VALUE.unaryMinus(), (maxProtected.unaryMinus()).value)
        assertEquals(Short.MIN_VALUE.unaryMinus(), (minProtected.unaryMinus()).value)
    }

    // Increment and decrement operators
    @Test
    fun `test the increment operator compared to Short type`() {
        var mutablePrimitive = primitiveShort
        var mutableProtected = protectedShort

        ++mutablePrimitive
        ++mutableProtected

        assertEquals(mutablePrimitive, mutableProtected.value)

        mutablePrimitive++
        mutableProtected++

        assertEquals(mutablePrimitive, mutableProtected.value)

        assertEquals(mutablePrimitive.inc(), mutableProtected.inc().value)

        var mutableMaxPrimitive = Short.MAX_VALUE
        var mutableMaxProtected = maxProtected

        assertEquals(++mutableMaxPrimitive, (++mutableMaxProtected).value)
    }

    @Test
    fun `test the decrement operator compared to Short type`() {
        var mutablePrimitive = primitiveShort
        var mutableProtected = protectedShort

        --mutablePrimitive
        --mutableProtected

        assertEquals(mutablePrimitive, mutableProtected.value)

        mutablePrimitive--
        mutableProtected--

        assertEquals(mutablePrimitive, mutableProtected.value)

        assertEquals(mutablePrimitive.dec(), mutableProtected.dec().value)

        var mutableMaxPrimitiveDouble = Short.MIN_VALUE
        var mutableMaxProtectedDouble = minProtected

        assertEquals(--mutableMaxPrimitiveDouble, (--mutableMaxProtectedDouble).value)
    }

    // Plus operator
    @Test
    fun `test the sum operator for ProtectedShort + primitive value and compares the result with the same operation with native Short type`() {
        assertEquals(primitiveShort + primitiveByte, (protectedShort + primitiveByte).value, "protectedShort.sum(primitiveByte)")
        assertEquals(primitiveShort + primitiveShort, (protectedShort + primitiveShort).value, "protectedShort.sum(primitiveShort)")
        assertEquals(primitiveShort + primitiveInt, (protectedShort + primitiveInt).value, "protectedShort.sum(primitiveInt)")
        assertEquals(primitiveShort + primitiveLong, (protectedShort + primitiveLong).value, "protectedShort.sum(primitiveLong)")
        assertEquals(primitiveShort + primitiveFloat, (protectedShort + primitiveFloat).value, "protectedShort.sum(primitiveFloat)")
        assertEquals(primitiveShort + primitiveDouble, (protectedShort + primitiveDouble).value, "protectedShort.sum(primitiveDouble)")
    }

    @Test
    fun `test the sum operator for ProtectedShort + protected value and compares the result with the same operation with native Short type`() {
        assertEquals(primitiveShort + primitiveByte, (protectedShort + protectedByte).value, "protectedShort.sum(protectedByte)")
        assertEquals(primitiveShort + primitiveShort, (protectedShort + protectedShort).value, "protectedShort.sum(protectedShort)")
        assertEquals(primitiveShort + primitiveInt, (protectedShort + protectedInt).value, "protectedShort.sum(protectedInt)")
        assertEquals(primitiveShort + primitiveLong, (protectedShort + protectedLong).value, "protectedShort.sum(protectedLong)")
        assertEquals(primitiveShort + primitiveFloat, (protectedShort + protectedFloat).value, "protectedShort.sum(protectedFloat)")
        assertEquals(primitiveShort + primitiveDouble, (protectedShort + protectedDouble).value, "protectedShort.sum(protectedDouble)")
    }

    @Test
    fun `test the sum operator for primitive value + protected value and compares the result with the same operation with native Short type`() {
        assertEquals(primitiveShort + primitiveByte, primitiveShort + protectedByte, "primitiveShort.sum(protectedByte)")
        assertEquals(primitiveShort + primitiveShort, primitiveShort + protectedShort, "primitiveShort.sum(protectedShort)")
        assertEquals(primitiveShort + primitiveInt, primitiveShort + protectedInt, "primitiveShort.sum(protectedInt)")
        assertEquals(primitiveShort + primitiveLong, primitiveShort + protectedLong, "primitiveShort.sum(protectedLong)")
        assertEquals(primitiveShort + primitiveFloat, primitiveShort + protectedFloat, "primitiveShort.sum(protectedFloat)")
        assertEquals(primitiveShort + primitiveDouble, primitiveShort + protectedDouble, "primitiveShort.sum(protectedDouble)")
    }

    // Minus operator
    @Test
    fun `test the minus operator for ProtectedShort - primitive value and compares the result with the same operation with native Short type`() {
        assertEquals(primitiveShort - primitiveByte, (protectedShort - primitiveByte).value, "protectedShort.minus(primitiveByte)")
        assertEquals(primitiveShort - primitiveShort, (protectedShort - primitiveShort).value, "protectedShort.minus(primitiveShort)")
        assertEquals(primitiveShort - primitiveInt, (protectedShort - primitiveInt).value, "protectedShort.minus(primitiveInt)")
        assertEquals(primitiveShort - primitiveLong, (protectedShort - primitiveLong).value, "protectedShort.minus(primitiveLong)")
        assertEquals(primitiveShort - primitiveFloat, (protectedShort - primitiveFloat).value, "protectedShort.minus(primitiveFloat)")
        assertEquals(primitiveShort - primitiveDouble, (protectedShort - primitiveDouble).value, "protectedShort.minus(primitiveDouble)")
    }

    @Test
    fun `test the minus operator for ProtectedShort - protected value and compares the result with the same operation with native Short type`() {
        assertEquals(primitiveShort - primitiveByte, (protectedShort - protectedByte).value, "protectedShort.minus(protectedByte)")
        assertEquals(primitiveShort - primitiveShort, (protectedShort - protectedShort).value, "protectedShort.minus(protectedShort)")
        assertEquals(primitiveShort - primitiveInt, (protectedShort - protectedInt).value, "protectedShort.minus(protectedInt)")
        assertEquals(primitiveShort - primitiveLong, (protectedShort - protectedLong).value, "protectedShort.minus(protectedLong)")
        assertEquals(primitiveShort - primitiveFloat, (protectedShort - protectedFloat).value, "protectedShort.minus(protectedFloat)")
        assertEquals(primitiveShort - primitiveDouble, (protectedShort - protectedDouble).value, "protectedShort.minus(protectedDouble)")
    }

    @Test
    fun `test the minus operator for primitive value - protected value and compares the result with the same operation with native Short type`() {
        assertEquals(primitiveShort - primitiveByte, primitiveShort - protectedByte, "primitiveShort.minus(protectedByte)")
        assertEquals(primitiveShort - primitiveShort, primitiveShort - protectedShort, "primitiveShort.minus(protectedShort)")
        assertEquals(primitiveShort - primitiveInt, primitiveShort - protectedInt, "primitiveShort.minus(protectedInt)")
        assertEquals(primitiveShort - primitiveLong, primitiveShort - protectedLong, "primitiveShort.minus(protectedLong)")
        assertEquals(primitiveShort - primitiveFloat, primitiveShort - protectedFloat, "primitiveShort.minus(protectedFloat)")
        assertEquals(primitiveShort - primitiveDouble, primitiveShort - protectedDouble, "primitiveShort.minus(protectedDouble)")
    }

    // Times operator
    @Test
    fun `test the times operator for ProtectedShort times primitive value and compares the result with the same operation with native Short type`() {
        assertEquals(primitiveShort * primitiveByte, (protectedShort * primitiveByte).value, "protectedShort.times(primitiveByte)")
        assertEquals(primitiveShort * primitiveShort, (protectedShort * primitiveShort).value, "protectedShort.times(primitiveShort)")
        assertEquals(primitiveShort * primitiveInt, (protectedShort * primitiveInt).value, "protectedShort.times(primitiveInt)")
        assertEquals(primitiveShort * primitiveLong, (protectedShort * primitiveLong).value, "protectedShort.times(primitiveLong)")
        assertEquals(primitiveShort * primitiveFloat, (protectedShort * primitiveFloat).value, "protectedShort.times(primitiveFloat)")
        assertEquals(primitiveShort * primitiveDouble, (protectedShort * primitiveDouble).value, "protectedShort.times(primitiveDouble)")
    }

    @Test
    fun `test the times operator for ProtectedShort times protected value and compares the result with the same operation with native Short type`() {
        assertEquals(primitiveShort * primitiveByte, (protectedShort * protectedByte).value, "protectedShort.times(protectedByte)")
        assertEquals(primitiveShort * primitiveShort, (protectedShort * protectedShort).value, "protectedShort.times(protectedShort)")
        assertEquals(primitiveShort * primitiveInt, (protectedShort * protectedInt).value, "protectedShort.times(protectedInt)")
        assertEquals(primitiveShort * primitiveLong, (protectedShort * protectedLong).value, "protectedShort.times(protectedLong)")
        assertEquals(primitiveShort * primitiveFloat, (protectedShort * protectedFloat).value, "protectedShort.times(protectedFloat)")
        assertEquals(primitiveShort * primitiveDouble, (protectedShort * protectedDouble).value, "protectedShort.times(protectedDouble)")
    }

    @Test
    fun `test the times operator for primitive value times protected value and compares the result with the same operation with native Short type`() {
        assertEquals(primitiveShort * primitiveByte, primitiveShort * protectedByte, "primitiveShort.times(protectedByte)")
        assertEquals(primitiveShort * primitiveShort, primitiveShort * protectedShort, "primitiveShort.times(protectedShort)")
        assertEquals(primitiveShort * primitiveInt, primitiveShort * protectedInt, "primitiveShort.times(protectedInt)")
        assertEquals(primitiveShort * primitiveLong, primitiveShort * protectedLong, "primitiveShort.times(protectedLong)")
        assertEquals(primitiveShort * primitiveFloat, primitiveShort * protectedFloat, "primitiveShort.times(protectedFloat)")
        assertEquals(primitiveShort * primitiveDouble, primitiveShort * protectedDouble, "primitiveShort.times(protectedDouble)")
    }

    // Div operator
    @Test
    fun `test the div operator for ProtectedShort div primitive value and compares the result with the same operation with native Short type`() {
        assertEquals(primitiveShort / primitiveByte, (protectedShort / primitiveByte).value, "protectedShort.div(primitiveByte)")
        assertEquals(primitiveShort / primitiveShort, (protectedShort / primitiveShort).value, "protectedShort.div(primitiveShort)")
        assertEquals(primitiveShort / primitiveInt, (protectedShort / primitiveInt).value, "protectedShort.div(primitiveInt)")
        assertEquals(primitiveShort / primitiveLong, (protectedShort / primitiveLong).value, "protectedShort.div(primitiveLong)")
        assertEquals(primitiveShort / primitiveFloat, (protectedShort / primitiveFloat).value, "protectedShort.div(primitiveFloat)")
        assertEquals(primitiveShort / primitiveDouble, (protectedShort / primitiveDouble).value, "protectedShort.div(primitiveDouble)")
    }

    @Test
    fun `test the div operator for ProtectedShort div protected value and compares the result with the same operation with native Short type`() {
        assertEquals(primitiveShort / primitiveByte, (protectedShort / protectedByte).value, "protectedShort.div(protectedByte)")
        assertEquals(primitiveShort / primitiveShort, (protectedShort / protectedShort).value, "protectedShort.div(protectedShort)")
        assertEquals(primitiveShort / primitiveInt, (protectedShort / protectedInt).value, "protectedShort.div(protectedInt)")
        assertEquals(primitiveShort / primitiveLong, (protectedShort / protectedLong).value, "protectedShort.div(protectedLong)")
        assertEquals(primitiveShort / primitiveFloat, (protectedShort / protectedFloat).value, "protectedShort.div(protectedFloat)")
        assertEquals(primitiveShort / primitiveDouble, (protectedShort / protectedDouble).value, "protectedShort.div(protectedDouble)")
    }

    @Test
    fun `test the div operator for primitive value div protected value and compares the result with the same operation with native Short type`() {
        assertEquals(primitiveShort / primitiveByte, primitiveShort / protectedByte, "primitiveShort.div(protectedByte)")
        assertEquals(primitiveShort / primitiveShort, primitiveShort / protectedShort, "primitiveShort.div(protectedShort)")
        assertEquals(primitiveShort / primitiveInt, primitiveShort / protectedInt, "primitiveShort.div(protectedInt)")
        assertEquals(primitiveShort / primitiveLong, primitiveShort / protectedLong, "primitiveShort.div(protectedLong)")
        assertEquals(primitiveShort / primitiveFloat, primitiveShort / protectedFloat, "primitiveShort.div(protectedFloat)")
        assertEquals(primitiveShort / primitiveDouble, primitiveShort / protectedDouble, "primitiveShort.div(protectedDouble)")
    }

    // Rem operator
    @Test
    fun `test the rem operator for ProtectedShort rem primitive value and compares the result with the same operation with native Short type`() {
        assertEquals(primitiveShort % primitiveByte, (protectedShort % primitiveByte).value, "protectedShort.rem(primitiveByte)")
        assertEquals(primitiveShort % primitiveShort, (protectedShort % primitiveShort).value, "protectedShort.rem(primitiveShort)")
        assertEquals(primitiveShort % primitiveInt, (protectedShort % primitiveInt).value, "protectedShort.rem(primitiveInt)")
        assertEquals(primitiveShort % primitiveLong, (protectedShort % primitiveLong).value, "protectedShort.rem(primitiveLong)")
        assertEquals(primitiveShort % primitiveFloat, (protectedShort % primitiveFloat).value, "protectedShort.rem(primitiveFloat)")
        assertEquals(primitiveShort % primitiveDouble, (protectedShort % primitiveDouble).value, "protectedShort.rem(primitiveDouble)")
    }

    @Test
    fun `test the rem operator for ProtectedShort rem protected value and compares the result with the same operation with native Short type`() {
        assertEquals(primitiveShort % primitiveByte, (protectedShort % protectedByte).value, "protectedShort.rem(protectedByte)")
        assertEquals(primitiveShort % primitiveShort, (protectedShort % protectedShort).value, "protectedShort.rem(protectedShort)")
        assertEquals(primitiveShort % primitiveInt, (protectedShort % protectedInt).value, "protectedShort.rem(protectedInt)")
        assertEquals(primitiveShort % primitiveLong, (protectedShort % protectedLong).value, "protectedShort.rem(protectedLong)")
        assertEquals(primitiveShort % primitiveFloat, (protectedShort % protectedFloat).value, "protectedShort.rem(protectedFloat)")
        assertEquals(primitiveShort % primitiveDouble, (protectedShort % protectedDouble).value, "protectedShort.rem(protectedDouble)")
    }

    @Test
    fun `test the rem operator for primitive value rem protected value and compares the result with the same operation with native Short type`() {
        assertEquals(primitiveShort % primitiveByte, primitiveShort % protectedByte, "primitiveShort.rem(protectedByte)")
        assertEquals(primitiveShort % primitiveShort, primitiveShort % protectedShort, "primitiveShort.rem(protectedShort)")
        assertEquals(primitiveShort % primitiveInt, primitiveShort % protectedInt, "primitiveShort.rem(protectedInt)")
        assertEquals(primitiveShort % primitiveLong, primitiveShort % protectedLong, "primitiveShort.rem(protectedLong)")
        assertEquals(primitiveShort % primitiveFloat, primitiveShort % protectedFloat, "primitiveShort.rem(protectedFloat)")
        assertEquals(primitiveShort % primitiveDouble, primitiveShort % protectedDouble, "primitiveShort.rem(protectedDouble)")
    }
}
