import java.util.*

fun Scanner.readBoards() = LinkedList<Board>().apply {
    do {
        add(readBoard())
        if (hasNextLine()) nextLine()
    } while (hasNextLine())
}

fun Scanner.readBoard(): Board {
    val whl = nextLine().split(" ")
    val shorts = ArrayList<Connection>()
    repeat(whl[2].toInt()) {
        nextLine().split(" ").let {
            when (it[0]) {
                "L" -> shorts.add(Connection(it[1].toInt(), it[2].toInt()))
                else -> shorts.add(Connection(it[2].toInt(), it[1].toInt()))
            }
        }
    }
    return Board(whl[0].toInt(), whl[1].toInt(), shorts)
}