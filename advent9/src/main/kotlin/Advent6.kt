class Advent6(lines: List<String>) : IAdvent {
    private val numbers = lines[0].split(",").map { it.toInt() }
    override fun part1(): Number {
        return calculateFishForDay(80)
    }

    override fun part2(): Number {
        return calculateFishForDay(256)
    }

    private fun calculateFishForDay(day: Int): Long {
        val map = List(9) { Pair(it, 0L) }
            .toMap()
            .toMutableMap()
        numbers.forEach {
            map[it] = map[it]!!.inc()
        }
        for (i in 0 until day) {
            val newFishDay = (i + 7) % 9
            map[newFishDay] = map[newFishDay]!! + map[i % 9]!!
        }
        return map.values.sum()
    }
}