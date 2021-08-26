package io.github.vfmunhoz.protectedtypes.extensions

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith

internal class StringExtensionsTest {

    private val text = "Hello ProtectedTypes!"

    @Test
    fun `should throw an exception if start position is greater than end position`() {
        assertFailsWith<IndexOutOfBoundsException> { text.replaceFrom(8, 1, "@") }
    }

    @Test
    fun `replaces part of a string without skipping any char`() {
        assertEquals("Hello @@@@@@@@@@@@@@@", text.replaceFrom(6, text.length -1, "@"))
        assertEquals("@@@@@ ProtectedTypes!", text.replaceFrom(0, 4, "@"))
        assertEquals("Hello @@@@@@@@@Types!", text.replaceFrom(6, 14, "@"))
    }

    @Test
    fun `replaces part of a string skipping multiple chars`() {
        assertEquals("Hello @@@@@@@@@@@@@@!", text.replaceFrom(6, text.length -1, "@", setOf('!')))
        assertEquals("@@ll@ ProtectedTypes!", text.replaceFrom(0, 4, "@", setOf('l')))
        assertEquals("Hello P@@t@@t@@Types!", text.replaceFrom(6, 14, "@", setOf('P', 't')))
    }
}
