package com.vfmunhoz.protectedtypes.types

import kotlin.test.Test
import kotlin.test.assertEquals

internal class ProtectedDoubleTest {

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

    private val maxProtectedDouble = ProtectedDouble(Double.MAX_VALUE)
    private val minProtectedDouble = ProtectedDouble(Double.MIN_VALUE)

    // Unary operators
    @Test
    fun `test the unary plus operator compared to Double type`() {
        assertEquals(+primitiveDouble, (+protectedDouble).value)
        assertEquals(primitiveDouble.unaryPlus(), protectedDouble.unaryPlus().value)

        assertEquals(+Double.MAX_VALUE, (+maxProtectedDouble).value)
        assertEquals(+Double.MIN_VALUE, (+minProtectedDouble).value)

        assertEquals(Double.MAX_VALUE.unaryPlus(), (maxProtectedDouble.unaryPlus()).value)
        assertEquals(Double.MIN_VALUE.unaryPlus(), (minProtectedDouble.unaryPlus()).value)
    }

    @Test
    fun `test the unary minus operator compared to Double type`() {
        assertEquals(-primitiveDouble, (-protectedDouble).value)
        assertEquals(primitiveDouble.unaryMinus(), protectedDouble.unaryMinus().value)

        assertEquals(-Double.MAX_VALUE, (-maxProtectedDouble).value)
        assertEquals(-Double.MIN_VALUE, (-minProtectedDouble).value)

        assertEquals(Double.MAX_VALUE.unaryMinus(), (maxProtectedDouble.unaryMinus()).value)
        assertEquals(Double.MIN_VALUE.unaryMinus(), (minProtectedDouble.unaryMinus()).value)
    }

    // Increment and decrement operators
    @Test
    fun `test the increment operator compared to Double type`() {
        var mutablePrimitiveDouble = primitiveDouble
        var mutableProtectedDouble = protectedDouble

        ++mutablePrimitiveDouble
        ++mutableProtectedDouble

        assertEquals(mutablePrimitiveDouble, mutableProtectedDouble.value)

        mutablePrimitiveDouble++
        mutableProtectedDouble++

        assertEquals(mutablePrimitiveDouble, mutableProtectedDouble.value)

        assertEquals(mutablePrimitiveDouble.inc(), mutableProtectedDouble.inc().value)

        var mutableMaxPrimitiveDouble = Double.MAX_VALUE
        var mutableMaxProtectedDouble = maxProtectedDouble

        assertEquals(++mutableMaxPrimitiveDouble, (++mutableMaxProtectedDouble).value)
    }

    @Test
    fun `test the decrement operator compared to Double type`() {
        var mutablePrimitiveDouble = primitiveDouble
        var mutableProtectedDouble = protectedDouble

        --mutablePrimitiveDouble
        --mutableProtectedDouble

        assertEquals(mutablePrimitiveDouble, mutableProtectedDouble.value)

        mutablePrimitiveDouble--
        mutableProtectedDouble--

        assertEquals(mutablePrimitiveDouble, mutableProtectedDouble.value)

        assertEquals(mutablePrimitiveDouble.dec(), mutableProtectedDouble.dec().value)

        var mutableMaxPrimitiveDouble = Double.MIN_VALUE
        var mutableMaxProtectedDouble = minProtectedDouble

        assertEquals(--mutableMaxPrimitiveDouble, (--mutableMaxProtectedDouble).value)
    }

    // Plus operator
    @Test
    fun `test the sum operator for ProtectedDouble + Double and compares the result with the same operation with native Double type`() {
        assertEquals(primitiveDouble + primitiveByte, (protectedDouble + primitiveByte).value, "protectedDouble.sum(primitiveByte)")
        assertEquals(primitiveDouble + primitiveShort, (protectedDouble + primitiveShort).value, "protectedDouble.sum(primitiveShort)")
        assertEquals(primitiveDouble + primitiveInt, (protectedDouble + primitiveInt).value, "protectedDouble.sum(primitiveInt)")
        assertEquals(primitiveDouble + primitiveLong, (protectedDouble + primitiveLong).value, "protectedDouble.sum(primitiveLong)")
        assertEquals(primitiveDouble + primitiveFloat, (protectedDouble + primitiveFloat).value, "protectedDouble.sum(primitiveFloat)")
        assertEquals(primitiveDouble + primitiveDouble, (protectedDouble + primitiveDouble).value, "protectedDouble.sum(primitiveDouble)")
    }

    @Test
    fun `test the sum operator for ProtectedDouble + ProtectedDouble and compares the result with the same operation with native Double type`() {
        assertEquals(primitiveDouble + primitiveByte, (protectedDouble + protectedByte).value, "protectedDouble.sum(protectedByte)")
        assertEquals(primitiveDouble + primitiveShort, (protectedDouble + protectedShort).value, "protectedDouble.sum(protectedShort)")
        assertEquals(primitiveDouble + primitiveInt, (protectedDouble + protectedInt).value, "protectedDouble.sum(protectedInt)")
        assertEquals(primitiveDouble + primitiveLong, (protectedDouble + protectedLong).value, "protectedDouble.sum(protectedLong)")
        assertEquals(primitiveDouble + primitiveFloat, (protectedDouble + protectedFloat).value, "protectedDouble.sum(protectedFloat)")
        assertEquals(primitiveDouble + primitiveDouble, (protectedDouble + protectedDouble).value, "protectedDouble.sum(protectedDouble)")
    }

    @Test
    fun `test the sum operator for Double + ProtectedDouble and compares the result with the same operation with native Double type`() {
        assertEquals(primitiveDouble + primitiveByte, primitiveDouble + protectedByte, "primitiveByte.sum(protectedByte)")
        assertEquals(primitiveDouble + primitiveShort, primitiveDouble + protectedShort, "primitiveDouble.sum(protectedShort)")
        assertEquals(primitiveDouble + primitiveInt, primitiveDouble + protectedInt, "primitiveDouble.sum(protectedInt)")
        assertEquals(primitiveDouble + primitiveLong, primitiveDouble + protectedLong, "primitiveDouble.sum(protectedLong)")
        assertEquals(primitiveDouble + primitiveFloat, primitiveDouble + protectedFloat, "primitiveDouble.sum(protectedFloat)")
        assertEquals(primitiveDouble + primitiveDouble, primitiveDouble + protectedDouble, "primitiveDouble.sum(protectedDouble)")
    }
    
    // Minus operator
    @Test
    fun `test the minus operator for ProtectedDouble - Double and compares the result with the same operation with native Double type`() {
        assertEquals(primitiveDouble - primitiveByte, (protectedDouble - primitiveByte).value, "protectedDouble.minus(primitiveByte)")
        assertEquals(primitiveDouble - primitiveShort, (protectedDouble - primitiveShort).value, "protectedDouble.minus(primitiveShort)")
        assertEquals(primitiveDouble - primitiveInt, (protectedDouble - primitiveInt).value, "protectedDouble.minus(primitiveInt)")
        assertEquals(primitiveDouble - primitiveLong, (protectedDouble - primitiveLong).value, "protectedDouble.minus(primitiveLong)")
        assertEquals(primitiveDouble - primitiveFloat, (protectedDouble - primitiveFloat).value, "protectedDouble.minus(primitiveFloat)")
        assertEquals(primitiveDouble - primitiveDouble, (protectedDouble - primitiveDouble).value, "protectedDouble.minus(primitiveDouble)")
    }

    @Test
    fun `test the sum operator for ProtectedDouble - ProtectedDouble and compares the result with the same operation with native Double type`() {
        assertEquals(primitiveDouble - primitiveByte, (protectedDouble - protectedByte).value, "protectedDouble.minus(protectedByte)")
        assertEquals(primitiveDouble - primitiveShort, (protectedDouble - protectedShort).value, "protectedDouble.minus(protectedShort)")
        assertEquals(primitiveDouble - primitiveInt, (protectedDouble - protectedInt).value, "protectedDouble.minus(protectedInt)")
        assertEquals(primitiveDouble - primitiveLong, (protectedDouble - protectedLong).value, "protectedDouble.minus(protectedLong)")
        assertEquals(primitiveDouble - primitiveFloat, (protectedDouble - protectedFloat).value, "protectedDouble.minus(protectedFloat)")
        assertEquals(primitiveDouble - primitiveDouble, (protectedDouble - protectedDouble).value, "protectedDouble.minus(protectedDouble)")
    }

    @Test
    fun `test the sum operator for Double - ProtectedDouble and compares the result with the same operation with native Double type`() {
        assertEquals(primitiveDouble - primitiveByte, primitiveDouble - protectedByte, "primitiveByte.minus(protectedByte)")
        assertEquals(primitiveDouble - primitiveShort, primitiveDouble - protectedShort, "primitiveDouble.minus(protectedShort)")
        assertEquals(primitiveDouble - primitiveInt, primitiveDouble - protectedInt, "primitiveDouble.minus(protectedInt)")
        assertEquals(primitiveDouble - primitiveLong, primitiveDouble - protectedLong, "primitiveDouble.minus(protectedLong)")
        assertEquals(primitiveDouble - primitiveFloat, primitiveDouble - protectedFloat, "primitiveDouble.minus(protectedFloat)")
        assertEquals(primitiveDouble - primitiveDouble, primitiveDouble - protectedDouble, "primitiveDouble.minus(protectedDouble)")
    }
}
