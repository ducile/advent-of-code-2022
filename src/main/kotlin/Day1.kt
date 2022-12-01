import utils.Solver
import utils.readInputLines

class Day1 : Solver(1) {
    override fun solvePart1(input: String): Any {
        val data = readInputLines(input)

        var currentMaxWeight = 0
        var tempWeight = 0

        for(elf in data) {
            if (elf.isEmpty()) {
                tempWeight = 0
            } else {
                tempWeight += elf.toInt()
            }

            if (tempWeight > currentMaxWeight) {
                currentMaxWeight = tempWeight
            }
        }

        return currentMaxWeight
    }

    override fun solvePart2(input: String): Any {
        val data = readInputLines(input)

        val weights = emptyList<Int>().toMutableList()
        var tempWeight = 0

        for(i in data.indices) {
            if (i == data.count() - 1) {
                tempWeight += data[i].toInt()
                weights.add(tempWeight)
            }

            if (data[i].isEmpty()) {
                weights.add(tempWeight)
                tempWeight = 0
            } else {
                tempWeight += data[i].toInt()
            }
        }

        return weights.sorted().reversed().take(3).sum()
    }
}

fun main() {
    val testInput = """
        1000
        2000
        3000

        4000

        5000
        6000

        7000
        8000
        9000

        10000
    """.trimIndent()

    Day1().verifyAndSolve(testInput, 24000, "#1")
    Day1().verifyAndSolve(testInput, 45000, "#2")
}