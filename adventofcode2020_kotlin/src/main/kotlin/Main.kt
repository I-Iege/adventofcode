fun main() {

    val inputs = mutableMapOf<Int, List<String>>()
    for (i in 1..1) {
        inputs[i] = object {}.javaClass.getResource("input$i.txt")!!
            .readText()
            .lines()
            .filter { it.isNotEmpty() }
    }

    val tasks = listOf(
        Advent1(inputs[1]!!),

    )

    tasks.forEachIndexed { ind, it ->
        println("advent ${ind + 1} part1: ${it.part1()}")
        println("advent ${ind + 1} part2: ${it.part2()}")
    }
}