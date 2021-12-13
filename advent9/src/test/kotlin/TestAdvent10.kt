import org.junit.jupiter.api.Test

class TestAdvent10 {
    private val lines = object {}.javaClass.getResource("testinput10.txt")!!
        .readText()
        .lines()
        .filter{it.isNotEmpty()}

    @Test
    fun testPart1(){
        val result =  Advent10(lines).part1()
        assert(result == 26397)
    }

    @Test
    fun testPart2() {
        val result = Advent10(lines).part2()
        assert(result == 288957L)
    }
}