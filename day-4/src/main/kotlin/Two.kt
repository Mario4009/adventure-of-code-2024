package ch.mvoirol

import ch.mvoirol.common.MatrixHelper
import ch.mvoirol.common.ResourceLoader

fun main() {
    val matrix = ResourceLoader().matrix
    val helper = MatrixHelper(matrix)

    var count = 0

    matrix.forEachIndexed { rowIndex, row ->
        row.forEachIndexed { colIndex, value ->
            if (value == 'A') {
                /**
                 * M M
                 *  A
                 * s S
                 */
                if (helper.getOrNull(rowIndex - 1, colIndex - 1) == 'M' &&
                    helper.getOrNull(rowIndex - 1, colIndex + 1) == 'M' &&
                    helper.getOrNull(rowIndex + 1, colIndex - 1) == 'S' &&
                    helper.getOrNull(rowIndex + 1, colIndex + 1) == 'S'
                ) {
                    count++
                }

                /**
                 * M S
                 *  A
                 * M S
                 */
                if (helper.getOrNull(rowIndex - 1, colIndex - 1) == 'M' &&
                    helper.getOrNull(rowIndex - 1, colIndex + 1) == 'S' &&
                    helper.getOrNull(rowIndex + 1, colIndex - 1) == 'M' &&
                    helper.getOrNull(rowIndex + 1, colIndex + 1) == 'S'
                ) {
                    count++
                }

                /**
                 * S M
                 *  A
                 * S M
                 */
                if (helper.getOrNull(rowIndex - 1, colIndex - 1) == 'S' &&
                    helper.getOrNull(rowIndex - 1, colIndex + 1) == 'M' &&
                    helper.getOrNull(rowIndex + 1, colIndex - 1) == 'S' &&
                    helper.getOrNull(rowIndex + 1, colIndex + 1) == 'M'
                ) {
                    count++
                }

                /**
                 * S S
                 *  A
                 * M M
                 */
                if (helper.getOrNull(rowIndex - 1, colIndex - 1) == 'S' &&
                    helper.getOrNull(rowIndex - 1, colIndex + 1) == 'S' &&
                    helper.getOrNull(rowIndex + 1, colIndex - 1) == 'M' &&
                    helper.getOrNull(rowIndex + 1, colIndex + 1) == 'M'
                ) {
                    count++
                }
            }
        }
    }
    println("Count: $count")
}
