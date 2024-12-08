import kotlin.test.Test
import kotlin.test.assertTrue

class CheckRegex {
    @Test
    fun test() {
        val pattern = "\\(\\d{1,3},\\d{1,3}\\)(?s).*".toRegex()

        assertTrue { "(525,81)\r".matches(pattern) }
    }
}
