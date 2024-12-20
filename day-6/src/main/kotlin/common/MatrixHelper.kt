package ch.mvoirol.common

class MatrixHelper(
    private val matrix: List<List<Char>>,
) {
    fun getOrNull(
        row: Int,
        col: Int,
    ) = matrix.getOrNull(row)?.getOrNull(col)

    fun findStart(): Pair<Direction, Position> {
        var currentPosition: Position = Position(-1, -1)
        var currentDirection: Direction? = null
        matrix.forEachIndexed { rowIndex, row ->
            row.forEachIndexed { columnIndex, char ->
                if (char == '<') {
                    currentPosition = Position(rowIndex, columnIndex)
                    currentDirection = Direction.LEFT
                }
                if (char == '^') {
                    currentPosition = Position(rowIndex, columnIndex)
                    currentDirection = Direction.UP
                }
                if (char == '>') {
                    currentPosition = Position(rowIndex, columnIndex)
                    currentDirection = Direction.RIGHT
                }
                if (char == 'v') {
                    currentPosition = Position(rowIndex, columnIndex)
                    currentDirection = Direction.DOWN
                }
            }
        }

        if (currentPosition == Position(-1, -1)) {
            throw IllegalStateException("Start not found")
        }

        return Pair(currentDirection!!, currentPosition)
    }

    fun findNextPosition(
        currentDirection: Direction,
        currentPosition: Position,
    ): Position =
        when (currentDirection) {
            Direction.UP -> {
                Position(currentPosition.row - 1, currentPosition.col)
            }
            Direction.RIGHT -> {
                Position(currentPosition.row, currentPosition.col + 1)
            }
            Direction.DOWN -> {
                Position(currentPosition.row + 1, currentPosition.col)
            }
            Direction.LEFT -> {
                Position(currentPosition.row, currentPosition.col - 1)
            }

            null -> throw IllegalStateException("No direction set")
        }
}
