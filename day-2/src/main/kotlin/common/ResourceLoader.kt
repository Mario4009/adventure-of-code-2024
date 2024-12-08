package ch.mvoirol.common

import java.io.File

class ResourceLoader {
    private val filePath =
        object {}.javaClass.getResource("/input.txt")?.path
            ?: throw IllegalArgumentException("File not found!")

    val reports = mutableListOf<Report>()

    init {
        File(filePath).forEachLine { line ->
            val parts = line.trim().split(Regex("\\s+")).map { it.toInt() }
            reports.add(Report(parts))
        }
    }
}
