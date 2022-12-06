import utils.Solver

class Day6 : Solver(6) {
    override fun solvePart1(input: String): Any {
        var tempInput = input

        var counter = 0

        for (i in input.indices) {
            val testBlock = tempInput.take(3)
            val lastC = testBlock.drop(2)
            val firstTwo = testBlock.take(2)

            if (testBlock.contains(tempInput[3]) || firstTwo.contains(lastC) || testBlock[0] == testBlock[1]) {
                counter ++
                tempInput = tempInput.drop(1)

            } else {
                return counter + 4
            }
        }

        return counter
    }

    override fun solvePart2(input: String): Any {
        var tempInput = input
        var counter = 0

        for (i in input.indices) {
            val testBlock = tempInput.take(13)
            var isUnique = true

            if (testBlock.contains(tempInput[13])) {
                counter ++
                tempInput = tempInput.drop(1)
            } else {
                for (c in testBlock.indices) {
                    val temp = testBlock.drop(c+1)

                    if (temp.contains(testBlock[c])) {
                        isUnique = false
                        break
                    }
                }

                if (isUnique) {
                    return counter + 14
                } else {
                    counter ++
                    tempInput = tempInput.drop(1)
                }
            }
        }

        return 0
    }
}

fun main() {
    val testData = """
        bvwbjplbgvbhsrlpgdmjqwftvncz
    """.trimIndent()

    Day6().verifyAndSolve(testData, 5, "#1")
    Day6().verifyAndSolve(testData, 23, "#2")
}