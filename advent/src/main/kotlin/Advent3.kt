import kotlin.math.pow
import kotlin.math.sign

class Advent3 {
    private val lines = this::class.java.getResource("advent3.txt")!!.readText().lines()

    fun execute() {
        val gamma = lines
            .map { it.toDigitList().map { ch -> if (ch == 1) ch else -1 } }
            .fold(List(lines[0].length) { 0 }) { acc, digit -> addAllDigits(acc, digit) }
            .map { it.sign }
            .map { if (it == -1) 0 else it }

        val epsilon = gamma.map { 1 - it }
        val result = gamma.toDecimal() * epsilon.toDecimal()
        println(result)
    }

    fun execute2() {
        val trie = Trie()
        trie += lines
        println(trie.findMostCommon().toDecimal().toString() + " " + trie.findLeastCommon().toDecimal().toString())
    }


    private fun addAllDigits(acc: List<Int>, current: List<Int>)
        = acc.mapIndexed { index, s -> s + current[index] }


    private fun String.toDigitList(): List<Int> {
        return this.asSequence()
            .map { c -> c.digitToInt() }
            .toList()
    }


    private fun List<Int>.toDecimal() =
        this.mapIndexed { index: Int, i: Int -> 2.0.pow((this.size - index - 1).toDouble()).toInt() * i }
            .sum()

    private fun String.toDecimal() = this.toDigitList().toDecimal()
}
