fun main(args: Array<String>) {
    println("Hello World!")
    val advent = Advent()
    val advent2 = Advent2()
    val advent3 = Advent3()
    println(advent.part1())
    println(advent.part2())
    println(advent2.part1())
    println(advent2.part2())
    advent3.execute()
    advent3.execute2()
    // Try adding program arguments via Run/Debug configuration.
    // Learn more about running applications: https://www.jetbrains.com/help/idea/running-applications.html.
    println("Program arguments: ${args.joinToString()}")
}