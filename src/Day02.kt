fun main() {
    fun part1(input: List<String>): Long {
        var result = 0L
        val ranges = extractRanges(input)
        ranges.forEach { range ->
            for (i in range){
                val string = i.toString()
                val firstHalf = string.take(string.length / 2)
                val secondHalf = string.drop(string.length / 2)
                if (firstHalf == secondHalf){
                    result += i
                }
            }
        }
        return result
    }

    fun part2(input: List<String>): Long {
        var result = 0L
        val ranges = extractRanges(input)
        ranges.forEach { range ->
            for (i in range) {
                if (isInvalid(i)){
                    result += i
                }
            }
        }
        return result
    }

    // Or read a large test input from the `src/Day02_test.txt` file:
    val testInput = readInput("Day02_test")
    check(part1(testInput) == 1227775554L)
    check(part2(testInput) == 4174379265L)

    // Read the input from the `src/Day02.txt` file.
    val input = readInput("Day02")
    part1(input).println()
    part2(input).println()
}

fun extractRanges(input: List<String>): List<LongRange> {
    return input[0].split(",").map { it.split("-")[0].toLong() .. it.split("-")[1].toLong() }
}

fun isInvalid(id: Long): Boolean {
    val s = id.toString()
    val n = s.length

    // Try every possible pattern length
    for (len in 1..n / 2) {
        if (n % len != 0) continue  // pattern must tile evenly

        val pattern = s.substring(0, len)
        val repeatCount = n / len

        // Build repeated string
        val built = pattern.repeat(repeatCount)

        if (built == s && repeatCount >= 2) {
            return true
        }
    }
    return false
}