package ch.mvoirol

import java.io.File

class ResourceLoader {
    private val filePath =
        object {}.javaClass.getResource("/input.txt")?.path
            ?: throw IllegalArgumentException("File not found!")

    val list1 = mutableListOf<Int>()
    val list2 = mutableListOf<Int>()

    init {
        File(filePath).forEachLine { line ->
            val parts = line.trim().split(Regex("\\s+"))
            if (parts.size == 2) {
                list1.add(parts[0].toInt())
                list2.add(parts[1].toInt())
            }
        }
    }
}
