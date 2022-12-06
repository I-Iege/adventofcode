import org.junit.jupiter.api.Test
import kotlin.test.assertEquals


class TestAdvent16 {
    private val lines = object {}.javaClass.getResource("testinput16.txt")!!.readText().lines()

    @Test
    fun testPart1() {
        val values = mapOf(
            16 to listOf("8A004A801A8002F478"),
            12 to listOf("620080001611562C8802118E34"),
            23 to listOf("C0015000016115A2E0802F182340"),
            31 to listOf("A0016C880162017C3686B18A3D4780")

        )

        values.forEach {
            assertEquals(it.key, Advent16(it.value).part1())
        }
    }

    @Test
    fun testPart2() {

    }

    @Test
    fun testBinToInt() {
        assertEquals(2021, "011111100101".binToInt())
    }

    @Test
    fun testHexToBin() {
        assertEquals( "110100101111111000101000", "D2FE28".hexToBin())
        assertEquals( "100010100000000001001010100000000001101010000000000000101111010001111000",
            "8A004A801A8002F478".hexToBin())
    }

}