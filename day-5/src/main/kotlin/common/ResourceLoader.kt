package ch.mvoirol.common

import java.io.File

class ResourceLoader {
    private val filePath =
        object {}.javaClass.getResource("/input.txt")?.path
            ?: throw IllegalArgumentException("File not found!")

    val rules = mutableListOf<Pair<Int, Int>>()
    val updates = mutableListOf<List<Int>>()

    init {
        var mode = Section.RULES
        File(filePath).forEachLine { line ->
            if (line.isBlank()) {
                mode = Section.UPDATES
                return@forEachLine
            }
            if (mode == Section.RULES) {
                val parts = line.trim().split("|")
                if (parts.size != 2) {
                    throw IllegalArgumentException("Input line is not a valid input!")
                } else {
                    rules.add(Pair(parts[0].toInt(), parts[1].toInt()))
                }
            }
            if (mode == Section.UPDATES) {
                val parts = line.trim().split(",").map { it.toInt() }
                updates.add(parts)
            }
        }
    }
}

enum class Section {
    RULES,
    UPDATES,
}
