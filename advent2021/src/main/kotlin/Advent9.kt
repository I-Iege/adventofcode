
typealias Point = Pair<Int, Int>

class Advent9(lines: List<String>) : IAdvent {
    private val matrix = lines.map { it.asSequence().map { ch -> ch.digitToInt() }.toList() }

    override fun part1() = basinPositions()
        .sumOf { matrix[it].inc() }

    override fun part2() = basinPositions()
        .map { basinArea(it).size }
        .sortedDescending()
        .take(3)
        .reduce { acc, i -> acc * i }

    private fun basinArea(basin: Point): Set<Point> {
        val extended = mutableSetOf<Point>()
        var toExtend = setOf(basin)
        while (toExtend.isNotEmpty()) {
            val currentExtension = toExtend
                .flatMap { it.neighbours(extended) }
                .filter { matrix[it] != 9 }
                .toSet()
            extended += toExtend
            toExtend = currentExtension
        }
        return extended
    }


    private fun Pair<Int, Int>.neighbours(extended: Set<Pair<Int, Int>> = emptySet()): List<Point> {
        return listOf(
            Pair(this.first + 1, this.second),
            Pair(this.first, this.second + 1),
            Pair(this.first - 1, this.second),
            Pair(this.first, this.second - 1)
        )
            .filter { it.first in matrix.indices && it.second in matrix[0].indices }
            .filter { it !in extended }
    }

    private fun basinPositions(): List<Point> {
        val result = mutableListOf<Point>()
        for (i in matrix.indices) {
            for (j in matrix[0].indices) {
                if (isLowest(Pair(i, j))) {
                    result.add(Pair(i, j))
                }
            }
        }
        return result
    }

    private operator fun List<List<Int>>.get(index: Point) = this[index.first][index.second]

    private fun isLowest(index: Point) = index.neighbours().all { matrix[index] < matrix[it] }

}