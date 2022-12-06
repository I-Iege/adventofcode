class Advent1(lines : List<String>) :IAdvent {
    private val numbers = lines.map { it.toInt() }

    override fun part1(): Number {
       return numbers.flatMap { List(numbers.size) { it }.zip(numbers) }
            .first { it.first + it.second == 2020 }
            .let { it.first * it.second }
    }

    override fun part2(): Number {
        numbers.flatMap { List(numbers.size) { it }.it }
    }
}