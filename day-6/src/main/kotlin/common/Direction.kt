package ch.mvoirol.common

enum class Direction {
    UP,
    DOWN,
    LEFT,
    RIGHT,
}

fun Direction.next(): Direction =
    when (this) {
        Direction.UP -> {
            Direction.RIGHT
        }
        Direction.RIGHT -> {
            Direction.DOWN
        }
        Direction.DOWN -> {
            Direction.LEFT
        }
        Direction.LEFT -> {
            Direction.UP
        }
    }
