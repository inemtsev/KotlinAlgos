import org.eventslooped.SortAndSearchProblems
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class SortAndSortProblemsTests {
    @ParameterizedTest
    @MethodSource("binarySearchValidInputs")
    fun `binarySearch SHOULD return correct position GIVEN valid inputs`(collection: IntArray, num: Int, answer: Int) {
        val sut = SortAndSearchProblems()
        val result = sut.binarySearch(collection, num)

        assert(result == answer)
    }

    @ParameterizedTest
    @MethodSource("binarySearchInvalidInputs")
    fun `binarySearch SHOULD return -1 GIVEN invalid inputs`(collection: IntArray, num: Int) {
        val sut = SortAndSearchProblems()
        val result = sut.binarySearch(collection, num)

        assert(result == -1)
    }

    @Test
    fun `selectSort SHOULD return correctly sorted numbers GIVEN non-empty array`() {
        val testNumbers = intArrayOf(7, 13, 2, 5, 1, 3, 1, 21, 10)

        val sut = SortAndSearchProblems()
        val result = sut.selectSort(testNumbers)

        val validResult = testNumbers.sortedArray()

        assert(result.contentEquals(validResult))
    }

    private fun binarySearchInvalidInputs() = listOf(
        Arguments.of(intArrayOf(), 9),
        Arguments.of(intArrayOf(0, 2, 4, 6, 8, 10, 12, 14, 16), 9),
        Arguments.of(intArrayOf(0, 2, 4, 6, 8, 10, 12, 14, 16, 18), 9)
    )

    private fun binarySearchValidInputs() = listOf(
        Arguments.of(intArrayOf(0, 2, 4, 6, 8, 10, 12, 14, 16), 0, 0),
        Arguments.of(intArrayOf(0, 2, 4, 6, 8, 10, 12, 14, 16), 16, 8),
        Arguments.of(intArrayOf(0, 2, 4, 6, 8, 10, 12, 14, 16), 8, 4),
        Arguments.of(intArrayOf(0, 10, 200, 3000, 40000, 500000, 6000000), 200, 2),
        Arguments.of(intArrayOf(0, 10, 200, 3000, 40000, 500000, 6000000, 70000000), 500000, 5),
        Arguments.of(intArrayOf(0, 10, 200, 3000, 40000, 500000, 6000000, 70000000), 3000, 3),
    )
}
