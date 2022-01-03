import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class TestAdvent5 {
    private val lines = object {}.javaClass.getResource("testinput5.txt")!!
        .readText()
        .lines()
        .filter { it.isNotEmpty() }


    @Test
    fun testPart1() {
        assertEquals(5, Advent5(lines).part1())
    }

    @Test
    fun testPart2() {
        assertEquals(12, Advent5(lines).part2())
    }
}