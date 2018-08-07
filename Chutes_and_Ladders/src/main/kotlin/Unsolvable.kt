import java.io.File
import java.util.*

fun main(args: Array<String>) {
    println("Unresolvable boards using findMinRolls: ${sumUpUnresolvable { board -> board.findMinRolls() == -1 }}")
    println("Unresolvable boards using isSolvable: ${sumUpUnresolvable { board -> !board.isSolvable() }}")
}

fun sumUpUnresolvable(method: (Board) -> Boolean): Int {
    var sum = 0
    Scanner(File("chutes_and_ladders.txt")).readBoards().forEach { board ->
        if (method.invoke(board)) sum++
    }
    return sum
}

fun Board.isSolvable(): Boolean {
    if (move(goal, 0) != goal && redirects.values.find { it == goal } == null) return false
    for (i in 1..6) {
        val preGoal = goal - i
        if (move(preGoal, 0) == preGoal || redirects.values.find { it == preGoal } == null) return true
    }
    return false
}