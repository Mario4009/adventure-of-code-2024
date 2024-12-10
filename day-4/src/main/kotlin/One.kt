package ch.mvoirol

import ch.mvoirol.common.MatrixHelper
import ch.mvoirol.common.ResourceLoader

fun main() {
    val matrix = ResourceLoader().matrix
    val helper = MatrixHelper(matrix)

    var count = 0

    matrix.forEachIndexed { rowIndex, row ->
        row.forEachIndexed { colIndex, value ->
            if (value == 'X') {
                /**
                 * XMAS
                 */
                if (helper.getOrNull(rowIndex, colIndex + 1) == 'M' &&
                    helper.getOrNull(rowIndex, colIndex + 2) == 'A' &&
                    helper.getOrNull(rowIndex, colIndex + 3) == 'S'
                ) {
                    count++
                }

                /**
                 * X
                 *  M
                 *   A
                 *    S
                 */
                if (helper.getOrNull(rowIndex + 1, colIndex + 1) == 'M' &&
                    helper.getOrNull(rowIndex + 2, colIndex + 2) == 'A' &&
                    helper.getOrNull(rowIndex + 3, colIndex + 3) == 'S'
                ) {
                    count++
                }

                /**
                 * X
                 * M
                 * A
                 * S
                 */
                if (helper.getOrNull(rowIndex + 1, colIndex) == 'M' &&
                    helper.getOrNull(rowIndex + 2, colIndex) == 'A' &&
                    helper.getOrNull(rowIndex + 3, colIndex) == 'S'
                ) {
                    count++
                }

                /**
                 *    X
                 *   M
                 *  A
                 * S
                 */
                if (helper.getOrNull(rowIndex + 1, colIndex - 1) == 'M' &&
                    helper.getOrNull(rowIndex + 2, colIndex - 2) == 'A' &&
                    helper.getOrNull(rowIndex + 3, colIndex - 3) == 'S'
                ) {
                    count++
                }
            }

            if (value == 'S') {
                /**
                 * SAMX
                 */
                if (helper.getOrNull(rowIndex, colIndex + 1) == 'A' &&
                    helper.getOrNull(rowIndex, colIndex + 2) == 'M' &&
                    helper.getOrNull(rowIndex, colIndex + 3) == 'X'
                ) {
                    count++
                }

                /**
                 * S
                 *  A
                 *   M
                 *    X
                 */
                if (helper.getOrNull(rowIndex + 1, colIndex + 1) == 'A' &&
                    helper.getOrNull(rowIndex + 2, colIndex + 2) == 'M' &&
                    helper.getOrNull(rowIndex + 3, colIndex + 3) == 'X'
                ) {
                    count++
                }

                /**
                 * S
                 * A
                 * M
                 * X
                 */
                if (helper.getOrNull(rowIndex + 1, colIndex) == 'A' &&
                    helper.getOrNull(rowIndex + 2, colIndex) == 'M' &&
                    helper.getOrNull(rowIndex + 3, colIndex) == 'X'
                ) {
                    count++
                }

                /**
                 *    S
                 *   A
                 *  M
                 * X
                 */
                if (helper.getOrNull(rowIndex + 1, colIndex - 1) == 'A' &&
                    helper.getOrNull(rowIndex + 2, colIndex - 2) == 'M' &&
                    helper.getOrNull(rowIndex + 3, colIndex - 3) == 'X'
                ) {
                    count++
                }
            }
        }
    }
    println("Count: $count") // 2390
}
