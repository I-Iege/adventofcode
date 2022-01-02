import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class TestAdvent8 {
    private val lines = object {}.javaClass.getResource("testinput8.txt")!!.readText().lines()

    @Test
    fun testPart1() {
         assertEquals(26, Advent8(lines).part1())
    }

    @Test
    fun testPart2() {
        assertEquals(61229, Advent8(lines).part2())
    }
}