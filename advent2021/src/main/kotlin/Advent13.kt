class Advent13(lines: List<String>) : IAdvent {
    private val folds = lines.filter { it.contains("fold") }
        .map { it.split("=") }
        .map { it[0].last() to it[1].toInt() }

    private val paper = mark(lines
        .filter { it.contains(",") }
        .map { it.split(",") }
        .map { it[0].toInt() to it[1].toInt() }
    )

    override fun part1(): Number {
        return foldPaper(paper, folds[0]).flatten().sum()
    }

    override fun part2(): Number {
        var currentPaper = paper
        for (fold in folds) {
            currentPaper = foldPaper(currentPaper, fold)
        }
        printPaper(currentPaper)
        return currentPaper.flatten().sum()
    }

    private fun foldPaper(paper: List<List<Int>>, fold: Pair<Char, Int>): List<List<Int>> {
        val first: List<List<Int>>
        val second: List<List<Int>>
        if (fold.first == 'x') {
            first = paper.subList(0, fold.second)
            second = paper.subList(fold.second + 1, paper.size).reversed()
        } else {
            first = paper.map { it.subList(0, fold.second) }
            second = paper.map { it.subList(fold.second + 1, it.size).reversed() }
        }
        return first.mapIndexed { index, ints ->
            if (second.size > index) concat(
                ints,
                second[index]
            ) else first[index]
        }
    }

    private fun concat(line: List<Int>, line2: List<Int>): List<Int> {
        return line.mapIndexed { index, int -> if (line2.size > index) int.or(line2[index]) else int }
    }

    private fun mark(points: List<Pair<Int, Int>>): List<List<Int>> {
        val maxX = folds.first { it.first == 'x' }.second * 2 + 1
        val maxY = folds.first { it.first == 'y' }.second * 2 + 1
        val paper = MutableList(maxX) { MutableList(maxY) { 0 } }
        points.forEach {
            paper[it.first][it.second] = 1
        }
        return paper
    }

    private fun printPaper(paper: List<List<Int>>) {
        val newPaper = paper.map { it.map { it2 -> if (it2 == 1) '#' else " " } }
        newPaper[0].forEachIndexed { index, _ ->
            newPaper.forEach {
                print(it[index])
                print(" ")
            }
            println()
        }
    }
}