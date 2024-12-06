package ch.mvoirol

import ch.mvoirol.common.ResourceLoader

fun main() {
    val resources = ResourceLoader()
    val res =
        resources.list1
            .map { value ->
                Pair(value, resources.list2.filter { it == value }.size)
            }.sumOf { (first, second) ->
                first * second
            }

    println("Result: $res")
}
