package ch.mvoirol

import ch.mvoirol.common.Helper.Companion.isValid
import ch.mvoirol.common.ResourceLoader
import java.math.BigDecimal

fun main() {
    val resources = ResourceLoader()

    val res =
        resources.updates
            .mapNotNull { update ->
                if (isValid(update)) {
                    val centerIndex = BigDecimal(update.size / 2.0).toInt()
                    update[centerIndex]
                } else {
                    null
                }
            }.sum()
    println("Result: $res") // 7365
}
