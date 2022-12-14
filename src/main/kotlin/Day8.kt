import utils.Solver
import utils.readInputLines

class Day8 : Solver(8) {
    override fun solvePart1(input: String): Any {
        val data = readInputLines(input).map { it.toList().map { it.toString().toInt() } }
        val visiblePairs : MutableList<Pair<Int,Int>> = fillOuterPairs(data)

        for (y in 1 until data.count() - 1) {
            for (x in 1 until data[y].count() - 1) {
                val currentTree = data[y][x]

                val rightList = data[y].takeLast(data.count() - x - 1)
                val leftList = data[y].take(x)

                val visRight = isVisibleToLeftOrRight(currentTree, rightList)
                val visLeft = isVisibleToLeftOrRight(currentTree, leftList)
                val visTop = isVisibleToTop(currentTree, x, y, data)
                val visBottom = isVisibleToBottom(currentTree, x, y, data)


                if (visRight || visLeft || visTop || visBottom) {
                    if (! visiblePairs.contains(x to y))
                        visiblePairs.add(x to y)
                }
            }
        }

        return visiblePairs.count()
    }

    private fun fillOuterPairs(list: List<List<Int>>) : MutableList<Pair<Int,Int>> {
        val visible : MutableList<Pair<Int,Int>> = emptyList<Pair<Int,Int>>().toMutableList()

        for (y in list.indices) {
            for (x in list[y].indices) {
                if (x == 0 || y == 0 || x == list[0].count()-1 || y == list.count()-1) {
                    visible.add(x to y)
                }
            }
        }

        return visible
    }

    private fun isVisibleToLeftOrRight(tree: Int, list: List<Int>): Boolean {
        for(i in list) {
            if (i >= tree) {
                return false
            }
        }

        return true
    }

    private fun isVisibleToTop(tree: Int, x: Int, y: Int, list: List<List<Int>>): Boolean {
        val topList = mutableListOf<Int>()

        for (i in 0 until y) {
            topList.add(list[i][x])
        }

        for (t in topList) {
            if (t >= tree) {
                return false
            }
        }

        return true
    }

    private fun isVisibleToBottom(tree: Int, x: Int, y: Int, list: List<List<Int>>): Boolean {
        val bottomList = mutableListOf<Int>()

        for (i in y+1 until list.count()) {
            bottomList.add(list[i][x])
        }

        for (t in bottomList) {
            if (t >= tree) {
                return false
            }
        }

        return true
    }

    override fun solvePart2(input: String): Any {
        TODO("Not yet implemented")
    }
}

fun main() {
    val testData = """
        30373
        25512
        65332
        33549
        35390
    """.trimIndent()

    Day8().verifyAndSolve(testData, 21, "#1")
}