package ch.mvoirol

import ch.mvoirol.common.MatrixHelper
import ch.mvoirol.common.Position
import ch.mvoirol.common.ResourceLoader
import ch.mvoirol.common.next

fun main() {
    val matrix = ResourceLoader().matrix
    val matrixHelper = MatrixHelper(matrix)

    val found = matrixHelper.findStart()

    val visitedPositions = mutableSetOf<Position>()
    var currentPosition = found.second
    var currentDirection = found.first

    if (currentPosition == Position(-1, -1)) {
        throw IllegalStateException("Start not found")
    }
    while (true) {
        visitedPositions.add(currentPosition)
        val nextPosition = matrixHelper.findNextPosition(currentDirection, currentPosition)

        val nextChar = matrixHelper.getOrNull(nextPosition.row, nextPosition.col)
        if (nextChar == null) {
            break
        } else if (nextChar == '#') {
            currentDirection = currentDirection.next()
        } else if (nextChar == '.') {
            currentPosition = nextPosition
        }
    }

    println("Result: ${visitedPositions.size}") // 5095
}
