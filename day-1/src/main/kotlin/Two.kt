package ch.mvoirol

fun main() {
    val resources = ResourceLoader()
    val res =
        resources.list1
            .associateBy({
                it
            }, { value ->
                resources.list2.filter { it == value }.size
            })
            .map { (key, value) ->
                key * value
            }.sum()

    println("Result: $res")
}
