import utils.Solver
import utils.readInputLines
import utils.readInputs

class Day5 : Solver(5) {
    val s = """
        [H]         [H]         [V]
        [V]         [V] [J]     [F] [F]
        [S] [L]     [M] [B]     [L] [J]
        [C] [N] [B] [W] [D]     [D] [M]
    [G] [L] [M] [S] [S] [C]     [T] [V]
    [P] [B] [B] [P] [Q] [S] [L] [H] [B]
    [N] [J] [D] [V] [C] [Q] [Q] [M] [P]
    [R] [T] [T] [R] [G] [W] [F] [W] [L]
     1   2   3   4   5   6   7   8   9
    """.trimIndent()

    val mainStacks = mutableListOf(
        mutableListOf('0'),
        mutableListOf('R', 'N', 'P', 'G'),
        mutableListOf('T', 'J', 'B', 'L', 'C', 'S', 'V', 'H'),
        mutableListOf('T', 'D', 'B', 'M', 'N', 'L'),
        mutableListOf('R', 'V', 'P', 'S', 'B'),
        mutableListOf('G', 'C', 'Q', 'S', 'W', 'M', 'V', 'H'),
        mutableListOf('W', 'Q', 'S', 'C', 'D', 'B', 'J'),
        mutableListOf('F', 'Q', 'L'),
        mutableListOf('W', 'M', 'H', 'T', 'D', 'L', 'F', 'V'),
        mutableListOf('L', 'P', 'B', 'V', 'M', 'J', 'F')
    )

    val t = """
            [D]    
        [N] [C]    
        [Z] [M] [P]
         1   2   3
    """.trimIndent()

    val testStacks = mutableListOf(
        mutableListOf('e'),
        mutableListOf('Z', 'N'),
        mutableListOf('M', 'C', 'D'),
        mutableListOf('P')
    )

    override fun solvePart1(input: String): Any {
        val data = readInputLines(input)

        var stacks = mainStacks

        for (c in data) {
            val command = c.split(" ")
            val amount = command[1].toInt()
            val from = command[3].toInt()
            val to = command[5].toInt()

            stacks = moveStacks(stacks, amount, from, to)
        }

        var result = ""

        for (i in 1 until stacks.count()) {
            result += stacks[i].last()
        }

        return result
    }

    private fun moveStacks(
        stacks: MutableList<MutableList<Char>>,
        amount: Int,
        from: Int,
        to: Int
    ): MutableList<MutableList<Char>> {
        val movingElements = stacks[from].takeLast(amount)


        println(stacks)
        println(movingElements)

        stacks[to].addAll(movingElements)
        stacks[from] = stacks[from].dropLast(amount).toMutableList()

        return stacks
    }

    override fun solvePart2(input: String): Any {
        val data = readInputLines(input)

        var stacks = mainStacks

        for (c in data) {
            val command = c.split(" ")
            val amount = command[1].toInt()
            val from = command[3].toInt()
            val to = command[5].toInt()

            stacks = moveStacks(stacks, amount, from, to)
        }

        var result = ""

        for (i in 1 until stacks.count()) {
            result += stacks[i].last()
        }

        return result
    }

}

fun main() {
    val testData = """
        move 1 from 2 to 1
        move 3 from 1 to 3
        move 2 from 2 to 1
        move 1 from 1 to 2
    """.trimIndent()

    println(Day5().solvePart1(readInputs(5)))
    println(Day5().solvePart2(readInputs(5)))
}