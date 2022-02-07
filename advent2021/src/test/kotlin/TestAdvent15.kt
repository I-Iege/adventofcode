import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class TestAdvent15 {
    private val lines = object {}.javaClass.getResource("testinput15.txt")!!.readText().lines()

    @Test
    fun testPart1() {
        assertEquals(40, Advent15(lines).part1())
    }

    @Test
    fun testPart2() {
        assertEquals(315, Advent15(lines).part2())
    }

}