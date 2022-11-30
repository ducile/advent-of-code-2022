package utils

abstract class Solver(private val day: Int) {
    private fun solve(part: String) {
        val input = readInputs(day)

        if (part == "#1")
            println("Part 1: ${solvePart1(input)}")
        else
            println("Part 2: ${solvePart2(input)}")
    }

    fun verify(testData: String, expectedOutcome: Long, part: String) {
        if (part == "#1") {
            val result = solvePart1(testData)

            if (result.toString() != expectedOutcome.toString()) {
                error("Part 1 should result in $expectedOutcome but was $result")
            }

            println("Test result: $result")
        } else {
            val result = solvePart2(testData)

            if (result.toString() != expectedOutcome.toString()) {
                error("Part 2 should result in $expectedOutcome but was $result")
            }

            println("Test result: $result")
        }
    }

    fun verifyAndSolve(testData: String, expectedOutcome: Long, part: String) {
        verify(testData, expectedOutcome, part)

        solve(part)
    }

    abstract fun solvePart1(input: String): Any
    abstract fun solvePart2(input: String): Any
}