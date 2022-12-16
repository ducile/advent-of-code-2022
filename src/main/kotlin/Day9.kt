import utils.Solver
import utils.readInputLines
import java.lang.Math.abs

class Day9 : Solver(9) {
    override fun solvePart1(input: String): Any {
        val commands = readInputLines(input).map { it.split(" ") }

        val visitedPositions : MutableList<Pair<Int,Int>> = mutableListOf(0 to 0)
        var currentTailPos = 0 to 0
        var currentHeadPos = 0 to 0

        for (c in commands) {
            val dir = c[0]
            val steps = c[1].toInt()

            for (i in 0 until steps) {
                currentHeadPos = moveHead(dir, currentHeadPos)
                currentTailPos = moveTail(dir, currentHeadPos, currentTailPos)

                if (! visitedPositions.contains(currentTailPos)) {
                    visitedPositions.add(currentTailPos)
                }
            }
        }

        return visitedPositions.count()
    }

    private var head = 0 to 0
    private var tails: MutableList<Pair<Int,Int>> = MutableList(9) { 0 to 0 }

    override fun solvePart2(input: String): Any {
        val commands = readInputLines(input).map { it.split(" ") }

        val visitedPositions : MutableList<Pair<Int,Int>> = mutableListOf(0 to 0)

        for (c in commands) {
            val dir = c[0]
            val steps = c[1].toInt()

            println("Command $c")

            for (i in 0 until steps) {
                head = moveHead(dir, head)

                var tempTails = tails[0]

                tails[0] = moveTail(dir, head, tails[0])

                println(head)
                println(tails)

                for (t in 0 until tails.count()) {
                    if (t < 8) {
                        if (((dir == "R" || dir == "L") && abs(tails[t].first - tails[t+1].first) > 1) ||
                            ((dir == "U" || dir == "D") && abs(tails[t].second - tails[t+1].second) > 1)) {
                            tails[t+1] = tails[t]
                        }
                    }

                    if (t == 8) {
                        if (! visitedPositions.contains(tails[t])) {
                            visitedPositions.add(tails[t])
                        }
                    }
                }
            }
        }

        println(visitedPositions)

        return visitedPositions.count()
    }

    private fun moveHead (dir: String, head: Pair<Int,Int>): Pair<Int, Int> {
        val currentHeadPos = head

        when {
            dir == "R" -> {
                return currentHeadPos.first + 1 to currentHeadPos.second
            }

            dir == "L" -> {
                return currentHeadPos.first - 1 to currentHeadPos.second
            }

            dir == "U" -> {
                return currentHeadPos.first to currentHeadPos.second + 1
            }

            dir == "D" -> {
                return currentHeadPos.first to currentHeadPos.second - 1
            }
        }
        return (0 to 0)
    }

    private fun moveTail(dir: String, head: Pair<Int,Int>, tail: Pair<Int,Int>): Pair<Int, Int> {
        var currentHeadPos = head
        var currentTailPos = tail

        when {
            dir == "R" -> {
                if (currentHeadPos.second == currentTailPos.second) {
                    if (abs(currentHeadPos.first - currentTailPos.first) > 1) {
                        currentTailPos = currentTailPos.first + 1 to currentTailPos.second
                    }
                } else {
                    if (abs(currentHeadPos.first - currentTailPos.first) > 1) {
                        if (currentHeadPos.second > currentTailPos.second)
                            currentTailPos = currentTailPos.first + 1 to currentTailPos.second + 1
                        else
                            currentTailPos = currentTailPos.first + 1 to currentTailPos.second - 1
                    }
                }
            }

            // (3,5) -> (3,3)
            dir == "L" -> {
                if (currentHeadPos.second == currentTailPos.second) {
                    if (abs(currentHeadPos.first - currentTailPos.first) > 1) {
                        currentTailPos = currentTailPos.first - 1 to currentTailPos.second
                    }
                } else {
                    if (abs(currentHeadPos.first - currentTailPos.first) > 1) {
                        if (currentHeadPos.second > currentTailPos.second)
                            currentTailPos = currentTailPos.first - 1 to currentTailPos.second + 1
                        else
                            currentTailPos = currentTailPos.first - 1 to currentTailPos.second - 1
                    }
                }
            }

            dir == "U" -> {
                if (currentHeadPos.first == currentTailPos.first) {
                    if (abs(currentHeadPos.second - currentTailPos.second) > 1) {
                        currentTailPos = currentTailPos.first to currentTailPos.second + 1
                    }
                } else {
                    if (abs(currentHeadPos.second - currentTailPos.second) > 1) {
                        if (currentHeadPos.first > currentTailPos.first)
                            currentTailPos = currentTailPos.first + 1 to currentTailPos.second + 1
                        else
                            currentTailPos = currentTailPos.first - 1 to currentTailPos.second + 1
                    }
                }
            }

            dir == "D" -> {
                if (currentHeadPos.first == currentTailPos.first) {
                    if (abs(currentHeadPos.second - currentTailPos.second) > 1) {
                        currentTailPos = currentTailPos.first to currentTailPos.second - 1
                    }
                } else {
                    if (abs(currentHeadPos.second - currentTailPos.second) > 1) {
                        if (currentHeadPos.first > currentTailPos.first)
                            currentTailPos = currentTailPos.first + 1 to currentTailPos.second - 1
                        else
                            currentTailPos = currentTailPos.first - 1 to currentTailPos.second - 1
                    }
                }
            }
        }

        return currentTailPos
    }
}

fun main() {
    val testData = """
        R 4
        U 4
        L 3
        D 1
        R 4
        D 1
        L 5
        R 2
    """.trimIndent()

    val testData2 = """
        R 5
        U 8
        L 8
        D 3
        R 17
        D 10
        L 25
        U 20
    """.trimIndent()

    //Day9().verifyAndSolve(testData, 13, "#1")
    Day9().verifyAndSolve(testData2, 36, "#2")
}