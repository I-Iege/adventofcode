import kotlin.math.*

class Advent7(lines: List<String>) : IAdvent {
    private val numbers = lines[0].split(",").map { it.toInt() }

    override fun part1(): Number {
        val median = numbers.median()
        return numbers.sumOf { abs(median - it) }
    }

    override fun part2(): Number {
        val average = numbers.average().roundToInt()
        return listOf(average, average - 1, average + 1)
            .map { avg ->
                numbers.sumOf { sumUntil(abs(avg - it)) }
            }
            .minOf { it }
    }

    private fun sumUntil(number: Int) = number * (number + 1) / 2

    private fun List<Int>.median(): Int {
        val sorted = this.sorted()
        return if (this.size % 2 == 1) {
            sorted[this.size - 1 / 2 + 1]
        } else {
            (sorted[size / 2 - 1] + sorted[size / 2]) / 2
        }
    }
}