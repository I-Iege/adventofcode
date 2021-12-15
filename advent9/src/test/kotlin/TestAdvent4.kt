import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class TestAdvent4 {
    private val lines = object {}.javaClass.getResource("testinput4.txt")!!
        .readText()
        .lines()
        .filter { it.isNotEmpty() }

    @Test
    fun testPart1() {
        assertEquals(4512, Advent4(lines).part1())
    }

    @Test
    fun testPart2() {
        assertEquals(1924, Advent4(lines).part2())
    }
}