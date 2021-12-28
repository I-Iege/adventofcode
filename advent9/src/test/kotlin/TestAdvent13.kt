import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class TestAdvent13 {
    private val lines = object {}.javaClass.getResource("testinput13.txt")!!.readText().lines()


    @Test
    fun testPart1() {
        assertEquals(17 ,Advent13(lines).part1())
    }
}