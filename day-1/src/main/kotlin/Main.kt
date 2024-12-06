package ch.mvoirol

import java.io.File
import kotlin.math.abs

fun main() {
    val filePath =
        object {}.javaClass.getResource("/input.txt")?.path
            ?: throw IllegalArgumentException("File not found!")

    val list1 = mutableListOf<Int>()
    val list2 = mutableListOf<Int>()

    File(filePath).forEachLine { line ->
        val parts = line.trim().split(Regex("\\s+"))
        if (parts.size == 2) {
            list1.add(parts[0].toInt())
            list2.add(parts[1].toInt())
        }
    }

    list1.sort()
    list2.sort()

    val diffs = mutableListOf<Int>()

    for (i in 0..999) {
        diffs.add(abs(list1[i] - list2[i]))
    }

    println("Result: ${diffs.sum()}")
}
