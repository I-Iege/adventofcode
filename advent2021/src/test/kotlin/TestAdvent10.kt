import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class TestAdvent10 {
    private val lines = object {}.javaClass.getResource("testinput10.txt")!!
        .readText()
        .lines()
        .filter { it.isNotEmpty() }

    @Test
    fun testPart1() {
        assertEquals(26397, Advent10(lines).part1())
    }

    @Test
    fun testPart2() {
        assertEquals(288957L, Advent10(lines).part2())
    }
}