package ch.mvoirol.common

import ch.mvoirol.resources

class Helper {
    companion object {
        fun makeValid(update: List<Int>): MutableList<Int> {
            var newList = mutableListOf<Int>()

            update.forEach { updateItem ->
                val specificRules = resources.rules.filter { rule -> rule.first == updateItem }

                val listRules = specificRules.map { specificRule -> newList.indexOfFirst { it == specificRule.second } }.filter { it != -1 }
                if (listRules.isEmpty()) {
                    newList.add(updateItem)
                } else {
                    newList.add(listRules.min(), updateItem)
                }
            }

            if (!isValid(newList)) {
                newList = makeValid(newList)
            }

            return newList
        }

        fun isValid(update: List<Int>): Boolean {
            var valid = true

            resources.rules.forEach { rule ->
                val r1 = update.indexOf(rule.first)
                val r2 = update.indexOf(rule.second)

                if (r1 != -1 && r2 != -1) {
                    if (r1 > r2) {
                        valid = false
                    }
                }
            }
            return valid
        }
    }
}
