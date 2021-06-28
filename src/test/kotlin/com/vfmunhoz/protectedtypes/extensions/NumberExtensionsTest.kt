package com.vfmunhoz.protectedtypes.extensions

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

internal class NumberExtensionsTest {

    @Test
    fun `tests obfuscation function for integer types`() {
        val myByte: Byte = 10
        val myShort: Short = 100
        val myInteger = 1000
        val myLong: Long = 10000

        assertEquals("1#", myByte.obfuscate())
        assertEquals("1##", myShort.obfuscate())
        assertEquals("10##", myInteger.obfuscate())
        assertEquals("10###", myLong.obfuscate())
    }

    @Test
    fun `tests obfuscation function for floating point types`() {
        val smallFloat = 100.01f
        val smallDouble = 100.01

        val smallFloatObfuscated = smallFloat.obfuscate()

        assertTrue(smallFloatObfuscated.contains('.'))
        assertEquals(smallFloat.toString().length, smallFloatObfuscated.length)
        assertEquals(smallFloat.toString().indexOf('.'), smallFloatObfuscated.indexOf('.'))
        assertEquals("100.##", smallFloatObfuscated)

        val smallDoubleObfuscated = smallFloat.obfuscate()

        assertTrue(smallDoubleObfuscated.contains('.'))
        assertEquals(smallDouble.toString().length, smallDoubleObfuscated.length)
        assertEquals(smallDouble.toString().indexOf('.'), smallDoubleObfuscated.indexOf('.'))
        assertEquals("100.##", smallDoubleObfuscated)
    }
}
