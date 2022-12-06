import kotlin.math.pow

fun String.binToInt(): Int {
    return this.reversed()
        .map { it.digitToInt() }
        .reduceIndexed { index, acc, c -> acc + c * 2f.pow(index).toInt() }
}

fun String.hexToBin(): String = this.map {
    when (it) {
        '0' -> "0000"
        '1' -> "0001"
        '2' -> "0010"
        '3' -> "0011"
        '4' -> "0100"
        '5' -> "0101"
        '6' -> "0110"
        '7' -> "0111"
        '8' -> "1000"
        '9' -> "1001"
        'A' -> "1010"
        'B' -> "1011"
        'C' -> "1100"
        'D' -> "1101"
        'E' -> "1110"
        'F' -> "1111"
        else -> ""
    }
}.joinToString("")

enum class PackageType(val version : Int,val type : Int) {
    Literal(6,4),
    Operator1(1,4),
    Operator2(1,4);

    companion object {
        fun select(version: Int, type: Int) =
            PackageType
                .values()
                .first { it.type == type && it.version == version }
    }
}

data class Package(val version: Int, val type : Int)

class Advent16(lines: List<String>) : IAdvent {
    private val binaryData = lines[0].hexToBin()
  //  private val version = binaryData.take(3).binToInt()
   // private val type = binaryData.drop(3).take(3).binToInt()


    override fun part1(): Number {
        /*if (type == 4) {
            val packets =
                binaryData.
                drop(6)
                    .windowed(5)
                .filter { it.first()== '1' }
                .joinToString("")
                .binToInt()


            var hasGroup = true

            var current = ""
            do {
                current =
            } while( hasGroup)
        }*/
        return 0
    }

    override fun part2(): Number {
        TODO("Not yet implemented")
    }

    private fun readPackage(binary : String) : List<Package> {
        val version = binaryData.take(3).binToInt()
        val type = binaryData.drop(3).take(3).binToInt()

        return when (PackageType.select(version, type)) {
           PackageType.Literal ->listOf(Package(version, type))
           PackageType.Operator1 ->  readPackage(binary.drop(6)) + Package(version,type)
           PackageType.Operator2 -> readPackage(binary.drop(6)) + Package(version,type)
       }

     /*   if(version == 6 && type == 4) {
           return listOf(Package(version, type))
           //return readInt(binaryData)
        }

        val length = if(binary[6] == '0') {
            binary.substring(7,22)
        } else {
            binary.substring(7,18)
        }
        return readPackage(binary.drop(7))*/
    }

   private fun readInt(binary : String) : Int {
       val dwords = binary
           .windowed(4)
          return dwords
               .subList(0, dwords.indexOfFirst { it[0] == '0' } )
               .joinToString(" ") { it.drop(1) }
               .binToInt()

   }

}