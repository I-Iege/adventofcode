import org.junit.jupiter.api.Test

class TestAdvent4 {
    private val lines = object {}.javaClass.getResource("testinput4.txt")!!
        .readText()
        .lines()
        .filter{it.isNotEmpty()}

    @Test
    fun testPart1() {
        val result = Advent4(lines).part1()
        assert( result == 4512)
    }

    @Test
    fun testPart2() {
        val result = Advent4(lines).part2()
        assert( result == 1924)
    }
}