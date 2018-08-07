import org.junit.Assert.*
import org.junit.Test
import java.io.File
import java.util.*

private const val firstBoard = """10 10 19
L 1 38
L 4 14
C 6 16
L 9 31
C 11 49
C 19 62
L 21 42
C 24 87
C 26 47
L 28 84
L 36 44
L 51 67
C 53 56
C 60 64
L 71 91
C 73 93
C 75 95
C 78 98
L 80 100"""

private const val unsolvableBoard = """3 7 6
C 6 9
C 5 10
C 4 11
C 3 12
C 2 13
C 1 14"""

class BoardTest {

    @Test
    fun `findMinRolls returns 7 for first board`() {
        val board = Scanner(firstBoard).readBoard()
        assertEquals(7, board.findMinRolls())
    }

    @Test
    fun `findMinRolls returns -1 if board is not solvable`() {
        Scanner(File("chutes_and_ladders.txt")).readBoards().forEachIndexed { index, board ->
            val solvable = board.isSolvable()
            val minRolls = board.findMinRolls()
            if (!solvable) assertEquals("$index minRolls: $minRolls $board", -1, minRolls)
        }
    }

    @Test
    fun `solvable returns false if board minRolls is -1`() {
        Scanner(File("chutes_and_ladders.txt")).readBoards().forEachIndexed { index, board ->
            val solvable = board.isSolvable()
            val minRolls = board.findMinRolls()
            if (minRolls == -1) assertEquals("$index minRolls: $minRolls $board", false, solvable)
        }
    }

    @Test
    fun `solvable returns true even if board is not solvable`() {
        val board = Scanner(unsolvableBoard).readBoard()
        assertEquals(-1, board.findMinRolls())
        assertTrue(board.isSolvable())
    }

}