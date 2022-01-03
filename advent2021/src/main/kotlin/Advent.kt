class Advent(lines : List<String>) : IAdvent {
    private val numbers = lines.map { it.toInt() }


    override fun part1(): Int {
        return numbers
            .zipWithNext()
            .count { it.first < it.second }
    }

    override fun part2(): Int {
        return numbers
            .windowed(3)
            .map { it.sum() }
            .zipWithNext()
            .count { it.first < it.second }
    }

}

