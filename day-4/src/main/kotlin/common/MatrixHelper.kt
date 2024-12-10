package ch.mvoirol.common

class MatrixHelper(
    private val matrix: List<List<Char>>,
) {
    fun getOrNull(
        row: Int,
        col: Int,
    ) = matrix.getOrNull(row)?.getOrNull(col)
}
