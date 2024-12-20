package ch.mvoirol

import ch.mvoirol.common.*

fun main() {
    val matrix = ResourceLoader().matrix

    val obstructionPositions = mutableSetOf<Position>()

    matrix.forEachIndexed { rowIndex, row ->
        row.forEachIndexed { colIndex, charAtPosition ->
            if (charAtPosition == '.') {
                val modifiedMatrix = matrix.map { it.toMutableList() }.toMutableList()
                modifiedMatrix.getOrNull(rowIndex)?.removeAt(colIndex)
                modifiedMatrix.getOrNull(rowIndex)?.add(colIndex, '#')
                val matrixHelper = MatrixHelper(modifiedMatrix)

                val found = matrixHelper.findStart()

                val visitedPositions = mutableSetOf<Position>()
                var currentPosition = found.second
                var currentDirection = found.first

                val hits = mutableSetOf<Pair<Direction, Position>>()

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
                        if (hits.contains(Pair(currentDirection, currentPosition))) {
                            obstructionPositions.add(Position(rowIndex, colIndex))
                            println("Done with $rowIndex $colIndex")
                            break
                        }
                        hits.add(Pair(currentDirection, currentPosition))
                        currentDirection = currentDirection.next()
                    } else if (nextChar == '.') {
                        currentPosition = nextPosition
                    } else if (nextChar == '^') {
                        currentPosition = nextPosition
                    }
                }
            }
        }
    }
    println("Result: ${obstructionPositions.size}") // 1933
}
