package ch.mvoirol

import ch.mvoirol.common.ResourceLoader

fun main() {
    val resources = ResourceLoader()

    val sum = resources.getMultiplications(true).sumOf { it.first * it.second }

    println("Result: $sum") // 98729041
}
