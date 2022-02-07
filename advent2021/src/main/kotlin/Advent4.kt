typealias Board = MutableList<MutableList<Pair<Int, Boolean>>>

class Advent4(private val lines: List<String>) : IAdvent {
    private val numbers = lines[0].split(",").filter { it.isNotEmpty() }.map { it.toInt() }
    private var boards = getBoards()

    override fun part1(): Number {
        var result = listOf<Int>()
        var i = 0
        while (result.isEmpty() && i < numbers.size) {
            result = markNumber(numbers[i])
            ++i
        }
        return if (result.isNotEmpty()) {
            calculateScore(boards[result.first()], numbers[i - 1])
        } else {
            0
        }
    }

    override fun part2(): Number {
        var result = listOf<Int>()
        var i = 0
        var board = board()
        var win: Boolean
        while (boards.isNotEmpty() && i < numbers.size) {
            win = false
            while (!win && i < numbers.size) {
                val currentResult = markNumber(numbers[i])
                if (currentResult.isNotEmpty()) {
                    win = true
                    result = currentResult
                }
                ++i
            }
            if (win) {
                board = boards.last()
                boards.removeAll(result.map { boards[it] })
            }
        }
        return if (board.isNotEmpty()) {
            calculateScore(board, numbers[i - 1])
        } else {
            0
        }
    }

    private fun getBoards(): MutableList<Board> {
        val strippedLines = lines.drop(1).filter { it.isNotEmpty() }
        boards = mutableListOf()
        for (i in 0 until strippedLines.size / 5) {
            val board = board()
            for (j in 0 until 5) {
                val boardLine = mutableListOf<Pair<Int, Boolean>>()
                boardLine += strippedLines[i * 5 + j].split(" ").filter { it.isNotEmpty() }
                    .map { Pair(it.toInt(), false) }
                board.add(boardLine)
            }
            boards.add(board)
        }
        return boards
    }

    private fun markNumber(number: Int): List<Int> {
        var win: Boolean
        var winList = mutableListOf<Int>()
        for (board in boards.indices) {
            var found = false
            var position = Pair(0, 0)
            for (line in boards[board].indices) {
                for (column in boards[board][line].indices) {
                    if (boards[board][line][column].first == number) {
                        boards[board][line][column] = Pair(boards[board][line][column].first, true)
                        found = true
                        position = Pair(line, column)
                        break
                    }
                }
                if (found) {
                    break
                }
            }
            if (found) {
                win = checkWin(boards[board], position)
                if (win) {
                    winList.add(board)
                }
            }
        }
        return winList
    }

    private fun checkWin(board: List<List<Pair<Int, Boolean>>>, position: Pair<Int, Int>): Boolean {
        return board[position.first].all { it.second } || board.map { it[position.second] }.all { it.second }
    }


    private fun calculateScore(board: MutableList<MutableList<Pair<Int, Boolean>>>, number: Int): Int {
        val sum = board.flatten().filter { !it.second }.sumOf { it.first }
        return sum * number
    }

   private fun board() = mutableListOf<MutableList<Pair<Int,Boolean>>>()
}