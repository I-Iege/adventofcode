import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class TestAdvent7 {
    private val lines = object {}.javaClass.getResource("testinput7.txt")!!.readText().lines()

    @Test
    fun testPart1() {
        assertEquals(37, Advent7(lines).part1())
    }

    @Test
    fun testPart2() {
        assertEquals(168, Advent7(lines).part2())
    }
}