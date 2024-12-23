package ch.mvoirol.common

import java.io.File

class ResourceLoader {
    private val filePath =
        object {}.javaClass.getResource("/input.txt")?.path
            ?: throw IllegalArgumentException("File not found!")

    val equations = mutableListOf<Equation>()

    init {
        File(filePath).forEachLine { line ->
            val firstSplit = line.split(":")
            val testValue = firstSplit[0].toLong()
            val numbers = firstSplit[1].trim().split(" ").map { it.toLong() }
            equations.add(Equation(testValue, numbers))
        }
    }
}
