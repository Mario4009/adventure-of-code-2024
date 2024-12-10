package ch.mvoirol.common

import java.io.File

class ResourceLoader {
    private val filePath =
        object {}.javaClass.getResource("/input.txt")?.path
            ?: throw IllegalArgumentException("File not found!")

    val matrix = mutableListOf<MutableList<Char>>()

    init {
        var lineIndex = 0
        File(filePath).forEachLine { line ->
            matrix.add(lineIndex, mutableListOf())
            line.forEach { matrix[lineIndex].add(it) }
            lineIndex++
        }
    }
}
