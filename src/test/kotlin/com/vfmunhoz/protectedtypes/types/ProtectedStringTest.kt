package com.vfmunhoz.protectedtypes.types

import com.vfmunhoz.protectedtypes.extensions.replaceFrom
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
        val beginProtectedString = ProtectedString(value = beginString, replaceToken = "%", ignores = setOf('!'))
        val endProtectedString = endString.toProtected()

        val nativeStringConcat = beginString + endString
        val protectedStringConcat = beginProtectedString + endProtectedString
        assertEquals(nativeStringConcat, protectedStringConcat.value)

        val nativeStringConcatObfuscated = nativeStringConcat.replaceFrom(nativeStringConcat.length / 2, nativeStringConcat.length - 1, "%", ignores = setOf('!'))
        assertEquals(nativeStringConcatObfuscated, protectedStringConcat.toString())
    }

    @Test
    fun `creates a protected string and prints its value obfuscated by the default strategy`() {
        val testString = "Hello ProtectedTypes!"
        val obfuscatedString = testString.replaceFrom(testString.length / 2, testString.length - 1, "*")

        assertEquals(obfuscatedString, testString.toProtected().toString())
    }

    @Test
    fun `creates a protected string and prints its value obfuscated by the default strategy ignoring chars`() {
        val testString = "Hello ProtectedTypes!"
        val ignoringChars = setOf('!')
        val obfuscatedString = testString.replaceFrom(testString.length / 2, testString.length - 1, "*", ignoringChars)
        val protectedStringIgnoring = ProtectedString(value = testString, ignores = ignoringChars)

        assertEquals(obfuscatedString, protectedStringIgnoring.toString())
    }

    @Test
    fun `creates a protected string and prints its value with a custom token`() {
        val testString = "Hello ProtectedTypes!"
        val replaceToken = "%"
        val obfuscatedString = testString.replaceFrom(testString.length / 2, testString.length - 1, replaceToken)
        val protectedStringIgnoring = ProtectedString(value = testString, replaceToken = replaceToken)

        assertEquals(obfuscatedString, protectedStringIgnoring.toString())
    }

    @Test
    fun `creates a protected string and prints its value with a separator`() {
        val testString = "Hello ProtectedTypes!"
        val protectedString = ProtectedString(testString, " ")

        val builder = StringBuilder()
        testString.split(" ").forEach {
            builder.append(it.replaceFrom(it.length / 2, it.length - 1, "*"))
        }

        assertEquals(builder.toString().trim(), protectedString.toString())
    }
}
