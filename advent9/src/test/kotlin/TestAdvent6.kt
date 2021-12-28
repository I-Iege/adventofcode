import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class TestAdvent6 {
    private val lines = object {}.javaClass.getResource("testinput6.txt")!!.readText().lines()
    @Test
    fun testPart1() {
        assertEquals(5934L, Advent6(lines).part1())
    }
}