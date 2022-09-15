package com.igorwojda.integer.stepsgenerator

// Kotlin repeat function
private object Solution1 {
    private fun generateSteps(n: Int) = List(n) { "#".repeat(it + 1) + " ".repeat(n - it - 1) }
}

// iterative solution
private object Solution2 {
    private fun generateSteps(n: Int): MutableList<String> {
        val list = mutableListOf<String>()

        (1..n).forEach { row ->
            var item = ""

            (1..n).forEach { column ->
                val char = if (column <= row) '#' else ' '
                item += char
            }

            list.add(item)
        }

        return list
    }
}

// recursive solution
private object Solution3 {
    private fun generateSteps(n: Int, row: Int = 0, stair: String = ""): MutableList<String> {
        // handle complete all the work
        if (n == row) {
            return mutableListOf()
        }

        // handle end of the row
        if (n == stair.length) {
            generateSteps(n, row + 1)
            return mutableListOf()
        }

        // handle the case where we are assembling stare string
        val char = if (stair.length <= row) '#' else ' '
        val currentStar = stair + char

        return generateSteps(n, row, currentStar)
    }
}
