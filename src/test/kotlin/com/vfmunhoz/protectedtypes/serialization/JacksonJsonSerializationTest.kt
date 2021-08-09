package com.vfmunhoz.protectedtypes.serialization

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertIs
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.registerKotlinModule
import com.vfmunhoz.protectedtypes.types.ProtectedByte
import com.vfmunhoz.protectedtypes.types.ProtectedDouble
import com.vfmunhoz.protectedtypes.types.ProtectedFloat
import com.vfmunhoz.protectedtypes.types.ProtectedInt
import com.vfmunhoz.protectedtypes.types.ProtectedLong
import com.vfmunhoz.protectedtypes.types.ProtectedShort
import com.vfmunhoz.protectedtypes.types.ProtectedString
import com.vfmunhoz.protectedtypes.types.toProtected

class JacksonJsonSerializationTest {

    private val parser = jacksonObjectMapper().registerKotlinModule()

    private val primitiveByte: Byte = 10
    private val primitiveShort: Short = 12
    private val primitiveInt: Int = 14
    private val primitiveLong: Long = 16
    private val primitiveFloat: Float = 18.2f
    private val primitiveDouble: Double = 20.8
    private val primitiveString: String = "Hello json parser!"

    private data class TestEntity(
        val byteValue: ProtectedByte,
        val shortValue: ProtectedShort,
        val integerValue: ProtectedInt,
        val longValue: ProtectedLong,
        val floatValue: ProtectedFloat,
        val doubleValue: ProtectedDouble,
        val stringValue: ProtectedString
    ) {
        constructor(byteValue: Byte, shortValue: Short, integerValue: Int, longValue: Long, floatValue: Float, doubleValue: Double, stringValue: String): this(
            byteValue.toProtected(),
            shortValue.toProtected(),
            integerValue.toProtected(),
            longValue.toProtected(),
            floatValue.toProtected(),
            doubleValue.toProtected(),
            stringValue.toProtected()
        )
    }

    private val testEntity = TestEntity(primitiveByte, primitiveShort, primitiveInt, primitiveLong, primitiveFloat, primitiveDouble, primitiveString)

    private val testEntityJson = """{"byteValue":$primitiveByte,"shortValue":$primitiveShort,"integerValue":$primitiveInt,"longValue":$primitiveLong,"floatValue":$primitiveFloat,"doubleValue":$primitiveDouble,"stringValue":"$primitiveString"}"""

    @Test
    fun `validate the parse of protected types to json`() {
        assertEquals("$primitiveByte", parser.writeValueAsString(primitiveByte.toProtected()))
        assertEquals("$primitiveShort", parser.writeValueAsString(primitiveShort.toProtected()))
        assertEquals("$primitiveInt", parser.writeValueAsString(primitiveInt.toProtected()))
        assertEquals("$primitiveLong", parser.writeValueAsString(primitiveLong.toProtected()))
        assertEquals("$primitiveFloat", parser.writeValueAsString(primitiveFloat.toProtected()))
        assertEquals("$primitiveDouble", parser.writeValueAsString(primitiveDouble.toProtected()))
        assertEquals("\"$primitiveString\"", parser.writeValueAsString(primitiveString.toProtected()))
    }

    @Test
    fun `validate data class conversion to Json with protected types`() {
        val json = parser.writeValueAsString(testEntity)

        assertEquals(testEntityJson, json)
    }

    @Test
    fun `parse a protected string with all parameters set and make sure only the value is printed to json`() {
        val protectedString = ProtectedString(
            value = primitiveString,
            splitToken = " ",
            replaceToken = "?",
            ignores = setOf('!')
        )

        val jsonValue = parser.writeValueAsString(protectedString)

        assertEquals("\"$primitiveString\"", jsonValue)
    }

    @Test
    fun `parse string to json with the protected types`() {
        val entity = parser.readValue(testEntityJson, TestEntity::class.java)

        assertIs<TestEntity>(entity)
        assertEquals(primitiveByte, entity.byteValue.value)
        assertEquals(primitiveShort, entity.shortValue.value)
        assertEquals(primitiveInt, entity.integerValue.value)
        assertEquals(primitiveLong, entity.longValue.value)
        assertEquals(primitiveFloat, entity.floatValue.value)
        assertEquals(primitiveDouble, entity.doubleValue.value)
        assertEquals(primitiveString, entity.stringValue.value)
    }
}
