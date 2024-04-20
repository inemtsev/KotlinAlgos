package org.eventslooped

import java.security.InvalidAlgorithmParameterException

class StringProblems {
    /**
     * Length of longest substring without repeating characters
     */
    fun lengthOfLongestSubString(s: String): Int {
        if(s.isEmpty()) return 0
        if(s.length == 1) return 1

        var currString = s.first().toString()
        var maxLength = 1

        for(i in 1..s.lastIndex) {
            if(currString.contains(s[i])) {
                val indexFound = currString.indexOf(s[i])
                currString = currString.substring(indexFound+1)
            }

            currString += s[i]

            maxLength = maxLength.coerceAtLeast(currString.length)
        }

        return maxLength
    }

    /**
     * Length of longest substring without repeating characters, using Map
     */
    fun lengthOfLongestSubString2(s: String): Int {
        if(s.isEmpty()) return 0
        if(s.length == 1) return 1

        val charSeenMap = mutableMapOf<Char, Int>()
        var startIndex = 0
        var longestSubString = 1

        for(i in 0..s.lastIndex) {
            if(charSeenMap.containsKey(s[i])) {
                val lastSeenIndex = charSeenMap[s[i]] ?: throw InvalidAlgorithmParameterException()
                for (j in startIndex..lastSeenIndex) {
                    charSeenMap.remove(s[j])
                }

                startIndex = lastSeenIndex + 1
            }

            longestSubString = longestSubString.coerceAtLeast((i - startIndex) + 1)

            charSeenMap[s[i]] = i
        }

        return longestSubString
    }
}