class Advent2(private val lines : List<String>)  : IAdvent {

    override fun part1(): Int = lines
        .map { it.split(" ") }
        .fold(mutableListOf(0, 0)) { acc, movement -> addMovement(acc, movement) }
        .reduce { acc, i -> acc * i }

    override fun part2(): Int = lines
        .map { it.split(" ") }
        .fold(mutableListOf(0, 0, 0)) { acc, movement -> addMovement2(acc, movement) }
        .dropLast(1)
        .reduce { acc, i -> acc * i }

    private fun addMovement(acc: MutableList<Int>, move: List<String>): MutableList<Int> {
        val step = move[1].toInt()
        when (move[0]) {
            "forward" -> acc[0] += step
            "down" -> acc[1] += step
            "up" -> acc[1] -= step
            else -> {}
        }
        return acc
    }

    private fun addMovement2(acc: MutableList<Int>, move: List<String>): MutableList<Int> {
        val step = move[1].toInt()
        when (move[0]) {
            "forward" -> {
                acc[0] += step
                acc[1] += acc[2] * step
            }
            "down" -> acc[2] += step
            "up" -> acc[2] -= step
            else -> {}
        }
        return acc
    }
}