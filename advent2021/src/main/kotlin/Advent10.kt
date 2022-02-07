class Advent10(private val lines: List<String>) : IAdvent {

    override fun part1() = lines.sumOf { getErrors(it).first }

    override fun part2(): Long {
        val scores = lines.map { getErrors(it) }
            .filter { it.first == 0 }
            .map { getCompleteScore(it.second) }
            .sorted()
        return scores[scores.size / 2]
    }

    private fun getCompleteScore(stack: List<Char>): Long {
        var result = 0L
        stack.reversed()
            .forEach { result = result * 5 + it.completeScore() }
        return result
    }

    private fun getErrors(line: String): Pair<Int, List<Char>> {
        val stack = mutableListOf<Char>()
        for (ch in line) {
            if (!stack.checkChar(ch)) {
                return Pair(ch.errorScore(), stack)
            }
        }
        return Pair(0, stack)
    }

    private fun Char.completeScore() =
        when (this) {
            '(' -> 1
            '[' -> 2
            '{' -> 3
            '<' -> 4
            else -> 0
        }

    private fun Char.errorScore() =
        when (this) {
            ')' -> 3
            ']' -> 57
            '}' -> 1197
            '>' -> 25137
            else -> 0
        }


    private fun MutableList<Char>.checkChar(ch: Char): Boolean {
        return when (ch) {
            '(', '[', '{', '<' -> {
                this.add(ch)
                true
            }
            ')' -> this.tryRemove('(')
            ']' -> this.tryRemove('[')
            '}' -> this.tryRemove('{')
            '>' -> this.tryRemove('<')
            else -> false
        }
    }

    private fun MutableList<Char>.tryRemove(ch: Char): Boolean {
        return if (this.last() == ch) {
            this.removeLast()
            true
        } else {
            false
        }
    }
}