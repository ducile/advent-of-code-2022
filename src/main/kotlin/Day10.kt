import utils.Solver
import utils.readInputLines

class Day10 : Solver(10) {
    override fun solvePart1(input: String): Any {
        val data = readInputLines(input)

        var cQueue = emptyList<MutableList<Int>>().toMutableList()
        var register = 1

        for (c in 0 until data.count()) {
            when {
                data[c].startsWith("addx") -> {
                    val value = data[c].substring(5).toInt()

                    cQueue.add(mutableListOf(2, value))
                }

                data[c].startsWith("noop") -> {
                    cQueue.add(mutableListOf(1, 0))
                }
            }
        }

        var hasElements = true
        var i = 0
        var resultList = mutableListOf<Pair<Int,Int>>()

        while (hasElements) {
            if (cQueue.isEmpty()) {
                hasElements = false
                break
            }

            val element = cQueue[0]

            if (i == 20 || i == 60 || i == 100 || i == 140 || i == 180 || i == 220) {
                val pair = i to register
                var isContained = false


                for (p in resultList) {
                    if (p.first == i) {
                        isContained = true
                    }
                }

                if (! isContained) {
                    resultList.add(pair)
                }

            }

            if (element[0] == 0) {
                register += element[1]
                cQueue = cQueue.drop(1).toMutableList()
            } else {
                element[0] -= 1
                ++i
            }
        }

        var result = 0

        for (p in resultList) {
            result += p.first * p.second
        }
        
        return result
    }

    override fun solvePart2(input: String): Any {
        TODO("Not yet implemented")
    }
}

fun main() {
    val testData = """
        addx 15
        addx -11
        addx 6
        addx -3
        addx 5
        addx -1
        addx -8
        addx 13
        addx 4
        noop
        addx -1
        addx 5
        addx -1
        addx 5
        addx -1
        addx 5
        addx -1
        addx 5
        addx -1
        addx -35
        addx 1
        addx 24
        addx -19
        addx 1
        addx 16
        addx -11
        noop
        noop
        addx 21
        addx -15
        noop
        noop
        addx -3
        addx 9
        addx 1
        addx -3
        addx 8
        addx 1
        addx 5
        noop
        noop
        noop
        noop
        noop
        addx -36
        noop
        addx 1
        addx 7
        noop
        noop
        noop
        addx 2
        addx 6
        noop
        noop
        noop
        noop
        noop
        addx 1
        noop
        noop
        addx 7
        addx 1
        noop
        addx -13
        addx 13
        addx 7
        noop
        addx 1
        addx -33
        noop
        noop
        noop
        addx 2
        noop
        noop
        noop
        addx 8
        noop
        addx -1
        addx 2
        addx 1
        noop
        addx 17
        addx -9
        addx 1
        addx 1
        addx -3
        addx 11
        noop
        noop
        addx 1
        noop
        addx 1
        noop
        noop
        addx -13
        addx -19
        addx 1
        addx 3
        addx 26
        addx -30
        addx 12
        addx -1
        addx 3
        addx 1
        noop
        noop
        noop
        addx -9
        addx 18
        addx 1
        addx 2
        noop
        noop
        addx 9
        noop
        noop
        noop
        addx -1
        addx 2
        addx -37
        addx 1
        addx 3
        noop
        addx 15
        addx -21
        addx 22
        addx -6
        addx 1
        noop
        addx 2
        addx 1
        noop
        addx -10
        noop
        noop
        addx 20
        addx 1
        addx 2
        addx 2
        addx -6
        addx -11
        noop
        noop
        noop
    """.trimIndent()

    Day10().verifyAndSolve(testData, 13140, "#1")
}