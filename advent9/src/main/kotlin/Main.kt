fun main() {

    val inputs = mutableMapOf<Int, List<String>>()
    for (i in 1..14) {
        inputs[i] = object {}.javaClass.getResource("input${i}.txt")!!.readText().lines().filter { it.isNotEmpty() }
    }

    val tasks = listOf(
        Advent(inputs[1]!!),
        Advent2(inputs[2]!!),
        Advent3(inputs[3]!!),
        Advent4(inputs[4]!!),
        Advent5(inputs[5]!!),
        Advent6(inputs[6]!!),
        Advent7(inputs[7]!!),
        Advent8(inputs[8]!!),
        Advent9(inputs[9]!!),
        Advent10(inputs[10]!!),
        Advent11(inputs[11]!!),
        Advent12(inputs[12]!!),
        Advent13(inputs[13]!!),
        Advent14(inputs[14]!!)
    )

    tasks.forEachIndexed { ind, it ->
        println("advent ${ind + 1} part1: ${it.part1()}")
        println("advent ${ind + 1} part2: ${it.part2()}")
    }
}