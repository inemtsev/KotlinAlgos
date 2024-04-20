package org.eventslooped

class SortAndSearchProblems {
    fun binarySearch(collectionOfNum: IntArray, numToFind: Int): Int {
        if(collectionOfNum.isEmpty()) return -1
        if(collectionOfNum.size == 1 && collectionOfNum.first() != numToFind) return -1

        var leftIndex = 0
        var rightIndex = collectionOfNum.lastIndex

        while (leftIndex <= rightIndex) {
            val mid = (leftIndex + rightIndex) / 2

            if(collectionOfNum[mid] == numToFind) return mid
            else if(numToFind < collectionOfNum[mid]) rightIndex = mid - 1
            else leftIndex = mid + 1
        }

        return -1
    }

    /**
     * Sort smallest to largest, not very efficient
     */
    fun selectSort(collectionOfNum: IntArray): IntArray {
        val mutableInput = collectionOfNum.toMutableList()
        val newCollection = IntArray(mutableInput.size)

        var remainingNums = mutableInput.size - 1
        while (remainingNums >= 0) {
            var smallestNum = mutableInput.first()
            for (n in mutableInput) {
                if(n < smallestNum) smallestNum = n
            }

            val newCollectionIndex = (collectionOfNum.size - 1) - remainingNums
            newCollection[newCollectionIndex] = smallestNum
            mutableInput.remove(smallestNum)

            remainingNums--
        }

        return newCollection
    }
}
