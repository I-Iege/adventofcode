class Advent14(lines: List<String>) : IAdvent {
    private val input = lines[0]
    private val rules = lines
        .asSequence()
        .filter { it.isNotEmpty() }
        .drop(1)
        .map { it.filter { it2 -> !it2.isWhitespace() } }
        .map { it.split("->") }
        .associate { it[0] to it[1][0] }

    override fun part1(): Number {
        var str = input

        for (i in 1..10) {
            str = str
                .windowed(2)
                .joinToString("") {
                    it[0].toString() + rules.getOrDefault(it, "")
                }
                .plus(str.last())
        }

        val counts = str.groupingBy { it }
            .eachCount()

        return counts.maxOf { it.value } - counts.minOf { it.value }
    }

    override fun part2(): Number {
        val map = input
            .windowed(2).groupingBy { it }
            .eachCount()
            .map { it.key to it.value.toLong() }
            .toMap()
            .toMutableMap()

        for (i in 1..40) {
            val activeRules = map
                .filter { rules.containsKey(it.key) }

            val newItems = activeRules
                .map {
                    listOf(
                        (it.key[0].toString() + rules[it.key]!!) to it.value,
                        (rules[it.key]!! + it.key[1].toString()) to it.value
                    )
                }
                .flatten()
            newItems.forEach { map.increment(it) }
            activeRules.forEach { map.decrease(it.key to it.value) }
        }

        val counts = map.map {
            it.key[1] to it.value
        }.groupingBy { it.first }
            .aggregate { _, accumulator: Long?, element, first ->
                if (first)
                    element.second
                else
                    accumulator!!.plus(element.second)
            }.toMutableMap()

        counts[input.first()] = counts[input.first()]!!.inc()
        return counts.maxOf { it.value } - counts.minOf { it.value }
    }

    private fun MutableMap<String, Long>.increment(pair: Pair<String, Long>) {
        if (this.containsKey(pair.first)) {
            this[pair.first] = this[pair.first]!! + pair.second
        } else {
            this[pair.first] = pair.second
        }
    }

    private fun MutableMap<String, Long>.decrease(pair: Pair<String, Long>) {
        if (this[pair.first]!! > pair.second) {
            this[pair.first] = this[pair.first]!! - pair.second
        } else {
            this.remove(pair.first)
        }
    }
}