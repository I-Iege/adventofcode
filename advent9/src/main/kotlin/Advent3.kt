import kotlin.math.pow
import kotlin.math.sign

class Advent3(private val lines : List<String>)  : IAdvent {

    override fun part1(): Number {
        val gamma = lines
            .map { it.toDigitList().map { ch -> if (ch == 1) ch else -1 } }
            .fold(List(lines[0].length) { 0 }) { acc, digit -> addAllDigits(acc, digit) }
            .map { it.sign }
            .map { if (it == -1) 0 else it }

        val epsilon = gamma.map { 1 - it }
        return gamma.toDecimal() * epsilon.toDecimal()
    }

    override fun part2() : Number {
        val trie = Trie()
        trie += lines
        return trie.findMostCommon().toDecimal() * trie.findLeastCommon().toDecimal()
    }


    private fun addAllDigits(acc: List<Int>, current: List<Int>) = acc.mapIndexed { index, s -> s + current[index] }


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
