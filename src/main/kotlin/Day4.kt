import utils.Solver
import utils.readInputLines

class Day4 : Solver(4) {
    override fun solvePart1(input: String): Any {
        val data = readInputLines(input)

        var count = 0

        for (line in data) {
            val l = line.split(",")
            val pair1 = Pair(l[0].split("-")[0], l[0].split("-")[1])
            val pair2 = Pair(l[1].split("-")[0], l[1].split("-")[1])

            if (pair1.first.toInt() <= pair2.first.toInt() && pair1.second.toInt() >= pair2.second.toInt() && pair1.second.toInt() >= pair1.first.toInt()) {
                count ++
            } else if (pair1.first.toInt() >= pair2.first.toInt() && pair1.second.toInt() <= pair2.second.toInt() && pair2.second.toInt() >= pair2.first.toInt()) {
                count ++
            }
        }

        return count
    }

    override fun solvePart2(input: String): Any {
        val data = readInputLines(input)

        var count = 0

        for (line in data) {
            val l = line.split(",")

            val list1 = createList(Pair(l[0].split("-")[0].toInt(), l[0].split("-")[1].toInt()))
            val list2 = createList(Pair(l[1].split("-")[0].toInt(), l[1].split("-")[1].toInt()))

            for (i in list1) {
                if (list2.contains(i)) {
                    count ++
                    break
                }
            }
        }

        return count
    }

    private fun createList(pair : Pair<Int, Int>): IntRange {
        return pair.first.. pair.second
    }
}

fun main() {
    val testData = """
        2-4,6-8
        2-3,4-5
        5-7,7-9
        2-8,3-7
        6-6,4-6
        2-6,4-8
    """.trimIndent()

    val testData2 = """
        7-35,49-54
    """.trimIndent()

    //Day4().verifyAndSolve(testData, 2, "#1")
    Day4().verifyAndSolve(testData, 4, "#2")
}