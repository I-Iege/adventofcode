class Advent11(private val lines: List<String>) : IAdvent {
    private var matrix = mutableListOf<MutableList<Int>>()

    override fun part1(): Int {
        matrix = lines.map { it.asSequence().map { ch -> ch.digitToInt() }.toMutableList() }.toMutableList()
        var count = 0
        for (i in 1..100) {
            count += step().first
        }
        return count
    }

    override fun part2(): Int {
        matrix = lines.map { it.asSequence().map { ch -> ch.digitToInt() }.toMutableList() }.toMutableList()
        var steps = 0
        var allFlash = false
        while (!allFlash) {
            ++steps
            allFlash = step().second
        }
        return steps
    }

    private fun step(): Pair<Int, Boolean> {
        increment()
        val count = flashing()
        if (count == 100) {
            return Pair(count, true)
        }
        return Pair(count, false)
    }

    private fun increment() {
        for (i in matrix.indices) {
            for (j in matrix[0].indices) {
                matrix[i][j]++
            }
        }
    }

    private fun flashing(): Int {
        var flashing = matrix.currentlyFlashing()
        var flashingCount = flashing.size
        while (flashing.isNotEmpty()) {
            flashing.setToNull()
            flashing.flatMap { it.neighbours() }
                .forEach {
                    if (matrix[it] < 10 && matrix[it] != 0) {
                        matrix[it]++
                    }
                }
            flashing = matrix.currentlyFlashing()
            flashingCount += flashing.size
        }
        return flashingCount
    }

    private fun List<Pair<Int, Int>>.setToNull() {
        this.forEach {
            matrix[it] = 0
        }
    }

    private fun MutableList<MutableList<Int>>.currentlyFlashing(): List<Pair<Int, Int>> {
        val flashing = mutableListOf<Pair<Int, Int>>()
        for (i in this.indices) {
            for (j in this[0].indices) {
                if (this[i][j] > 9) {
                    flashing.add(Pair(i, j))
                }
            }
        }
        return flashing
    }

    private fun Pair<Int, Int>.neighbours(extended: Set<Pair<Int, Int>> = emptySet()): List<Pair<Int, Int>> {
        return listOf(
            Pair(this.first + 1, this.second),
            Pair(this.first, this.second + 1),
            Pair(this.first - 1, this.second),
            Pair(this.first, this.second - 1),
            Pair(this.first + 1, this.second + 1),
            Pair(this.first - 1, this.second - 1),
            Pair(this.first - 1, this.second + 1),
            Pair(this.first + 1, this.second - 1),
        )
            .filter { it.first in matrix.indices && it.second in matrix[0].indices }
            .filter { it !in extended }
    }

    private operator fun List<List<Int>>.get(index: Pair<Int, Int>) = this[index.first][index.second]
    private operator fun List<MutableList<Int>>.set(index: Pair<Int, Int>, value: Int) {
        this[index.first][index.second] = value
    }
}