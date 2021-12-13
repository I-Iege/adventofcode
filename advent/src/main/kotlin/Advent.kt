class Advent {
    private val lines = this::class.java.getResource("advent1.txt")!!.readText().lines().map { it.toInt() }

    fun part1(): Int {
        return lines
            .zipWithNext()
            .count { it.first < it.second }
    }

    fun part2(): Int {
        return lines
            .windowed(3)
            .map { it.sum() }
            .zipWithNext()
            .count { it.first < it.second }
    }

}

