package ch.mvoirol.common

class EquationHelper {
    companion object {
        /**
         *
         * 2^3 = 8
         *
         * 1 + 2 + 3 + 4 -> 0
         * 1 + 2 + 3 * 4 -> 1
         * 1 + 2 * 3 + 4 -> 2
         * 1 + 2 * 3 * 4 -> 3
         * 1 * 2 + 3 + 4 -> 4
         * 1 * 2 + 3 * 4 -> 5
         * 1 * 2 * 3 + 4 -> 6
         * 1 * 2 * 3 * 4 -> 7
         */
        fun calculateResults(list: List<Long>): List<Long> {
            val optionCount = powerN(2, list.size)
            val results = mutableListOf<Long>()
            for (i in 0..<optionCount) {
                var current = 0L
                Integer.toBinaryString(i).toCharArray().forEachIndexed { index, char ->
                    if (char == '1') {
                        current += list[index]
                    } else {
                        current *= list[index]
                    }
                }
                results.add(current)
            }

            return results
        }

        /**
         *
         * 3^2 = 9
         *
         * 1 + 2 + 3 -> 0
         * 1 + 2 * 3 -> 1
         * 1 * 2 + 3 -> 2
         * 1 * 2 * 3 -> 3
         * 1 + 2 || 3 -> 4
         * 1 * 2 || 3 -> 5
         * 1 || 2 + 3 -> 6
         * 1 || 2 * 3 -> 7
         * 1 || 2 || 3 -> 8
         */

        private fun convertFromDecimalToBaseX(
            num: Int,
            newBase: Int,
        ): String {
            var num = num
            require(!((newBase < 2 || newBase > 10) && newBase != 16)) { "New base must be from 2 - 10 or 16" }
            var result: String? = ""
            var remainder: Int
            while (num > 0) {
                remainder = num % newBase
                if (newBase == 16) {
                    if (remainder == 10) {
                        result += 'A'
                    } else if (remainder == 11) {
                        result += 'B'
                    } else if (remainder == 12) {
                        result += 'C'
                    } else if (remainder == 13) {
                        result += 'D'
                    } else if (remainder == 14) {
                        result += 'E'
                    } else if (remainder == 15) {
                        result += 'F'
                    } else {
                        result += remainder
                    }
                } else {
                    result += remainder
                }
                num /= newBase
            }
            return StringBuffer(result).reverse().toString()
        }

        fun calculateResultsSecond(list: MutableList<Long>): List<Long> {
            val optionCount = powerN(3, list.size - 1)
            val results = mutableListOf<Long>()
            for (i in 0..<optionCount) {
                var current = list.first()
                val reducedList = list.toMutableList().also { it.removeAt(0) }
                var operationChain = convertFromDecimalToBaseX(i, 3)
                if (operationChain.length != list.size) {
                    for (counter in 0..<(reducedList.size - operationChain.length)) {
                        operationChain = "0$operationChain"
                    }
                }

                operationChain.toCharArray().forEachIndexed { index, char ->
                    when (char) {
                        '2' -> {
                            current = (current.toString() + reducedList[index]).toLong()
                        }

                        '1' -> {
                            current *= reducedList[index]
                        }

                        '0' -> {
                            current += reducedList[index]
                        }

                        else -> throw IllegalStateException("Unexpected character: $char")
                    }
                }

                results.add(current)
            }
            return results
        }

        fun powerN(
            number: Int,
            power: Int,
        ): Int {
            var power = power
            if (power == 0) return 1
            var result = number

            while (power > 1) {
                result *= number
                power--
            }

            return result
        }
    }
}
