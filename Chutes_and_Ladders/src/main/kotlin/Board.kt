import java.util.*

data class Board(val goal: Int, val redirects: Map<Int, Int>) {

    constructor(width: Int, height: Int, shorts: Collection<Connection>) :
            this(width * height, shorts.associate { it.fromPos to it.toPos })

    fun move(origin: Int, steps: Int): Int {
        val target = origin + steps
        if (target > goal) return origin
        return redirects[target] ?: target
    }

}

fun Board.findMinRolls(): Int {
    val reached = Array(goal) { false }
    val reachableFields = PriorityQueue<ReachableField> { l, r -> if (l.rolls == r.rolls) r.field - l.field else l.rolls - r.rolls }.apply { add(ReachableField(0, 0)) }
    while (!reachableFields.isEmpty()) {
        val reachedField = reachableFields.remove()
        for (i in 1..6) {
            val nextPosition = move(reachedField.field, i)
            if (nextPosition == goal) return reachedField.rolls + 1
            if (!reached[nextPosition - 1]) {
                reachableFields.add(ReachableField(nextPosition, reachedField.rolls + 1))
                reached[nextPosition - 1] = true
            }
        }
    }
    return -1
}

data class ReachableField(val field: Int, val rolls: Int)

data class Connection(val fromPos: Int, val toPos: Int)