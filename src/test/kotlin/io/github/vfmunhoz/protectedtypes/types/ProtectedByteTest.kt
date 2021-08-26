package io.github.vfmunhoz.protectedtypes.types

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertIs

internal class ProtectedByteTest {

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

    private val maxProtected = ProtectedByte(Byte.MAX_VALUE)
    private val minProtected = ProtectedByte(Byte.MIN_VALUE)

    @Test
    fun `validates the transformation to protected value`() {
        assertIs<ProtectedByte>(primitiveByte.toProtected())
    }

    // Unary operators
    @Test
    fun `test the unary plus operator compared to Byte type`() {
        assertEquals(+primitiveByte, (+protectedByte).value)
        assertEquals(primitiveByte.unaryPlus(), protectedByte.unaryPlus().value)

        assertEquals(+Byte.MAX_VALUE, (+maxProtected).value)
        assertEquals(+Byte.MIN_VALUE, (+minProtected).value)

        assertEquals(Byte.MAX_VALUE.unaryPlus(), (maxProtected.unaryPlus()).value)
        assertEquals(Byte.MIN_VALUE.unaryPlus(), (minProtected.unaryPlus()).value)
    }

    @Test
    fun `test the unary minus operator compared to Byte type`() {
        assertEquals(-primitiveByte, (-protectedByte).value)
        assertEquals(primitiveByte.unaryMinus(), protectedByte.unaryMinus().value)

        assertEquals(-Byte.MAX_VALUE, (-maxProtected).value)
        assertEquals(-Byte.MIN_VALUE, (-minProtected).value)

        assertEquals(Byte.MAX_VALUE.unaryMinus(), (maxProtected.unaryMinus()).value)
        assertEquals(Byte.MIN_VALUE.unaryMinus(), (minProtected.unaryMinus()).value)
    }

    // Increment and decrement operators
    @Test
    fun `test the increment operator compared to Byte type`() {
        var mutablePrimitive = primitiveByte
        var mutableProtected = protectedByte

        ++mutablePrimitive
        ++mutableProtected

        assertEquals(mutablePrimitive, mutableProtected.value)

        mutablePrimitive++
        mutableProtected++

        assertEquals(mutablePrimitive, mutableProtected.value)

        assertEquals(mutablePrimitive.inc(), mutableProtected.inc().value)

        var mutableMaxPrimitive = Byte.MAX_VALUE
        var mutableMaxProtected = maxProtected

        assertEquals(++mutableMaxPrimitive, (++mutableMaxProtected).value)
    }

    @Test
    fun `test the decrement operator compared to Byte type`() {
        var mutablePrimitive = primitiveByte
        var mutableProtected = protectedByte

        --mutablePrimitive
        --mutableProtected

        assertEquals(mutablePrimitive, mutableProtected.value)

        mutablePrimitive--
        mutableProtected--

        assertEquals(mutablePrimitive, mutableProtected.value)

        assertEquals(mutablePrimitive.dec(), mutableProtected.dec().value)

        var mutableMaxPrimitiveDouble = Byte.MIN_VALUE
        var mutableMaxProtectedDouble = minProtected

        assertEquals(--mutableMaxPrimitiveDouble, (--mutableMaxProtectedDouble).value)
    }

    // Plus operator
    @Test
    fun `test the sum operator for ProtectedByte + primitive value and compares the result with the same operation with native Byte type`() {
        assertEquals(primitiveByte + primitiveByte, (protectedByte + primitiveByte).value, "protectedByte.sum(primitiveByte)")
        assertEquals(primitiveByte + primitiveShort, (protectedByte + primitiveShort).value, "protectedByte.sum(primitiveShort)")
        assertEquals(primitiveByte + primitiveInt, (protectedByte + primitiveInt).value, "protectedByte.sum(primitiveInt)")
        assertEquals(primitiveByte + primitiveLong, (protectedByte + primitiveLong).value, "protectedByte.sum(primitiveLong)")
        assertEquals(primitiveByte + primitiveFloat, (protectedByte + primitiveFloat).value, "protectedByte.sum(primitiveFloat)")
        assertEquals(primitiveByte + primitiveDouble, (protectedByte + primitiveDouble).value, "protectedByte.sum(primitiveDouble)")
    }

    @Test
    fun `test the sum operator for ProtectedByte + protected value and compares the result with the same operation with native Byte type`() {
        assertEquals(primitiveByte + primitiveByte, (protectedByte + protectedByte).value, "protectedByte.sum(protectedByte)")
        assertEquals(primitiveByte + primitiveShort, (protectedByte + protectedShort).value, "protectedByte.sum(protectedShort)")
        assertEquals(primitiveByte + primitiveInt, (protectedByte + protectedInt).value, "protectedByte.sum(protectedInt)")
        assertEquals(primitiveByte + primitiveLong, (protectedByte + protectedLong).value, "protectedByte.sum(protectedLong)")
        assertEquals(primitiveByte + primitiveFloat, (protectedByte + protectedFloat).value, "protectedByte.sum(protectedFloat)")
        assertEquals(primitiveByte + primitiveDouble, (protectedByte + protectedDouble).value, "protectedByte.sum(protectedDouble)")
    }

    @Test
    fun `test the sum operator for primitive value + protected value and compares the result with the same operation with native Byte type`() {
        assertEquals(primitiveByte + primitiveByte, primitiveByte + protectedByte, "primitiveByte.sum(protectedByte)")
        assertEquals(primitiveByte + primitiveShort, primitiveByte + protectedShort, "primitiveByte.sum(protectedShort)")
        assertEquals(primitiveByte + primitiveInt, primitiveByte + protectedInt, "primitiveByte.sum(protectedInt)")
        assertEquals(primitiveByte + primitiveLong, primitiveByte + protectedLong, "primitiveByte.sum(protectedLong)")
        assertEquals(primitiveByte + primitiveFloat, primitiveByte + protectedFloat, "primitiveByte.sum(protectedFloat)")
        assertEquals(primitiveByte + primitiveDouble, primitiveByte + protectedDouble, "primitiveByte.sum(protectedDouble)")
    }

    // Minus operator
    @Test
    fun `test the minus operator for ProtectedByte - primitive value and compares the result with the same operation with native Byte type`() {
        assertEquals(primitiveByte - primitiveByte, (protectedByte - primitiveByte).value, "protectedByte.minus(primitiveByte)")
        assertEquals(primitiveByte - primitiveShort, (protectedByte - primitiveShort).value, "protectedByte.minus(primitiveShort)")
        assertEquals(primitiveByte - primitiveInt, (protectedByte - primitiveInt).value, "protectedByte.minus(primitiveInt)")
        assertEquals(primitiveByte - primitiveLong, (protectedByte - primitiveLong).value, "protectedByte.minus(primitiveLong)")
        assertEquals(primitiveByte - primitiveFloat, (protectedByte - primitiveFloat).value, "protectedByte.minus(primitiveFloat)")
        assertEquals(primitiveByte - primitiveDouble, (protectedByte - primitiveDouble).value, "protectedByte.minus(primitiveDouble)")
    }

    @Test
    fun `test the minus operator for ProtectedByte - protected value and compares the result with the same operation with native Byte type`() {
        assertEquals(primitiveByte - primitiveByte, (protectedByte - protectedByte).value, "protectedByte.minus(protectedByte)")
        assertEquals(primitiveByte - primitiveShort, (protectedByte - protectedShort).value, "protectedByte.minus(protectedShort)")
        assertEquals(primitiveByte - primitiveInt, (protectedByte - protectedInt).value, "protectedByte.minus(protectedInt)")
        assertEquals(primitiveByte - primitiveLong, (protectedByte - protectedLong).value, "protectedByte.minus(protectedLong)")
        assertEquals(primitiveByte - primitiveFloat, (protectedByte - protectedFloat).value, "protectedByte.minus(protectedFloat)")
        assertEquals(primitiveByte - primitiveDouble, (protectedByte - protectedDouble).value, "protectedByte.minus(protectedDouble)")
    }

    @Test
    fun `test the minus operator for primitive value - protected value and compares the result with the same operation with native Byte type`() {
        assertEquals(primitiveByte - primitiveByte, primitiveByte - protectedByte, "primitiveByte.minus(protectedByte)")
        assertEquals(primitiveByte - primitiveShort, primitiveByte - protectedShort, "primitiveByte.minus(protectedShort)")
        assertEquals(primitiveByte - primitiveInt, primitiveByte - protectedInt, "primitiveByte.minus(protectedInt)")
        assertEquals(primitiveByte - primitiveLong, primitiveByte - protectedLong, "primitiveByte.minus(protectedLong)")
        assertEquals(primitiveByte - primitiveFloat, primitiveByte - protectedFloat, "primitiveByte.minus(protectedFloat)")
        assertEquals(primitiveByte - primitiveDouble, primitiveByte - protectedDouble, "primitiveByte.minus(protectedDouble)")
    }

    // Times operator
    @Test
    fun `test the times operator for ProtectedByte times primitive value and compares the result with the same operation with native Byte type`() {
        assertEquals(primitiveByte * primitiveByte, (protectedByte * primitiveByte).value, "protectedByte.times(primitiveByte)")
        assertEquals(primitiveByte * primitiveShort, (protectedByte * primitiveShort).value, "protectedByte.times(primitiveShort)")
        assertEquals(primitiveByte * primitiveInt, (protectedByte * primitiveInt).value, "protectedByte.times(primitiveInt)")
        assertEquals(primitiveByte * primitiveLong, (protectedByte * primitiveLong).value, "protectedByte.times(primitiveLong)")
        assertEquals(primitiveByte * primitiveFloat, (protectedByte * primitiveFloat).value, "protectedByte.times(primitiveFloat)")
        assertEquals(primitiveByte * primitiveDouble, (protectedByte * primitiveDouble).value, "protectedByte.times(primitiveDouble)")
    }

    @Test
    fun `test the times operator for ProtectedByte times protected value and compares the result with the same operation with native Byte type`() {
        assertEquals(primitiveByte * primitiveByte, (protectedByte * protectedByte).value, "protectedByte.times(protectedByte)")
        assertEquals(primitiveByte * primitiveShort, (protectedByte * protectedShort).value, "protectedByte.times(protectedShort)")
        assertEquals(primitiveByte * primitiveInt, (protectedByte * protectedInt).value, "protectedByte.times(protectedInt)")
        assertEquals(primitiveByte * primitiveLong, (protectedByte * protectedLong).value, "protectedByte.times(protectedLong)")
        assertEquals(primitiveByte * primitiveFloat, (protectedByte * protectedFloat).value, "protectedByte.times(protectedFloat)")
        assertEquals(primitiveByte * primitiveDouble, (protectedByte * protectedDouble).value, "protectedByte.times(protectedDouble)")
    }

    @Test
    fun `test the times operator for primitive value times protected value and compares the result with the same operation with native Byte type`() {
        assertEquals(primitiveByte * primitiveByte, primitiveByte * protectedByte, "primitiveByte.times(protectedByte)")
        assertEquals(primitiveByte * primitiveShort, primitiveByte * protectedShort, "primitiveByte.times(protectedShort)")
        assertEquals(primitiveByte * primitiveInt, primitiveByte * protectedInt, "primitiveByte.times(protectedInt)")
        assertEquals(primitiveByte * primitiveLong, primitiveByte * protectedLong, "primitiveByte.times(protectedLong)")
        assertEquals(primitiveByte * primitiveFloat, primitiveByte * protectedFloat, "primitiveByte.times(protectedFloat)")
        assertEquals(primitiveByte * primitiveDouble, primitiveByte * protectedDouble, "primitiveByte.times(protectedDouble)")
    }

    // Div operator
    @Test
    fun `test the div operator for ProtectedByte div primitive value and compares the result with the same operation with native Byte type`() {
        assertEquals(primitiveByte / primitiveByte, (protectedByte / primitiveByte).value, "protectedByte.div(primitiveByte)")
        assertEquals(primitiveByte / primitiveShort, (protectedByte / primitiveShort).value, "protectedByte.div(primitiveShort)")
        assertEquals(primitiveByte / primitiveInt, (protectedByte / primitiveInt).value, "protectedByte.div(primitiveInt)")
        assertEquals(primitiveByte / primitiveLong, (protectedByte / primitiveLong).value, "protectedByte.div(primitiveLong)")
        assertEquals(primitiveByte / primitiveFloat, (protectedByte / primitiveFloat).value, "protectedByte.div(primitiveFloat)")
        assertEquals(primitiveByte / primitiveDouble, (protectedByte / primitiveDouble).value, "protectedByte.div(primitiveDouble)")
    }

    @Test
    fun `test the div operator for ProtectedByte div protected value and compares the result with the same operation with native Byte type`() {
        assertEquals(primitiveByte / primitiveByte, (protectedByte / protectedByte).value, "protectedByte.div(protectedByte)")
        assertEquals(primitiveByte / primitiveShort, (protectedByte / protectedShort).value, "protectedByte.div(protectedShort)")
        assertEquals(primitiveByte / primitiveInt, (protectedByte / protectedInt).value, "protectedByte.div(protectedInt)")
        assertEquals(primitiveByte / primitiveLong, (protectedByte / protectedLong).value, "protectedByte.div(protectedLong)")
        assertEquals(primitiveByte / primitiveFloat, (protectedByte / protectedFloat).value, "protectedByte.div(protectedFloat)")
        assertEquals(primitiveByte / primitiveDouble, (protectedByte / protectedDouble).value, "protectedByte.div(protectedDouble)")
    }

    @Test
    fun `test the div operator for primitive value div protected value and compares the result with the same operation with native Byte type`() {
        assertEquals(primitiveByte / primitiveByte, primitiveByte / protectedByte, "primitiveByte.div(protectedByte)")
        assertEquals(primitiveByte / primitiveShort, primitiveByte / protectedShort, "primitiveByte.div(protectedShort)")
        assertEquals(primitiveByte / primitiveInt, primitiveByte / protectedInt, "primitiveByte.div(protectedInt)")
        assertEquals(primitiveByte / primitiveLong, primitiveByte / protectedLong, "primitiveByte.div(protectedLong)")
        assertEquals(primitiveByte / primitiveFloat, primitiveByte / protectedFloat, "primitiveByte.div(protectedFloat)")
        assertEquals(primitiveByte / primitiveDouble, primitiveByte / protectedDouble, "primitiveByte.div(protectedDouble)")
    }

    // Rem operator
    @Test
    fun `test the rem operator for ProtectedByte rem primitive value and compares the result with the same operation with native Byte type`() {
        assertEquals(primitiveByte % primitiveByte, (protectedByte % primitiveByte).value, "protectedByte.rem(primitiveByte)")
        assertEquals(primitiveByte % primitiveShort, (protectedByte % primitiveShort).value, "protectedByte.rem(primitiveShort)")
        assertEquals(primitiveByte % primitiveInt, (protectedByte % primitiveInt).value, "protectedByte.rem(primitiveInt)")
        assertEquals(primitiveByte % primitiveLong, (protectedByte % primitiveLong).value, "protectedByte.rem(primitiveLong)")
        assertEquals(primitiveByte % primitiveFloat, (protectedByte % primitiveFloat).value, "protectedByte.rem(primitiveFloat)")
        assertEquals(primitiveByte % primitiveDouble, (protectedByte % primitiveDouble).value, "protectedByte.rem(primitiveDouble)")
    }

    @Test
    fun `test the rem operator for ProtectedByte rem protected value and compares the result with the same operation with native Byte type`() {
        assertEquals(primitiveByte % primitiveByte, (protectedByte % protectedByte).value, "protectedByte.rem(protectedByte)")
        assertEquals(primitiveByte % primitiveShort, (protectedByte % protectedShort).value, "protectedByte.rem(protectedShort)")
        assertEquals(primitiveByte % primitiveInt, (protectedByte % protectedInt).value, "protectedByte.rem(protectedInt)")
        assertEquals(primitiveByte % primitiveLong, (protectedByte % protectedLong).value, "protectedByte.rem(protectedLong)")
        assertEquals(primitiveByte % primitiveFloat, (protectedByte % protectedFloat).value, "protectedByte.rem(protectedFloat)")
        assertEquals(primitiveByte % primitiveDouble, (protectedByte % protectedDouble).value, "protectedByte.rem(protectedDouble)")
    }

    @Test
    fun `test the rem operator for primitive value rem protected value and compares the result with the same operation with native Byte type`() {
        assertEquals(primitiveByte % primitiveByte, primitiveByte % protectedByte, "primitiveByte.rem(protectedByte)")
        assertEquals(primitiveByte % primitiveShort, primitiveByte % protectedShort, "primitiveByte.rem(protectedShort)")
        assertEquals(primitiveByte % primitiveInt, primitiveByte % protectedInt, "primitiveByte.rem(protectedInt)")
        assertEquals(primitiveByte % primitiveLong, primitiveByte % protectedLong, "primitiveByte.rem(protectedLong)")
        assertEquals(primitiveByte % primitiveFloat, primitiveByte % protectedFloat, "primitiveByte.rem(protectedFloat)")
        assertEquals(primitiveByte % primitiveDouble, primitiveByte % protectedDouble, "primitiveByte.rem(protectedDouble)")
    }
}
