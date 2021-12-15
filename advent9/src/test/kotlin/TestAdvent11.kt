import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class TestAdvent11 {

    private val lines = object {}.javaClass.getResource("testinput11.txt")!!.readText().lines()

    @Test
    fun testPart1() {
        assertEquals(1656, Advent11(lines).part1())
    }
}