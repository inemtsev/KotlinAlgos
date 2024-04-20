import org.eventslooped.StringProblems
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class StringProblemsTests {
    @ParameterizedTest
    @MethodSource("lengthOfLongestSubStringParams")
    fun `lengthOfLongestSubString SHOULD return valid answer WHEN non-empty string`(s: String, result: Int) {
        val sut = StringProblems()

        assert(sut.lengthOfLongestSubString(s) == result)
    }

    @ParameterizedTest
    @MethodSource("lengthOfLongestSubStringParams")
    fun `lengthOfLongestSubString2 SHOULD return valid answer WHEN non-empty string`(s: String, result: Int) {
        val sut = StringProblems()

        assert(sut.lengthOfLongestSubString2(s) == result)
    }

    private fun lengthOfLongestSubStringParams() =
        listOf(
            Arguments.of("abcabcbb", 3),
            Arguments.of("pwwkew", 3),
            Arguments.of("GEEKSFORGEEKS", 7),
            Arguments.of("ABCDEFGABEF", 7),
            Arguments.of("bbbbb", 1),
            Arguments.of("z", 1),
            Arguments.of("abcaxyz", 6)
        )
}