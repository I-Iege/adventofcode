typealias Road = List<Point>

class Advent15(lines: List<String>) : IAdvent {
    private val matrix = lines.map { it.map { ch -> ch.digitToInt() } }
    private val matrix5 = matrix
        .map { it.duplicateRow(5) }
        .duplicateLines(5)

    private val startInd = Pair(0, 0)

    override fun part1(): Number {
        return dijkstra(matrix)
    }

    override fun part2(): Number {
        return dijkstra(matrix5)
    }

    private fun dijkstra(matrix: List<List<Int>>): Number {
        val endInd = Pair(matrix.size - 1, matrix.last().size - 1)


        val vertexMap = matrix.indices.map { i -> matrix.indices.map { j -> i to j } }
            .flatten()
            .associateWith { Pair(Int.MAX_VALUE, Pair(-1, -1)) }
            .toMutableMap()

        val q = mutableListOf(startInd)

        vertexMap[startInd] = Pair(0, Pair(-1, -1))
        while (q.isNotEmpty()) {
            val u = q.minByOrNull { vertexMap[it]!!.first }
            q.remove(u)

            if (u == endInd) {
                break
            }

            u!!.neighbours(matrix).forEach {
                val alt = vertexMap[u]!!.first + matrix[it]
                if (alt < vertexMap[it]!!.first) {
                    vertexMap[it] = Pair(alt, u)
                    q.add(it)
                }
            }
        }
        return vertexMap[endInd]!!.first
    }

    private fun Road.cost() = this.drop(1).sumOf { matrix[it] }

    private fun Pair<Int, Int>.neighbours(matrix: List<List<Int>>): List<Point> {
        return listOf(
            Pair(this.first + 1, this.second),
            Pair(this.first, this.second + 1),
            Pair(this.first - 1, this.second),
            Pair(this.first, this.second - 1)
        )
            .filter { it.first in matrix.indices && it.second in matrix[0].indices }
    }

    private fun List<Int>.duplicateRow(integer: Int): List<Int> {
        val currList = this.toMutableList()
        var result = this
        for (i in 1 until integer) {
            result = result.plus(currList.map { it.increment(i + 1) })
        }
        return result
    }

    private fun List<List<Int>>.duplicateLines(integer: Int): List<List<Int>> {
        val currMatrix = this.toMutableList()
        var result = this
        for (i in 1 until integer) {
            result = result.plus(currMatrix.map { it.increment(i + 1) })
        }
        return result
    }

    private fun List<Int>.increment(times: Int) = this.map { it.increment(times) }

    private fun Int.increment(times: Int): Int {
        var result = this
        for (i in 1 until times) {
            result = if (result < 9) result.inc() else 1
        }
        return result
    }

    private operator fun List<List<Int>>.get(index: Point) = this[index.first][index.second]
}