package utils

abstract class Solver(val day: Int) {
    fun solve() {
        val input = readInputs(day)

        println("Part 1: ${solvePart1(input)}")
        println("Part 2: ${solvePart2(input)}")
    }

    abstract fun solvePart1(input: String): String
    abstract fun solvePart2(input: String): String
}