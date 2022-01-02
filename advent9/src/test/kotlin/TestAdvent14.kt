import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class TestAdvent14 {
    private val lines = object {}.javaClass.getResource("testinput14.txt")!!.readText().lines()

    @Test
    fun testPart1() {
        assertEquals(1588, Advent14(lines).part1())
    }

    @Test
    fun testPart2() {
        assertEquals(2188189693529 , Advent14(lines).part2() )
    }
}