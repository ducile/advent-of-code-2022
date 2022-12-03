import utils.Solver
import utils.readInputLines

class Day3 : Solver(3) {
    override fun solvePart1(input: String): Any {
        val data = readInputLines(input)
        var count = 0

        for (backpack in data) {
            val half = when {
                backpack.length % 2 == 0 -> backpack.length / 2
                else -> backpack.length / 2 + 1
            }
            val firstHalf = backpack.substring(0, half)
            val secondHalf = backpack.substring(half)

            for (c in firstHalf) {
                if (secondHalf.contains(c)) {
                    count += when {
                        c.isLowerCase() -> {
                            getLowerCaseIndex(c)
                        }

                        else -> {
                            getUpperCaseIndex(c)
                        }
                    }

                    break
                }
            }
        }

        return count
    }

    override fun solvePart2(input: String): Any {
        var data = readInputLines(input)
        var count = 0

        for (i in 0 .. data.count() / 3) {
            val currentSet = data.take(3)

            if (data.isEmpty()) {
                break
            }

            for (c in currentSet[0]) {
                if (currentSet[1].contains(c) && currentSet[2].contains(c)) {
                    count += when {
                        c.isLowerCase() -> {
                            getLowerCaseIndex(c)
                        }

                        else -> {
                            getUpperCaseIndex(c)
                        }
                    }

                    data = data.drop(3)
                    break
                }
            }
        }

        return count
    }

    private fun getLowerCaseIndex(c : Char): Int {
        val lowerCase = "abcdefghijklmnopqrstuvwxyz"

        return lowerCase.indexOf(c) + 1
    }

    private fun getUpperCaseIndex(c : Char) : Int {
        val upperCase = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"

        return upperCase.indexOf(c) + 27
    }
}

fun main() {
    val testData = """
        vJrwpWtwJgWrhcsFMMfFFhFp
        jqHRNqRjqzjGDLGLrsFMfFZSrLrFZsSL
        PmmdzqPrVvPwwTWBwg
        wMqvLMZHhHMvwLHjbvcjnnSBnvTQFn
        ttgJtRGJQctTZtZT
        CrZsJsPPZsGzwwsLwLmpwMDw
    """.trimIndent()

    Day3().verifyAndSolve(testData, 157, "#1")
    Day3().verifyAndSolve(testData, 70, "#2")
}