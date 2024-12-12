package ch.mvoirol

import ch.mvoirol.common.Helper.Companion.isValid
import ch.mvoirol.common.Helper.Companion.makeValid
import ch.mvoirol.common.ResourceLoader
import java.math.BigDecimal

val resources = ResourceLoader()

fun main() {
    val res =
        resources.updates
            .mapNotNull { update ->
                if (!isValid(update)) {
                    makeValid(update)
                } else {
                    null
                }
            }.sumOf {
                val centerIndex = BigDecimal(it.size / 2.0).toInt()
                it[centerIndex]
            }

    println("Result: $res") // 5770
}
