import org.junit.jupiter.api.Test

class TestAdvent11 {

    private val lines = object {}.javaClass.getResource("testinput11.txt")!!.readText().lines()

    @Test
    fun testPart1() {
        val result = Advent11(lines).part1()
        assert(result == 1656)
    }
}