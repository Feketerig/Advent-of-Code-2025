fun main() {
    fun part1(input: List<String>): Int {
        val part01 = Part01(50, 100)
        input.forEach {
            part01.move(it)
        }
        return part01.solution
    }

    fun part2(input: List<String>): Int {
        val part02 = Part02(50, 100)
        input.forEach {
            part02.move(it)
        }
        return part02.solution
    }

    // Or read a large test input from the `src/Day01_test.txt` file:
    val testInput = readInput("Day01_test")
    check(part1(testInput) == 3)
    check(part2(testInput) == 6)

    // Read the input from the `src/Day01.txt` file.
    val input = readInput("Day01")
    part1(input).println()
    part2(input).println()
}

class Part01(val start: Int, val maxNumber: Int){
    var currentNumber = start
    var solution = 0

    fun move(string: String){
        val direction = string.take(1)
        val distance = string.drop(1).toInt()

        if (direction == "L"){
            currentNumber -= distance
        }else{
            currentNumber += distance
        }

        currentNumber += maxNumber
        currentNumber %= maxNumber

        if (currentNumber == 0){
            solution++
        }
    }
}

class Part02(val start: Int, val maxNumber: Int){
    var currentNumber = start
    var solution = 0

    fun move(string: String){
        val direction = string.take(1)
        val distance = string.drop(1).toInt()

        for(i in 0..< distance){
            if (direction == "L"){
                currentNumber -= 1
            }else{
                currentNumber += 1
            }
            currentNumber += maxNumber
            currentNumber %= maxNumber
            if (currentNumber == 0){
                solution++
            }
        }
    }
}
