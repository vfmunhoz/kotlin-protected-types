package com.vfmunhoz.protectedtypes.types

import org.junit.jupiter.api.assertAll
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertIs
import kotlin.test.assertTrue

internal class ProtectedStringTest {

    @Test
    fun `convert and compares strings and protected strings successfully`() {
        val testString = "Hello ProtectedTypes!"
        val protectedTestString = testString.toProtected()

        assertIs<ProtectedString>(protectedTestString)

        assertFalse(testString.equals(protectedTestString), "String.equals is impossible to overload for Protected parameter")

        assertAll("ProtectedString.equals",
            { assertTrue(protectedTestString.equals(testString)) },
            { assertEquals(protectedTestString, testString.toProtected()) }
        )
    }

    @Test
    fun `concat two strings with the plus operator`() {
        val beginString = "Hello"
        val endString = "ProtectedTypes!"

        val beginProtectedString = beginString.toProtected()
        val endProtectedString = endString.toProtected()

        val nativeStringConcat = beginString + endString
        val protectedStringConcat = beginProtectedString + endProtectedString

        assertEquals(nativeStringConcat, protectedStringConcat.value)
    }
}
