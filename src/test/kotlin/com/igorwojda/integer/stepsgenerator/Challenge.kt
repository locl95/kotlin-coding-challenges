package com.igorwojda.integer.stepsgenerator

import org.amshove.kluent.shouldBeEqualTo
import org.junit.jupiter.api.Test

fun generateSteps(n: Int): List<String> {

    return (1..n).toList().map {
        val spaces = (1..(n - it)).map { " " }
        val hash = (1..it).map { "#" }
        hash.plus(spaces).joinToString("")
    }
}

private class Test {
    @Test
    fun `steps n = 1`() {
        val actual = generateSteps(1)
        actual.size shouldBeEqualTo 1
        actual[0] shouldBeEqualTo "#"
    }

    @Test
    fun `steps n = 2`() {
        val actual = generateSteps(2)
        actual.size shouldBeEqualTo 2
        actual[0] shouldBeEqualTo "# "
        actual[1] shouldBeEqualTo "##"
    }

    @Test
    fun `steps n = 3`() {
        val actual = generateSteps(3)
        actual.size shouldBeEqualTo 3
        actual[0] shouldBeEqualTo "#  "
        actual[1] shouldBeEqualTo "## "
        actual[2] shouldBeEqualTo "###"
    }
}
