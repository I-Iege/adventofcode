class Advent8(lines: List<String>) : IAdvent {
    private val words = lines.map { it.substringBefore("|").split(" ") }
    private val output = lines.map { it.substringAfter("|").split(" ") }

    override fun part1(): Number {
        return output.flatten()
            .count { it.length in setOf(2, 3, 4, 7) } // 2 4 8 128
    }

    override fun part2(): Number {
       /* val line = mutableListOf<String>()
        line += words[0]
        line += output[0]

        val map = mutableMapOf<Int, String>()
        line.forEach {
            map
        }*/
        return 0
    }

   /* fun codeToInt(code: Int): Int = when (code) {
        119 -> 0
        2 -> 1
        93 -> 2
        91 -> 3
        8 -> 4
        107-> 5
        111-> 6
        4 -> 7
        128 -> 8
        123 -> 9
        else -> 0
    }*/
}