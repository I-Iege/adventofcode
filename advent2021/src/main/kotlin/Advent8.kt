typealias Code = Set<Char>

class Advent8(lines: List<String>) : IAdvent {
    private val words = lines.map { it.substringBefore("|").split(" ") }
        .map { it.map { it.toSet() } }
    private val output = lines.map { it.substringAfter("|").split(" ").filter { it.isNotEmpty() } }
        .map { it.map { it.toSet() } }

    override fun part1(): Number {
        return output.flatten()
            .count { it.size in setOf(2, 3, 4, 7) } // 1 7 4 8
    }


    override fun part2(): Number {
        val intToCode = words.map {
            it.filter { it.size in setOf(2, 3, 4, 7) }
                .associate { Pair(toNumberByLength(it), it) }.toMutableMap()

        }

        val codeToInt = intToCode.mapIndexed { index, map ->
            mapOf(
                map[1]!! to 1,
                map[4]!! to 4,
                map[7]!! to 7,
                map[8]!! to 8,
                find(3, words[index], 5) { it.intersect(map[1]!!).size == 2 },
                find(2, words[index], 5) { map[8]!!.subtract(map[4]!!).intersect(it).size == 3 },
                find(5, words[index], 5) { map[4]!!.subtract(map[1]!!).intersect(it).size == 2 },
                find(6, words[index], 6) { it.intersect(map[1]!!).size == 1 },
                find(0, words[index], 6) { it.intersect(map[4]!!).size == 3 && it.intersect(map[7]!!).size == 3 },
                find(9, words[index], 6) { it.intersect(map[4]!!).size == 4 }
            )
        }

        return output.mapIndexed { index, sets ->
             sets.map { codeToInt[index][it]!! }
         }.sumOf{ intsToNum(it) }
    }

    private fun intsToNum(ints: List<Int>): Int = ints[0] * 1000 + ints[1] * 100 + ints[2] * 10 + ints[3]

    private fun find(
        number: Int,
        words: List<Code>,
        length: Int,
        predicate: (Set<Char>) -> Boolean
    ): Pair<Code, Int> {
        return Pair(
            words.filter { it.size == length }
                .first(predicate),
            number
        )
    }

    private fun toNumberByLength(word: Code): Int {
        return when (word.size) {
            2 -> 1
            3 -> 7
            4 -> 4
            7 -> 8
            else -> 0
        }
    }

}