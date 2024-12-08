package ch.mvoirol.common

import java.io.File

class ResourceLoader {
    private val filePath =
        object {}.javaClass.getResource("/input.txt")?.path
            ?: throw IllegalArgumentException("File not found!")

    private val rawInput = File(filePath).readText()

    fun getMultiplications(): MutableList<Pair<Int, Int>> {
        val multiplications = mutableListOf<Pair<Int, Int>>()
        val ca = rawInput.toCharArray()
        ca.forEachIndexed { i, character ->
            if (character == 'm' && ca[i + 1] == 'u' && ca[i + 2] == 'l' && ca[i + 3] == '(') {
                val pattern = "\\(\\d{1,3},\\d{1,3}\\)(?s).*"
                val toCheck =
                    ca[i + 3].toString() +
                        ca[i + 4] +
                        ca[i + 5] +
                        ca[i + 6] +
                        ca[i + 7] +
                        ca[i + 8] +
                        ca[i + 9] +
                        ca[i + 10] +
                        ca[i + 11]

                if (toCheck.matches(pattern.toRegex())) {
                    toCheck
                        .replace("(", "")
                        .substring(0, toCheck.indexOfLast { it == ')' })
                        .replace(")", "")
                        .split(",")
                        .let {
                            multiplications.add(it[0].toInt() to it[1].toInt())
                        }
                }
            }
        }
        return multiplications
    }
}
