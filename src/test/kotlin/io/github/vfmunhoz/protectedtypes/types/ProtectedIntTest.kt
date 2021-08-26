package io.github.vfmunhoz.protectedtypes.types

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertIs

internal class ProtectedIntTest {

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

    private val maxProtected = ProtectedInt(Int.MAX_VALUE)
    private val minProtected = ProtectedInt(Int.MIN_VALUE)

    @Test
    fun `validates the transformation to protected value`() {
        assertIs<ProtectedInt>(primitiveInt.toProtected())
    }

    // Unary operators
    @Test
    fun `test the unary plus operator compared to Int type`() {
        assertEquals(+primitiveInt, (+protectedInt).value)
        assertEquals(primitiveInt.unaryPlus(), protectedInt.unaryPlus().value)

        assertEquals(+Int.MAX_VALUE, (+maxProtected).value)
        assertEquals(+Int.MIN_VALUE, (+minProtected).value)

        assertEquals(Int.MAX_VALUE.unaryPlus(), (maxProtected.unaryPlus()).value)
        assertEquals(Int.MIN_VALUE.unaryPlus(), (minProtected.unaryPlus()).value)
    }

    @Test
    fun `test the unary minus operator compared to Int type`() {
        assertEquals(-primitiveInt, (-protectedInt).value)
        assertEquals(primitiveInt.unaryMinus(), protectedInt.unaryMinus().value)

        assertEquals(-Int.MAX_VALUE, (-maxProtected).value)
        assertEquals(-Int.MIN_VALUE, (-minProtected).value)

        assertEquals(Int.MAX_VALUE.unaryMinus(), (maxProtected.unaryMinus()).value)
        assertEquals(Int.MIN_VALUE.unaryMinus(), (minProtected.unaryMinus()).value)
    }

    // Increment and decrement operators
    @Test
    fun `test the increment operator compared to Int type`() {
        var mutablePrimitive = primitiveInt
        var mutableProtected = protectedInt

        ++mutablePrimitive
        ++mutableProtected

        assertEquals(mutablePrimitive, mutableProtected.value)

        mutablePrimitive++
        mutableProtected++

        assertEquals(mutablePrimitive, mutableProtected.value)

        assertEquals(mutablePrimitive.inc(), mutableProtected.inc().value)

        var mutableMaxPrimitive = Int.MAX_VALUE
        var mutableMaxProtected = maxProtected

        assertEquals(++mutableMaxPrimitive, (++mutableMaxProtected).value)
    }

    @Test
    fun `test the decrement operator compared to Int type`() {
        var mutablePrimitive = primitiveInt
        var mutableProtected = protectedInt

        --mutablePrimitive
        --mutableProtected

        assertEquals(mutablePrimitive, mutableProtected.value)

        mutablePrimitive--
        mutableProtected--

        assertEquals(mutablePrimitive, mutableProtected.value)

        assertEquals(mutablePrimitive.dec(), mutableProtected.dec().value)

        var mutableMaxPrimitiveDouble = Int.MIN_VALUE
        var mutableMaxProtectedDouble = minProtected

        assertEquals(--mutableMaxPrimitiveDouble, (--mutableMaxProtectedDouble).value)
    }

    // Plus operator
    @Test
    fun `test the sum operator for ProtectedInt + primitive value and compares the result with the same operation with native Int type`() {
        assertEquals(primitiveInt + primitiveByte, (protectedInt + primitiveByte).value, "protectedInt.sum(primitiveByte)")
        assertEquals(primitiveInt + primitiveShort, (protectedInt + primitiveShort).value, "protectedInt.sum(primitiveShort)")
        assertEquals(primitiveInt + primitiveInt, (protectedInt + primitiveInt).value, "protectedInt.sum(primitiveInt)")
        assertEquals(primitiveInt + primitiveLong, (protectedInt + primitiveLong).value, "protectedInt.sum(primitiveLong)")
        assertEquals(primitiveInt + primitiveFloat, (protectedInt + primitiveFloat).value, "protectedInt.sum(primitiveFloat)")
        assertEquals(primitiveInt + primitiveDouble, (protectedInt + primitiveDouble).value, "protectedInt.sum(primitiveDouble)")
    }

    @Test
    fun `test the sum operator for ProtectedInt + protected value and compares the result with the same operation with native Int type`() {
        assertEquals(primitiveInt + primitiveByte, (protectedInt + protectedByte).value, "protectedInt.sum(protectedByte)")
        assertEquals(primitiveInt + primitiveShort, (protectedInt + protectedShort).value, "protectedInt.sum(protectedShort)")
        assertEquals(primitiveInt + primitiveInt, (protectedInt + protectedInt).value, "protectedInt.sum(protectedInt)")
        assertEquals(primitiveInt + primitiveLong, (protectedInt + protectedLong).value, "protectedInt.sum(protectedLong)")
        assertEquals(primitiveInt + primitiveFloat, (protectedInt + protectedFloat).value, "protectedInt.sum(protectedFloat)")
        assertEquals(primitiveInt + primitiveDouble, (protectedInt + protectedDouble).value, "protectedInt.sum(protectedDouble)")
    }

    @Test
    fun `test the sum operator for primitive value + protected value and compares the result with the same operation with native Int type`() {
        assertEquals(primitiveInt + primitiveByte, primitiveInt + protectedByte, "primitiveInt.sum(protectedByte)")
        assertEquals(primitiveInt + primitiveShort, primitiveInt + protectedShort, "primitiveInt.sum(protectedShort)")
        assertEquals(primitiveInt + primitiveInt, primitiveInt + protectedInt, "primitiveInt.sum(protectedInt)")
        assertEquals(primitiveInt + primitiveLong, primitiveInt + protectedLong, "primitiveInt.sum(protectedLong)")
        assertEquals(primitiveInt + primitiveFloat, primitiveInt + protectedFloat, "primitiveInt.sum(protectedFloat)")
        assertEquals(primitiveInt + primitiveDouble, primitiveInt + protectedDouble, "primitiveInt.sum(protectedDouble)")
    }

    // Minus operator
    @Test
    fun `test the minus operator for ProtectedInt - primitive value and compares the result with the same operation with native Int type`() {
        assertEquals(primitiveInt - primitiveByte, (protectedInt - primitiveByte).value, "protectedInt.minus(primitiveByte)")
        assertEquals(primitiveInt - primitiveShort, (protectedInt - primitiveShort).value, "protectedInt.minus(primitiveShort)")
        assertEquals(primitiveInt - primitiveInt, (protectedInt - primitiveInt).value, "protectedInt.minus(primitiveInt)")
        assertEquals(primitiveInt - primitiveLong, (protectedInt - primitiveLong).value, "protectedInt.minus(primitiveLong)")
        assertEquals(primitiveInt - primitiveFloat, (protectedInt - primitiveFloat).value, "protectedInt.minus(primitiveFloat)")
        assertEquals(primitiveInt - primitiveDouble, (protectedInt - primitiveDouble).value, "protectedInt.minus(primitiveDouble)")
    }

    @Test
    fun `test the minus operator for ProtectedInt - protected value and compares the result with the same operation with native Int type`() {
        assertEquals(primitiveInt - primitiveByte, (protectedInt - protectedByte).value, "protectedInt.minus(protectedByte)")
        assertEquals(primitiveInt - primitiveShort, (protectedInt - protectedShort).value, "protectedInt.minus(protectedShort)")
        assertEquals(primitiveInt - primitiveInt, (protectedInt - protectedInt).value, "protectedInt.minus(protectedInt)")
        assertEquals(primitiveInt - primitiveLong, (protectedInt - protectedLong).value, "protectedInt.minus(protectedLong)")
        assertEquals(primitiveInt - primitiveFloat, (protectedInt - protectedFloat).value, "protectedInt.minus(protectedFloat)")
        assertEquals(primitiveInt - primitiveDouble, (protectedInt - protectedDouble).value, "protectedInt.minus(protectedDouble)")
    }

    @Test
    fun `test the minus operator for primitive value - protected value and compares the result with the same operation with native Int type`() {
        assertEquals(primitiveInt - primitiveByte, primitiveInt - protectedByte, "primitiveInt.minus(protectedByte)")
        assertEquals(primitiveInt - primitiveShort, primitiveInt - protectedShort, "primitiveInt.minus(protectedShort)")
        assertEquals(primitiveInt - primitiveInt, primitiveInt - protectedInt, "primitiveInt.minus(protectedInt)")
        assertEquals(primitiveInt - primitiveLong, primitiveInt - protectedLong, "primitiveInt.minus(protectedLong)")
        assertEquals(primitiveInt - primitiveFloat, primitiveInt - protectedFloat, "primitiveInt.minus(protectedFloat)")
        assertEquals(primitiveInt - primitiveDouble, primitiveInt - protectedDouble, "primitiveInt.minus(protectedDouble)")
    }

    // Times operator
    @Test
    fun `test the times operator for ProtectedInt times primitive value and compares the result with the same operation with native Int type`() {
        assertEquals(primitiveInt * primitiveByte, (protectedInt * primitiveByte).value, "protectedInt.times(primitiveByte)")
        assertEquals(primitiveInt * primitiveShort, (protectedInt * primitiveShort).value, "protectedInt.times(primitiveShort)")
        assertEquals(primitiveInt * primitiveInt, (protectedInt * primitiveInt).value, "protectedInt.times(primitiveInt)")
        assertEquals(primitiveInt * primitiveLong, (protectedInt * primitiveLong).value, "protectedInt.times(primitiveLong)")
        assertEquals(primitiveInt * primitiveFloat, (protectedInt * primitiveFloat).value, "protectedInt.times(primitiveFloat)")
        assertEquals(primitiveInt * primitiveDouble, (protectedInt * primitiveDouble).value, "protectedInt.times(primitiveDouble)")
    }

    @Test
    fun `test the times operator for ProtectedInt times protected value and compares the result with the same operation with native Int type`() {
        assertEquals(primitiveInt * primitiveByte, (protectedInt * protectedByte).value, "protectedInt.times(protectedByte)")
        assertEquals(primitiveInt * primitiveShort, (protectedInt * protectedShort).value, "protectedInt.times(protectedShort)")
        assertEquals(primitiveInt * primitiveInt, (protectedInt * protectedInt).value, "protectedInt.times(protectedInt)")
        assertEquals(primitiveInt * primitiveLong, (protectedInt * protectedLong).value, "protectedInt.times(protectedLong)")
        assertEquals(primitiveInt * primitiveFloat, (protectedInt * protectedFloat).value, "protectedInt.times(protectedFloat)")
        assertEquals(primitiveInt * primitiveDouble, (protectedInt * protectedDouble).value, "protectedInt.times(protectedDouble)")
    }

    @Test
    fun `test the times operator for primitive value times protected value and compares the result with the same operation with native Int type`() {
        assertEquals(primitiveInt * primitiveByte, primitiveInt * protectedByte, "primitiveInt.times(protectedByte)")
        assertEquals(primitiveInt * primitiveShort, primitiveInt * protectedShort, "primitiveInt.times(protectedShort)")
        assertEquals(primitiveInt * primitiveInt, primitiveInt * protectedInt, "primitiveInt.times(protectedInt)")
        assertEquals(primitiveInt * primitiveLong, primitiveInt * protectedLong, "primitiveInt.times(protectedLong)")
        assertEquals(primitiveInt * primitiveFloat, primitiveInt * protectedFloat, "primitiveInt.times(protectedFloat)")
        assertEquals(primitiveInt * primitiveDouble, primitiveInt * protectedDouble, "primitiveInt.times(protectedDouble)")
    }

    // Div operator
    @Test
    fun `test the div operator for ProtectedInt div primitive value and compares the result with the same operation with native Int type`() {
        assertEquals(primitiveInt / primitiveByte, (protectedInt / primitiveByte).value, "protectedInt.div(primitiveByte)")
        assertEquals(primitiveInt / primitiveShort, (protectedInt / primitiveShort).value, "protectedInt.div(primitiveShort)")
        assertEquals(primitiveInt / primitiveInt, (protectedInt / primitiveInt).value, "protectedInt.div(primitiveInt)")
        assertEquals(primitiveInt / primitiveLong, (protectedInt / primitiveLong).value, "protectedInt.div(primitiveLong)")
        assertEquals(primitiveInt / primitiveFloat, (protectedInt / primitiveFloat).value, "protectedInt.div(primitiveFloat)")
        assertEquals(primitiveInt / primitiveDouble, (protectedInt / primitiveDouble).value, "protectedInt.div(primitiveDouble)")
    }

    @Test
    fun `test the div operator for ProtectedInt div protected value and compares the result with the same operation with native Int type`() {
        assertEquals(primitiveInt / primitiveByte, (protectedInt / protectedByte).value, "protectedInt.div(protectedByte)")
        assertEquals(primitiveInt / primitiveShort, (protectedInt / protectedShort).value, "protectedInt.div(protectedShort)")
        assertEquals(primitiveInt / primitiveInt, (protectedInt / protectedInt).value, "protectedInt.div(protectedInt)")
        assertEquals(primitiveInt / primitiveLong, (protectedInt / protectedLong).value, "protectedInt.div(protectedLong)")
        assertEquals(primitiveInt / primitiveFloat, (protectedInt / protectedFloat).value, "protectedInt.div(protectedFloat)")
        assertEquals(primitiveInt / primitiveDouble, (protectedInt / protectedDouble).value, "protectedInt.div(protectedDouble)")
    }

    @Test
    fun `test the div operator for primitive value div protected value and compares the result with the same operation with native Int type`() {
        assertEquals(primitiveInt / primitiveByte, primitiveInt / protectedByte, "primitiveInt.div(protectedByte)")
        assertEquals(primitiveInt / primitiveShort, primitiveInt / protectedShort, "primitiveInt.div(protectedShort)")
        assertEquals(primitiveInt / primitiveInt, primitiveInt / protectedInt, "primitiveInt.div(protectedInt)")
        assertEquals(primitiveInt / primitiveLong, primitiveInt / protectedLong, "primitiveInt.div(protectedLong)")
        assertEquals(primitiveInt / primitiveFloat, primitiveInt / protectedFloat, "primitiveInt.div(protectedFloat)")
        assertEquals(primitiveInt / primitiveDouble, primitiveInt / protectedDouble, "primitiveInt.div(protectedDouble)")
    }

    // Rem operator
    @Test
    fun `test the rem operator for ProtectedInt rem primitive value and compares the result with the same operation with native Int type`() {
        assertEquals(primitiveInt % primitiveByte, (protectedInt % primitiveByte).value, "protectedInt.rem(primitiveByte)")
        assertEquals(primitiveInt % primitiveShort, (protectedInt % primitiveShort).value, "protectedInt.rem(primitiveShort)")
        assertEquals(primitiveInt % primitiveInt, (protectedInt % primitiveInt).value, "protectedInt.rem(primitiveInt)")
        assertEquals(primitiveInt % primitiveLong, (protectedInt % primitiveLong).value, "protectedInt.rem(primitiveLong)")
        assertEquals(primitiveInt % primitiveFloat, (protectedInt % primitiveFloat).value, "protectedInt.rem(primitiveFloat)")
        assertEquals(primitiveInt % primitiveDouble, (protectedInt % primitiveDouble).value, "protectedInt.rem(primitiveDouble)")
    }

    @Test
    fun `test the rem operator for ProtectedInt rem protected value and compares the result with the same operation with native Int type`() {
        assertEquals(primitiveInt % primitiveByte, (protectedInt % protectedByte).value, "protectedInt.rem(protectedByte)")
        assertEquals(primitiveInt % primitiveShort, (protectedInt % protectedShort).value, "protectedInt.rem(protectedShort)")
        assertEquals(primitiveInt % primitiveInt, (protectedInt % protectedInt).value, "protectedInt.rem(protectedInt)")
        assertEquals(primitiveInt % primitiveLong, (protectedInt % protectedLong).value, "protectedInt.rem(protectedLong)")
        assertEquals(primitiveInt % primitiveFloat, (protectedInt % protectedFloat).value, "protectedInt.rem(protectedFloat)")
        assertEquals(primitiveInt % primitiveDouble, (protectedInt % protectedDouble).value, "protectedInt.rem(protectedDouble)")
    }

    @Test
    fun `test the rem operator for primitive value rem protected value and compares the result with the same operation with native Int type`() {
        assertEquals(primitiveInt % primitiveByte, primitiveInt % protectedByte, "primitiveInt.rem(protectedByte)")
        assertEquals(primitiveInt % primitiveShort, primitiveInt % protectedShort, "primitiveInt.rem(protectedShort)")
        assertEquals(primitiveInt % primitiveInt, primitiveInt % protectedInt, "primitiveInt.rem(protectedInt)")
        assertEquals(primitiveInt % primitiveLong, primitiveInt % protectedLong, "primitiveInt.rem(protectedLong)")
        assertEquals(primitiveInt % primitiveFloat, primitiveInt % protectedFloat, "primitiveInt.rem(protectedFloat)")
        assertEquals(primitiveInt % primitiveDouble, primitiveInt % protectedDouble, "primitiveInt.rem(protectedDouble)")
    }
}
