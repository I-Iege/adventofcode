import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class TestAdvent9 {
    private val lines = object {}.javaClass.getResource("testinput9.txt")!!
        .readText()
        .lines()
        .filter { it.isNotEmpty() }

    @Test
    fun testPart1() {
        assertEquals(15, Advent9(lines).part1())
    }

    @Test
    fun testPart2() {
        assertEquals(1134, Advent9(lines).part2())
    }
}