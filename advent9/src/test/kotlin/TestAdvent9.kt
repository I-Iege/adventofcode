
import org.junit.jupiter.api.Test

class TestAdvent9 {
    private val lines = object {}.javaClass.getResource("testinput9.txt")!!
        .readText()
        .lines()
        .filter{it.isNotEmpty()}

    @Test
    fun testPart1(){
        val result = Advent9(lines).part1()
        assert(result== 15)
    }

    @Test
    fun testPart2(){
        val result = Advent9(lines).part2()
        assert(result== 1134)
    }
}