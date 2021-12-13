fun main() {

    val inputs = mutableMapOf<Int, List<String>>()
    for (i in 1..5) {
        inputs[i] = object {}.javaClass.getResource("input${i}.txt")!!.readText().lines().filter { it.isNotEmpty() }
    }
    for (i in 9..12) {
        inputs[i] = object {}.javaClass.getResource("input${i}.txt")!!.readText().lines().filter { it.isNotEmpty() }
    }

    val tasks = listOf(
        Advent9(inputs[9]!!),
        Advent10(inputs[10]!!),
        Advent11(inputs[11]!!),
        Advent12(inputs[12]!!)
    )

    println("advent 4 part1: ${Advent4(inputs[4]!!).part1()}")
    println("advent 4 part2: ${Advent4(inputs[4]!!).part2()}")

    println("advent 5 part1: ${Advent5(inputs[5]!!).part1()}")
    println("advent 5 part2: ${Advent5(inputs[5]!!).part2()}")

    tasks.forEachIndexed { ind, it ->
        println("advent ${ind + 9} part1: ${it.part1()}")
        println("advent ${ind + 9} part2: ${it.part2()}")
    }

}