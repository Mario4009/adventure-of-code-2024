package ch.mvoirol

import ch.mvoirol.common.ResourceLoader

fun main() {
    val resources = ResourceLoader()

    val sum = resources.getMultiplications().sumOf { it.first * it.second }

    println("Result: $sum") // 181345830
}
