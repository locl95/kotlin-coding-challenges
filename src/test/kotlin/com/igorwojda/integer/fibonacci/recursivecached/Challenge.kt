package com.igorwojda.integer.fibonacci.recursivecached

import org.amshove.kluent.shouldBeEqualTo
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Timeout
import java.util.concurrent.TimeUnit

private fun fibonacciSequenceRecursiveCached(n: Int, methodCache: MutableList<MethodCache> = mutableListOf()): Int {
    fun fold(maybeInt: Int?,left: () -> Int, right: (Int) -> Int): Int {
        return if(maybeInt == null) left()
        else right(maybeInt)
    }

    val result = fold(methodCache.firstOrNull { it.n == n}?.result,
        {
            if (n < 2) {
                methodCache.add(MethodCache(n, n))
                n
            } else {
                val foo = fibonacciSequenceRecursiveCached(n - 2, methodCache) + fibonacciSequenceRecursiveCached(
                    n - 1,
                    methodCache
                )
                methodCache.add(MethodCache(n, foo))
                foo
            }
        }, {
            foo -> foo
        })

    return result
}

private data class MethodCache(val n: Int, val result: Int)

private class Test {
    @Test
    fun `calculates correct fib value for 0`() {
        fibonacciSequenceRecursiveCached(0) shouldBeEqualTo 0
    }

    @Test
    fun `calculates correct fib value for 1`() {
        fibonacciSequenceRecursiveCached(1) shouldBeEqualTo 1
    }

    @Test
    fun `calculates correct fib value for 2`() {
        fibonacciSequenceRecursiveCached(2) shouldBeEqualTo 1
    }

    @Test
    fun `calculates correct fib value for 3`() {
        fibonacciSequenceRecursiveCached(3) shouldBeEqualTo 2
    }

    @Test
    fun `calculates correct fib value for 4`() {
        fibonacciSequenceRecursiveCached(4) shouldBeEqualTo 3
    }

    @Timeout(value = 500, unit = TimeUnit.MILLISECONDS)
    fun `calculates correct fib value for 45`() {
        fibonacciSequenceRecursiveCached(45) shouldBeEqualTo 1134903170
    }
}
