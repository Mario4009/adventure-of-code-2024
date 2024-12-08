package ch.mvoirol.common

import kotlin.math.abs

data class Report(
    val numbers: List<Int>,
) {
    fun isValid(): Boolean {
        var tempValue: Int? = null

        // gap check
        numbers.forEach { currentValue ->
            val lastValue = tempValue
            tempValue = currentValue
            if (lastValue == null) {
                return@forEach
            }

            val gapValid = isGapValid(lastValue, currentValue)
            if (!gapValid) {
                return false
            }
        }

        // all increasing / decreasing
        tempValue = null
        var isIncreasing: Boolean? = null
        numbers.forEach { currentValue ->
            val lastValue = tempValue
            tempValue = currentValue
            if (lastValue == null) {
                return@forEach
            }

            if (isIncreasing == null) {
                isIncreasing = lastValue < currentValue
            } else {
                if (isIncreasing!! && lastValue > currentValue) {
                    return false
                } else if (!isIncreasing!! && lastValue < currentValue) {
                    return false
                }
            }
        }
        return true
    }

    private fun isGapValid(
        n1: Int,
        n2: Int,
    ): Boolean {
        val gap = abs(n1 - n2)
        return gap in 1..3
    }
}
