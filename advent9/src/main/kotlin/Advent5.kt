import java.lang.Integer.max
import kotlin.math.abs

class Advent5(private val lines: List<String>) : IAdvent {
    private val endPoints: List<List<Pair<Int, Int>>> = lines.map { it.split(" -> ") }
        .map { listOf(it[0].split(","), it[1].split(",")).flatten() }
        .map { listOf(Pair(it[0].toInt(), it[1].toInt()), Pair(it[2].toInt(), it[3].toInt())) }

    override fun part1(): Number {
        return endPoints
            .filter { it[0].first == it[1].first || it[0].second == it[1].second }
            .map { it.allPoints().toList() }
            .flatten()
            .groupingBy { it }
            .eachCount()
            .entries
            .count { it.value >= 2 }
    }

    override fun part2(): Number {
        return endPoints
            .map { it.allPoints().toList() }
            .flatten()
            .groupingBy { it }
            .eachCount()
            .entries
            .count { it.value >= 2 }
    }

    private fun List<Pair<Int, Int>>.allPoints(): Set<Pair<Int, Int>> {
        val set = mutableSetOf<Pair<Int, Int>>()
        val orderedList = this
            .sortedBy { it.second }
            .sortedBy { it.first }

        val distance = max(
            abs(orderedList[1].first - orderedList[0].first),
            abs(orderedList[1].second - orderedList[0].second)
        )

        val divider = if(distance != 0) distance else 1

        val x = (orderedList[1].first - orderedList[0].first) / divider
        val y = (orderedList[1].second - orderedList[0].second) / divider
        for (i in 0..distance) {
            set.add(Pair(orderedList[0].first + x * i, orderedList[0].second + y * i))
        }
        return set
    }
}