import utils.Solver
import utils.readInputLines
import utils.readInputs




class Day2 : Solver(2) {
    override fun solvePart1(input: String): Any {
        val data = readInputLines(input)

        var score = 0

        for (round in data) {
            val currentRound = round.split(" ")
            val enemyInput = currentRound[0]
            val myInput = currentRound[1]

            when {
                // rock A X 1
                // paper B Y 2
                // scissors C Z 3
                enemyInput == "A" && myInput == "X" -> score += 1 + 3
                enemyInput == "A" && myInput == "Y" -> score += 2 + 6
                enemyInput == "A" && myInput == "Z" -> score += 3

                enemyInput == "B" && myInput == "X" -> score += 1
                enemyInput == "B" && myInput == "Y" -> score += 2 + 3
                enemyInput == "B" && myInput == "Z" -> score += 3 + 6

                enemyInput == "C" && myInput == "X" -> score += 1 + 6
                enemyInput == "C" && myInput == "Y" -> score += 2
                enemyInput == "C" && myInput == "Z" -> score += 3 + 3
            }
        }

        return score
    }

    override fun solvePart2(input: String): Any {
        val data = readInputLines(input)

        var score = 0

        for (round in data) {
            val currentRound = round.split(" ")
            val enemyInput = currentRound[0]
            val myInput = currentRound[1]

            when {

                // ROCK
                enemyInput == "A" && myInput == "X" -> score += 3
                enemyInput == "A" && myInput == "Y" -> score += 1 + 3
                enemyInput == "A" && myInput == "Z" -> score += 2 + 6

                // PAPER
                enemyInput == "B" && myInput == "X" -> score += 1
                enemyInput == "B" && myInput == "Y" -> score += 2 + 3
                enemyInput == "B" && myInput == "Z" -> score += 3 + 6

                // SCISSORS
                enemyInput == "C" && myInput == "X" -> score += 2
                enemyInput == "C" && myInput == "Y" -> score += 3 + 3
                enemyInput == "C" && myInput == "Z" -> score += 1 + 6
            }

        }

        return score
    }
}

fun main() {
    val data = """
        A Y
        B X
        C Z
    """.trimIndent()

    Day2().verifyAndSolve(data, 15, "#1")
    Day2().verifyAndSolve(data, 12, "#2")
}