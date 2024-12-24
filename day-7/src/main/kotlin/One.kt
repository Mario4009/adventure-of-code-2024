package ch.mvoirol

import ch.mvoirol.common.EquationHelper.Companion.calculateResults
import ch.mvoirol.common.ResourceLoader

fun main() {
    val equations = ResourceLoader().equations

    val res =
        equations
            .map { equation ->
                val results = calculateResults(equation.numbers)
                return@map if (results.contains(equation.testValue)) {
                    equation.testValue
                } else {
                    0
                }
            }.sum()

    println("Result: $res") // 3598800864292
}
