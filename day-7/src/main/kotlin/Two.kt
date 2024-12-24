package ch.mvoirol

import ch.mvoirol.common.EquationHelper.Companion.calculateResultsSecond
import ch.mvoirol.common.ResourceLoader

fun main() {
    val equations = ResourceLoader().equations

    val res =
        equations
            .map { equation ->
                val results = calculateResultsSecond(equation.numbers.toMutableList())
                return@map if (results.contains(equation.testValue)) {
                    equation.testValue
                } else {
                    0
                }
            }.sum()

    println("Result: $res") // 340362529351427
}
