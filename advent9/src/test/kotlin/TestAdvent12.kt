import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class TestAdvent12 {

    private val lines = object {}.javaClass.getResource("testinput12.txt")!!.readText().lines()
    private val lines2 = object {}.javaClass.getResource("testinput12b.txt")!!.readText().lines()

    @Test
    fun testPart1() {
        assertEquals(10, Advent12(lines).part1())
        assertEquals(19, Advent12(lines2).part1())
    }

    @Test
    fun testPart2() {
        assertEquals(36, Advent12(lines).part2())
    }
}