package ch.mvoirol

import kotlin.math.abs

fun main() {
    val resources = ResourceLoader()

    val diffs = mutableListOf<Int>()

    val list1Sorted = resources.list1.sorted()
    val list2Sorted = resources.list2.sorted()

    for (i in 0..999) {
        diffs.add(abs(list1Sorted[i] - list2Sorted[i]))
    }

    println("Result: ${diffs.sum()}")
}
