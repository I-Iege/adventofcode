class Advent12(lines: List<String>) : IAdvent {
    private val pairs = lines.map { it.split("-") }

    private val routes = pairs
        .plus(pairs.map { it.reversed() })
        .filter { it[1] != "start" }
        .filter { it[0] != "end" }
        .groupingBy { it[0] }
        .aggregate { _, accumulator: MutableList<String>?, element, first ->
            if (first)
                mutableListOf(element[1])
            else
                accumulator!!.plus(element[1]).toMutableList()
        }

    override fun part1(): Number {
        return addNode("start", listOf("start")) { false }.size
    }

    override fun part2(): Number {
        return addNode("start", listOf("start")) {
            it.filter { c -> c.isLowercase() }.distinct().size == it.filter { c -> c.isLowercase() }.size
        }.size
    }

    private fun addNode(
        node: String,
        currentRoute: List<String>,
        predicate: (List<String>) -> Boolean
    ): List<List<String>> {
        if (node == "end") {
            return listOf(currentRoute)
        }
        if (routes.containsKey(node)) {
            return routes[node]!!
                .filter {
                    !it.isLowercase()
                            || it !in currentRoute
                            || predicate(currentRoute)
                }
                .map { addNode(it, currentRoute.plus(it), predicate) }
                .flatten()
        }
        return listOf(currentRoute)
    }

    private fun String.isLowercase() = this == this.lowercase()
}