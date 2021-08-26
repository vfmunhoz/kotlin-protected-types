package io.github.vfmunhoz.protectedtypes.types

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertIs

internal class ProtectedLongTest {

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

    private val maxProtectedLong = ProtectedLong(Long.MAX_VALUE)
    private val minProtectedLong = ProtectedLong(Long.MIN_VALUE)

    @Test
    fun `validates the transformation to protected value`() {
        assertIs<ProtectedLong>(primitiveLong.toProtected())
    }

    // Unary operators
    @Test
    fun `test the unary plus operator compared to Long type`() {
        assertEquals(+primitiveLong, (+protectedLong).value)
        assertEquals(primitiveLong.unaryPlus(), protectedLong.unaryPlus().value)

        assertEquals(+Long.MAX_VALUE, (+maxProtectedLong).value)
        assertEquals(+Long.MIN_VALUE, (+minProtectedLong).value)

        assertEquals(Long.MAX_VALUE.unaryPlus(), (maxProtectedLong.unaryPlus()).value)
        assertEquals(Long.MIN_VALUE.unaryPlus(), (minProtectedLong.unaryPlus()).value)
    }

    @Test
    fun `test the unary minus operator compared to Long type`() {
        assertEquals(-primitiveLong, (-protectedLong).value)
        assertEquals(primitiveLong.unaryMinus(), protectedLong.unaryMinus().value)

        assertEquals(-Long.MAX_VALUE, (-maxProtectedLong).value)
        assertEquals(-Long.MIN_VALUE, (-minProtectedLong).value)

        assertEquals(Long.MAX_VALUE.unaryMinus(), (maxProtectedLong.unaryMinus()).value)
        assertEquals(Long.MIN_VALUE.unaryMinus(), (minProtectedLong.unaryMinus()).value)
    }

    // Increment and decrement operators
    @Test
    fun `test the increment operator compared to Long type`() {
        var mutablePrimitive = primitiveLong
        var mutableProtected = protectedLong

        ++mutablePrimitive
        ++mutableProtected

        assertEquals(mutablePrimitive, mutableProtected.value)

        mutablePrimitive++
        mutableProtected++

        assertEquals(mutablePrimitive, mutableProtected.value)

        assertEquals(mutablePrimitive.inc(), mutableProtected.inc().value)

        var mutableMaxPrimitive = Long.MAX_VALUE
        var mutableMaxProtected = maxProtectedLong

        assertEquals(++mutableMaxPrimitive, (++mutableMaxProtected).value)
    }

    @Test
    fun `test the decrement operator compared to Long type`() {
        var mutablePrimitive = primitiveLong
        var mutableProtected = protectedLong

        --mutablePrimitive
        --mutableProtected

        assertEquals(mutablePrimitive, mutableProtected.value)

        mutablePrimitive--
        mutableProtected--

        assertEquals(mutablePrimitive, mutableProtected.value)

        assertEquals(mutablePrimitive.dec(), mutableProtected.dec().value)

        var mutableMaxPrimitiveDouble = Long.MIN_VALUE
        var mutableMaxProtectedDouble = minProtectedLong

        assertEquals(--mutableMaxPrimitiveDouble, (--mutableMaxProtectedDouble).value)
    }

    // Plus operator
    @Test
    fun `test the sum operator for ProtectedLong + primitive value and compares the result with the same operation with native Long type`() {
        assertEquals(primitiveLong + primitiveByte, (protectedLong + primitiveByte).value, "protectedLong.sum(primitiveByte)")
        assertEquals(primitiveLong + primitiveShort, (protectedLong + primitiveShort).value, "protectedLong.sum(primitiveShort)")
        assertEquals(primitiveLong + primitiveInt, (protectedLong + primitiveInt).value, "protectedLong.sum(primitiveInt)")
        assertEquals(primitiveLong + primitiveLong, (protectedLong + primitiveLong).value, "protectedLong.sum(primitiveLong)")
        assertEquals(primitiveLong + primitiveFloat, (protectedLong + primitiveFloat).value, "protectedLong.sum(primitiveFloat)")
        assertEquals(primitiveLong + primitiveDouble, (protectedLong + primitiveDouble).value, "protectedLong.sum(primitiveDouble)")
    }

    @Test
    fun `test the sum operator for ProtectedLong + protected value and compares the result with the same operation with native Long type`() {
        assertEquals(primitiveLong + primitiveByte, (protectedLong + protectedByte).value, "protectedLong.sum(protectedByte)")
        assertEquals(primitiveLong + primitiveShort, (protectedLong + protectedShort).value, "protectedLong.sum(protectedShort)")
        assertEquals(primitiveLong + primitiveInt, (protectedLong + protectedInt).value, "protectedLong.sum(protectedInt)")
        assertEquals(primitiveLong + primitiveLong, (protectedLong + protectedLong).value, "protectedLong.sum(protectedLong)")
        assertEquals(primitiveLong + primitiveFloat, (protectedLong + protectedFloat).value, "protectedLong.sum(protectedFloat)")
        assertEquals(primitiveLong + primitiveDouble, (protectedLong + protectedDouble).value, "protectedLong.sum(protectedDouble)")
    }

    @Test
    fun `test the sum operator for primitive value + protected value and compares the result with the same operation with native Long type`() {
        assertEquals(primitiveLong + primitiveByte, primitiveLong + protectedByte, "primitiveLong.sum(protectedByte)")
        assertEquals(primitiveLong + primitiveShort, primitiveLong + protectedShort, "primitiveLong.sum(protectedShort)")
        assertEquals(primitiveLong + primitiveInt, primitiveLong + protectedInt, "primitiveLong.sum(protectedInt)")
        assertEquals(primitiveLong + primitiveLong, primitiveLong + protectedLong, "primitiveLong.sum(protectedLong)")
        assertEquals(primitiveLong + primitiveFloat, primitiveLong + protectedFloat, "primitiveLong.sum(protectedFloat)")
        assertEquals(primitiveLong + primitiveDouble, primitiveLong + protectedDouble, "primitiveLong.sum(protectedDouble)")
    }

    // Minus operator
    @Test
    fun `test the minus operator for ProtectedLong - primitive value and compares the result with the same operation with native Long type`() {
        assertEquals(primitiveLong - primitiveByte, (protectedLong - primitiveByte).value, "protectedLong.minus(primitiveByte)")
        assertEquals(primitiveLong - primitiveShort, (protectedLong - primitiveShort).value, "protectedLong.minus(primitiveShort)")
        assertEquals(primitiveLong - primitiveInt, (protectedLong - primitiveInt).value, "protectedLong.minus(primitiveInt)")
        assertEquals(primitiveLong - primitiveLong, (protectedLong - primitiveLong).value, "protectedLong.minus(primitiveLong)")
        assertEquals(primitiveLong - primitiveFloat, (protectedLong - primitiveFloat).value, "protectedLong.minus(primitiveFloat)")
        assertEquals(primitiveLong - primitiveDouble, (protectedLong - primitiveDouble).value, "protectedLong.minus(primitiveDouble)")
    }

    @Test
    fun `test the minus operator for ProtectedLong - protected value and compares the result with the same operation with native Long type`() {
        assertEquals(primitiveLong - primitiveByte, (protectedLong - protectedByte).value, "protectedLong.minus(protectedByte)")
        assertEquals(primitiveLong - primitiveShort, (protectedLong - protectedShort).value, "protectedLong.minus(protectedShort)")
        assertEquals(primitiveLong - primitiveInt, (protectedLong - protectedInt).value, "protectedLong.minus(protectedInt)")
        assertEquals(primitiveLong - primitiveLong, (protectedLong - protectedLong).value, "protectedLong.minus(protectedLong)")
        assertEquals(primitiveLong - primitiveFloat, (protectedLong - protectedFloat).value, "protectedLong.minus(protectedFloat)")
        assertEquals(primitiveLong - primitiveDouble, (protectedLong - protectedDouble).value, "protectedLong.minus(protectedDouble)")
    }

    @Test
    fun `test the minus operator for primitive value - protected value and compares the result with the same operation with native Long type`() {
        assertEquals(primitiveLong - primitiveByte, primitiveLong - protectedByte, "primitiveLong.minus(protectedByte)")
        assertEquals(primitiveLong - primitiveShort, primitiveLong - protectedShort, "primitiveLong.minus(protectedShort)")
        assertEquals(primitiveLong - primitiveInt, primitiveLong - protectedInt, "primitiveLong.minus(protectedInt)")
        assertEquals(primitiveLong - primitiveLong, primitiveLong - protectedLong, "primitiveLong.minus(protectedLong)")
        assertEquals(primitiveLong - primitiveFloat, primitiveLong - protectedFloat, "primitiveLong.minus(protectedFloat)")
        assertEquals(primitiveLong - primitiveDouble, primitiveLong - protectedDouble, "primitiveLong.minus(protectedDouble)")
    }

    // Times operator
    @Test
    fun `test the times operator for ProtectedLong times primitive value and compares the result with the same operation with native Long type`() {
        assertEquals(primitiveLong * primitiveByte, (protectedLong * primitiveByte).value, "protectedLong.times(primitiveByte)")
        assertEquals(primitiveLong * primitiveShort, (protectedLong * primitiveShort).value, "protectedLong.times(primitiveShort)")
        assertEquals(primitiveLong * primitiveInt, (protectedLong * primitiveInt).value, "protectedLong.times(primitiveInt)")
        assertEquals(primitiveLong * primitiveLong, (protectedLong * primitiveLong).value, "protectedLong.times(primitiveLong)")
        assertEquals(primitiveLong * primitiveFloat, (protectedLong * primitiveFloat).value, "protectedLong.times(primitiveFloat)")
        assertEquals(primitiveLong * primitiveDouble, (protectedLong * primitiveDouble).value, "protectedLong.times(primitiveDouble)")
    }

    @Test
    fun `test the times operator for ProtectedLong times protected value and compares the result with the same operation with native Long type`() {
        assertEquals(primitiveLong * primitiveByte, (protectedLong * protectedByte).value, "protectedLong.times(protectedByte)")
        assertEquals(primitiveLong * primitiveShort, (protectedLong * protectedShort).value, "protectedLong.times(protectedShort)")
        assertEquals(primitiveLong * primitiveInt, (protectedLong * protectedInt).value, "protectedLong.times(protectedInt)")
        assertEquals(primitiveLong * primitiveLong, (protectedLong * protectedLong).value, "protectedLong.times(protectedLong)")
        assertEquals(primitiveLong * primitiveFloat, (protectedLong * protectedFloat).value, "protectedLong.times(protectedFloat)")
        assertEquals(primitiveLong * primitiveDouble, (protectedLong * protectedDouble).value, "protectedLong.times(protectedDouble)")
    }

    @Test
    fun `test the times operator for primitive value times protected value and compares the result with the same operation with native Long type`() {
        assertEquals(primitiveLong * primitiveByte, primitiveLong * protectedByte, "primitiveLong.times(protectedByte)")
        assertEquals(primitiveLong * primitiveShort, primitiveLong * protectedShort, "primitiveLong.times(protectedShort)")
        assertEquals(primitiveLong * primitiveInt, primitiveLong * protectedInt, "primitiveLong.times(protectedInt)")
        assertEquals(primitiveLong * primitiveLong, primitiveLong * protectedLong, "primitiveLong.times(protectedLong)")
        assertEquals(primitiveLong * primitiveFloat, primitiveLong * protectedFloat, "primitiveLong.times(protectedFloat)")
        assertEquals(primitiveLong * primitiveDouble, primitiveLong * protectedDouble, "primitiveLong.times(protectedDouble)")
    }

    // Div operator
    @Test
    fun `test the div operator for ProtectedLong div primitive value and compares the result with the same operation with native Long type`() {
        assertEquals(primitiveLong / primitiveByte, (protectedLong / primitiveByte).value, "protectedLong.div(primitiveByte)")
        assertEquals(primitiveLong / primitiveShort, (protectedLong / primitiveShort).value, "protectedLong.div(primitiveShort)")
        assertEquals(primitiveLong / primitiveInt, (protectedLong / primitiveInt).value, "protectedLong.div(primitiveInt)")
        assertEquals(primitiveLong / primitiveLong, (protectedLong / primitiveLong).value, "protectedLong.div(primitiveLong)")
        assertEquals(primitiveLong / primitiveFloat, (protectedLong / primitiveFloat).value, "protectedLong.div(primitiveFloat)")
        assertEquals(primitiveLong / primitiveDouble, (protectedLong / primitiveDouble).value, "protectedLong.div(primitiveDouble)")
    }

    @Test
    fun `test the div operator for ProtectedLong div protected value and compares the result with the same operation with native Long type`() {
        assertEquals(primitiveLong / primitiveByte, (protectedLong / protectedByte).value, "protectedLong.div(protectedByte)")
        assertEquals(primitiveLong / primitiveShort, (protectedLong / protectedShort).value, "protectedLong.div(protectedShort)")
        assertEquals(primitiveLong / primitiveInt, (protectedLong / protectedInt).value, "protectedLong.div(protectedInt)")
        assertEquals(primitiveLong / primitiveLong, (protectedLong / protectedLong).value, "protectedLong.div(protectedLong)")
        assertEquals(primitiveLong / primitiveFloat, (protectedLong / protectedFloat).value, "protectedLong.div(protectedFloat)")
        assertEquals(primitiveLong / primitiveDouble, (protectedLong / protectedDouble).value, "protectedLong.div(protectedDouble)")
    }

    @Test
    fun `test the div operator for primitive value div protected value and compares the result with the same operation with native Long type`() {
        assertEquals(primitiveLong / primitiveByte, primitiveLong / protectedByte, "primitiveLong.div(protectedByte)")
        assertEquals(primitiveLong / primitiveShort, primitiveLong / protectedShort, "primitiveLong.div(protectedShort)")
        assertEquals(primitiveLong / primitiveInt, primitiveLong / protectedInt, "primitiveLong.div(protectedInt)")
        assertEquals(primitiveLong / primitiveLong, primitiveLong / protectedLong, "primitiveLong.div(protectedLong)")
        assertEquals(primitiveLong / primitiveFloat, primitiveLong / protectedFloat, "primitiveLong.div(protectedFloat)")
        assertEquals(primitiveLong / primitiveDouble, primitiveLong / protectedDouble, "primitiveLong.div(protectedDouble)")
    }

    // Rem operator
    @Test
    fun `test the rem operator for ProtectedLong rem primitive value and compares the result with the same operation with native Long type`() {
        assertEquals(primitiveLong % primitiveByte, (protectedLong % primitiveByte).value, "protectedLong.rem(primitiveByte)")
        assertEquals(primitiveLong % primitiveShort, (protectedLong % primitiveShort).value, "protectedLong.rem(primitiveShort)")
        assertEquals(primitiveLong % primitiveInt, (protectedLong % primitiveInt).value, "protectedLong.rem(primitiveInt)")
        assertEquals(primitiveLong % primitiveLong, (protectedLong % primitiveLong).value, "protectedLong.rem(primitiveLong)")
        assertEquals(primitiveLong % primitiveFloat, (protectedLong % primitiveFloat).value, "protectedLong.rem(primitiveFloat)")
        assertEquals(primitiveLong % primitiveDouble, (protectedLong % primitiveDouble).value, "protectedLong.rem(primitiveDouble)")
    }

    @Test
    fun `test the rem operator for ProtectedLong rem protected value and compares the result with the same operation with native Long type`() {
        assertEquals(primitiveLong % primitiveByte, (protectedLong % protectedByte).value, "protectedLong.rem(protectedByte)")
        assertEquals(primitiveLong % primitiveShort, (protectedLong % protectedShort).value, "protectedLong.rem(protectedShort)")
        assertEquals(primitiveLong % primitiveInt, (protectedLong % protectedInt).value, "protectedLong.rem(protectedInt)")
        assertEquals(primitiveLong % primitiveLong, (protectedLong % protectedLong).value, "protectedLong.rem(protectedLong)")
        assertEquals(primitiveLong % primitiveFloat, (protectedLong % protectedFloat).value, "protectedLong.rem(protectedFloat)")
        assertEquals(primitiveLong % primitiveDouble, (protectedLong % protectedDouble).value, "protectedLong.rem(protectedDouble)")
    }

    @Test
    fun `test the rem operator for primitive value rem protected value and compares the result with the same operation with native Long type`() {
        assertEquals(primitiveLong % primitiveByte, primitiveLong % protectedByte, "primitiveLong.rem(protectedByte)")
        assertEquals(primitiveLong % primitiveShort, primitiveLong % protectedShort, "primitiveLong.rem(protectedShort)")
        assertEquals(primitiveLong % primitiveInt, primitiveLong % protectedInt, "primitiveLong.rem(protectedInt)")
        assertEquals(primitiveLong % primitiveLong, primitiveLong % protectedLong, "primitiveLong.rem(protectedLong)")
        assertEquals(primitiveLong % primitiveFloat, primitiveLong % protectedFloat, "primitiveLong.rem(protectedFloat)")
        assertEquals(primitiveLong % primitiveDouble, primitiveLong % protectedDouble, "primitiveLong.rem(protectedDouble)")
    }
}
