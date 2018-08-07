import java.io.File
import java.util.*

fun main(args: Array<String>) {
    println("Sum of minimum rolls: ${sumUpMinimumRolls()}")
}

private fun sumUpMinimumRolls(): Int {
    var sum = 0
    Scanner(File("chutes_and_ladders.txt")).readBoards().forEach { board ->
        board.findMinRolls().let { if(it != -1) sum += it}
    }
    return sum
}