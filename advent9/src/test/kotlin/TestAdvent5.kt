import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class TestAdvent5 {
    private val lines = object {}.javaClass.getResource("testinput5.txt")!!
        .readText()
        .lines()
        .filter{it.isNotEmpty()}


    @Test
    fun testPart1() {
        val result = Advent5(lines).part1()
        assertEquals(5, result)
    }

    @Test
    fun testPart2() {
        val result = Advent5(lines).part2()
        assertEquals(12, result)
    }
}