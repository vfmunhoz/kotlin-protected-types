package io.github.vfmunhoz.protectedtypes.types

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertIs

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

    @Test
    fun `validates the transformation to protected value`() {
        assertIs<ProtectedDouble>(primitiveDouble.toProtected())
    }

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
    fun `test the sum operator for ProtectedDouble + primitive value and compares the result with the same operation with native Double type`() {
        assertEquals(primitiveDouble + primitiveByte, (protectedDouble + primitiveByte).value, "protectedDouble.sum(primitiveByte)")
        assertEquals(primitiveDouble + primitiveShort, (protectedDouble + primitiveShort).value, "protectedDouble.sum(primitiveShort)")
        assertEquals(primitiveDouble + primitiveInt, (protectedDouble + primitiveInt).value, "protectedDouble.sum(primitiveInt)")
        assertEquals(primitiveDouble + primitiveLong, (protectedDouble + primitiveLong).value, "protectedDouble.sum(primitiveLong)")
        assertEquals(primitiveDouble + primitiveFloat, (protectedDouble + primitiveFloat).value, "protectedDouble.sum(primitiveFloat)")
        assertEquals(primitiveDouble + primitiveDouble, (protectedDouble + primitiveDouble).value, "protectedDouble.sum(primitiveDouble)")
    }

    @Test
    fun `test the sum operator for ProtectedDouble + protected value and compares the result with the same operation with native Double type`() {
        assertEquals(primitiveDouble + primitiveByte, (protectedDouble + protectedByte).value, "protectedDouble.sum(protectedByte)")
        assertEquals(primitiveDouble + primitiveShort, (protectedDouble + protectedShort).value, "protectedDouble.sum(protectedShort)")
        assertEquals(primitiveDouble + primitiveInt, (protectedDouble + protectedInt).value, "protectedDouble.sum(protectedInt)")
        assertEquals(primitiveDouble + primitiveLong, (protectedDouble + protectedLong).value, "protectedDouble.sum(protectedLong)")
        assertEquals(primitiveDouble + primitiveFloat, (protectedDouble + protectedFloat).value, "protectedDouble.sum(protectedFloat)")
        assertEquals(primitiveDouble + primitiveDouble, (protectedDouble + protectedDouble).value, "protectedDouble.sum(protectedDouble)")
    }

    @Test
    fun `test the sum operator for primitive value + protected value and compares the result with the same operation with native Double type`() {
        assertEquals(primitiveDouble + primitiveByte, primitiveDouble + protectedByte, "primitiveDouble.sum(protectedByte)")
        assertEquals(primitiveDouble + primitiveShort, primitiveDouble + protectedShort, "primitiveDouble.sum(protectedShort)")
        assertEquals(primitiveDouble + primitiveInt, primitiveDouble + protectedInt, "primitiveDouble.sum(protectedInt)")
        assertEquals(primitiveDouble + primitiveLong, primitiveDouble + protectedLong, "primitiveDouble.sum(protectedLong)")
        assertEquals(primitiveDouble + primitiveFloat, primitiveDouble + protectedFloat, "primitiveDouble.sum(protectedFloat)")
        assertEquals(primitiveDouble + primitiveDouble, primitiveDouble + protectedDouble, "primitiveDouble.sum(protectedDouble)")
    }
    
    // Minus operator
    @Test
    fun `test the minus operator for ProtectedDouble - primitive value and compares the result with the same operation with native Double type`() {
        assertEquals(primitiveDouble - primitiveByte, (protectedDouble - primitiveByte).value, "protectedDouble.minus(primitiveByte)")
        assertEquals(primitiveDouble - primitiveShort, (protectedDouble - primitiveShort).value, "protectedDouble.minus(primitiveShort)")
        assertEquals(primitiveDouble - primitiveInt, (protectedDouble - primitiveInt).value, "protectedDouble.minus(primitiveInt)")
        assertEquals(primitiveDouble - primitiveLong, (protectedDouble - primitiveLong).value, "protectedDouble.minus(primitiveLong)")
        assertEquals(primitiveDouble - primitiveFloat, (protectedDouble - primitiveFloat).value, "protectedDouble.minus(primitiveFloat)")
        assertEquals(primitiveDouble - primitiveDouble, (protectedDouble - primitiveDouble).value, "protectedDouble.minus(primitiveDouble)")
    }

    @Test
    fun `test the minus operator for ProtectedDouble - protected value and compares the result with the same operation with native Double type`() {
        assertEquals(primitiveDouble - primitiveByte, (protectedDouble - protectedByte).value, "protectedDouble.minus(protectedByte)")
        assertEquals(primitiveDouble - primitiveShort, (protectedDouble - protectedShort).value, "protectedDouble.minus(protectedShort)")
        assertEquals(primitiveDouble - primitiveInt, (protectedDouble - protectedInt).value, "protectedDouble.minus(protectedInt)")
        assertEquals(primitiveDouble - primitiveLong, (protectedDouble - protectedLong).value, "protectedDouble.minus(protectedLong)")
        assertEquals(primitiveDouble - primitiveFloat, (protectedDouble - protectedFloat).value, "protectedDouble.minus(protectedFloat)")
        assertEquals(primitiveDouble - primitiveDouble, (protectedDouble - protectedDouble).value, "protectedDouble.minus(protectedDouble)")
    }

    @Test
    fun `test the minus operator for primitive value - protected value and compares the result with the same operation with native Double type`() {
        assertEquals(primitiveDouble - primitiveByte, primitiveDouble - protectedByte, "primitiveDouble.minus(protectedByte)")
        assertEquals(primitiveDouble - primitiveShort, primitiveDouble - protectedShort, "primitiveDouble.minus(protectedShort)")
        assertEquals(primitiveDouble - primitiveInt, primitiveDouble - protectedInt, "primitiveDouble.minus(protectedInt)")
        assertEquals(primitiveDouble - primitiveLong, primitiveDouble - protectedLong, "primitiveDouble.minus(protectedLong)")
        assertEquals(primitiveDouble - primitiveFloat, primitiveDouble - protectedFloat, "primitiveDouble.minus(protectedFloat)")
        assertEquals(primitiveDouble - primitiveDouble, primitiveDouble - protectedDouble, "primitiveDouble.minus(protectedDouble)")
    }

    // Times operator
    @Test
    fun `test the times operator for ProtectedDouble times primitive value and compares the result with the same operation with native Double type`() {
        assertEquals(primitiveDouble * primitiveByte, (protectedDouble * primitiveByte).value, "protectedDouble.times(primitiveByte)")
        assertEquals(primitiveDouble * primitiveShort, (protectedDouble * primitiveShort).value, "protectedDouble.times(primitiveShort)")
        assertEquals(primitiveDouble * primitiveInt, (protectedDouble * primitiveInt).value, "protectedDouble.times(primitiveInt)")
        assertEquals(primitiveDouble * primitiveLong, (protectedDouble * primitiveLong).value, "protectedDouble.times(primitiveLong)")
        assertEquals(primitiveDouble * primitiveFloat, (protectedDouble * primitiveFloat).value, "protectedDouble.times(primitiveFloat)")
        assertEquals(primitiveDouble * primitiveDouble, (protectedDouble * primitiveDouble).value, "protectedDouble.times(primitiveDouble)")
    }

    @Test
    fun `test the times operator for ProtectedDouble times protected value and compares the result with the same operation with native Double type`() {
        assertEquals(primitiveDouble * primitiveByte, (protectedDouble * protectedByte).value, "protectedDouble.times(protectedByte)")
        assertEquals(primitiveDouble * primitiveShort, (protectedDouble * protectedShort).value, "protectedDouble.times(protectedShort)")
        assertEquals(primitiveDouble * primitiveInt, (protectedDouble * protectedInt).value, "protectedDouble.times(protectedInt)")
        assertEquals(primitiveDouble * primitiveLong, (protectedDouble * protectedLong).value, "protectedDouble.times(protectedLong)")
        assertEquals(primitiveDouble * primitiveFloat, (protectedDouble * protectedFloat).value, "protectedDouble.times(protectedFloat)")
        assertEquals(primitiveDouble * primitiveDouble, (protectedDouble * protectedDouble).value, "protectedDouble.times(protectedDouble)")
    }

    @Test
    fun `test the times operator for primitive value times protected value and compares the result with the same operation with native Double type`() {
        assertEquals(primitiveDouble * primitiveByte, primitiveDouble * protectedByte, "primitiveDouble.times(protectedByte)")
        assertEquals(primitiveDouble * primitiveShort, primitiveDouble * protectedShort, "primitiveDouble.times(protectedShort)")
        assertEquals(primitiveDouble * primitiveInt, primitiveDouble * protectedInt, "primitiveDouble.times(protectedInt)")
        assertEquals(primitiveDouble * primitiveLong, primitiveDouble * protectedLong, "primitiveDouble.times(protectedLong)")
        assertEquals(primitiveDouble * primitiveFloat, primitiveDouble * protectedFloat, "primitiveDouble.times(protectedFloat)")
        assertEquals(primitiveDouble * primitiveDouble, primitiveDouble * protectedDouble, "primitiveDouble.times(protectedDouble)")
    }

    // Div operator
    @Test
    fun `test the div operator for ProtectedDouble div primitive value and compares the result with the same operation with native Double type`() {
        assertEquals(primitiveDouble / primitiveByte, (protectedDouble / primitiveByte).value, "protectedDouble.div(primitiveByte)")
        assertEquals(primitiveDouble / primitiveShort, (protectedDouble / primitiveShort).value, "protectedDouble.div(primitiveShort)")
        assertEquals(primitiveDouble / primitiveInt, (protectedDouble / primitiveInt).value, "protectedDouble.div(primitiveInt)")
        assertEquals(primitiveDouble / primitiveLong, (protectedDouble / primitiveLong).value, "protectedDouble.div(primitiveLong)")
        assertEquals(primitiveDouble / primitiveFloat, (protectedDouble / primitiveFloat).value, "protectedDouble.div(primitiveFloat)")
        assertEquals(primitiveDouble / primitiveDouble, (protectedDouble / primitiveDouble).value, "protectedDouble.div(primitiveDouble)")
    }

    @Test
    fun `test the div operator for ProtectedDouble div protected value and compares the result with the same operation with native Double type`() {
        assertEquals(primitiveDouble / primitiveByte, (protectedDouble / protectedByte).value, "protectedDouble.div(protectedByte)")
        assertEquals(primitiveDouble / primitiveShort, (protectedDouble / protectedShort).value, "protectedDouble.div(protectedShort)")
        assertEquals(primitiveDouble / primitiveInt, (protectedDouble / protectedInt).value, "protectedDouble.div(protectedInt)")
        assertEquals(primitiveDouble / primitiveLong, (protectedDouble / protectedLong).value, "protectedDouble.div(protectedLong)")
        assertEquals(primitiveDouble / primitiveFloat, (protectedDouble / protectedFloat).value, "protectedDouble.div(protectedFloat)")
        assertEquals(primitiveDouble / primitiveDouble, (protectedDouble / protectedDouble).value, "protectedDouble.div(protectedDouble)")
    }

    @Test
    fun `test the div operator for primitive value div protected value and compares the result with the same operation with native Double type`() {
        assertEquals(primitiveDouble / primitiveByte, primitiveDouble / protectedByte, "primitiveDouble.div(protectedByte)")
        assertEquals(primitiveDouble / primitiveShort, primitiveDouble / protectedShort, "primitiveDouble.div(protectedShort)")
        assertEquals(primitiveDouble / primitiveInt, primitiveDouble / protectedInt, "primitiveDouble.div(protectedInt)")
        assertEquals(primitiveDouble / primitiveLong, primitiveDouble / protectedLong, "primitiveDouble.div(protectedLong)")
        assertEquals(primitiveDouble / primitiveFloat, primitiveDouble / protectedFloat, "primitiveDouble.div(protectedFloat)")
        assertEquals(primitiveDouble / primitiveDouble, primitiveDouble / protectedDouble, "primitiveDouble.div(protectedDouble)")
    }

    // Rem operator
    @Test
    fun `test the rem operator for ProtectedDouble rem primitive value and compares the result with the same operation with native Double type`() {
        assertEquals(primitiveDouble % primitiveByte, (protectedDouble % primitiveByte).value, "protectedDouble.rem(primitiveByte)")
        assertEquals(primitiveDouble % primitiveShort, (protectedDouble % primitiveShort).value, "protectedDouble.rem(primitiveShort)")
        assertEquals(primitiveDouble % primitiveInt, (protectedDouble % primitiveInt).value, "protectedDouble.rem(primitiveInt)")
        assertEquals(primitiveDouble % primitiveLong, (protectedDouble % primitiveLong).value, "protectedDouble.rem(primitiveLong)")
        assertEquals(primitiveDouble % primitiveFloat, (protectedDouble % primitiveFloat).value, "protectedDouble.rem(primitiveFloat)")
        assertEquals(primitiveDouble % primitiveDouble, (protectedDouble % primitiveDouble).value, "protectedDouble.rem(primitiveDouble)")
    }

    @Test
    fun `test the rem operator for ProtectedDouble rem protected value and compares the result with the same operation with native Double type`() {
        assertEquals(primitiveDouble % primitiveByte, (protectedDouble % protectedByte).value, "protectedDouble.rem(protectedByte)")
        assertEquals(primitiveDouble % primitiveShort, (protectedDouble % protectedShort).value, "protectedDouble.rem(protectedShort)")
        assertEquals(primitiveDouble % primitiveInt, (protectedDouble % protectedInt).value, "protectedDouble.rem(protectedInt)")
        assertEquals(primitiveDouble % primitiveLong, (protectedDouble % protectedLong).value, "protectedDouble.rem(protectedLong)")
        assertEquals(primitiveDouble % primitiveFloat, (protectedDouble % protectedFloat).value, "protectedDouble.rem(protectedFloat)")
        assertEquals(primitiveDouble % primitiveDouble, (protectedDouble % protectedDouble).value, "protectedDouble.rem(protectedDouble)")
    }

    @Test
    fun `test the rem operator for primitive value rem protected value and compares the result with the same operation with native Double type`() {
        assertEquals(primitiveDouble % primitiveByte, primitiveDouble % protectedByte, "primitiveDouble.rem(protectedByte)")
        assertEquals(primitiveDouble % primitiveShort, primitiveDouble % protectedShort, "primitiveDouble.rem(protectedShort)")
        assertEquals(primitiveDouble % primitiveInt, primitiveDouble % protectedInt, "primitiveDouble.rem(protectedInt)")
        assertEquals(primitiveDouble % primitiveLong, primitiveDouble % protectedLong, "primitiveDouble.rem(protectedLong)")
        assertEquals(primitiveDouble % primitiveFloat, primitiveDouble % protectedFloat, "primitiveDouble.rem(protectedFloat)")
        assertEquals(primitiveDouble % primitiveDouble, primitiveDouble % protectedDouble, "primitiveDouble.rem(protectedDouble)")
    }
}
