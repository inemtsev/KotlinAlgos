package org.eventslooped.jmh

import org.eventslooped.StringProblems
import org.openjdk.jmh.annotations.*
import org.openjdk.jmh.infra.Blackhole

@State(Scope.Benchmark)
open class StringProblemsBenchmarks {
    @Benchmark
    @BenchmarkMode(Mode.Throughput)
    @Fork(3)
    @Warmup(iterations = 3)
    @Measurement(iterations = 10)
    fun testLongestSubString(bh: Blackhole) {
        val sut = StringProblems()
        for (testUnit in longestSubStringSamples) {
            val lengthOfSubString = sut.lengthOfLongestSubString(testUnit.first)
            bh.consume(lengthOfSubString)
        }
    }

    @Benchmark
    @BenchmarkMode(Mode.Throughput)
    @Fork(3)
    @Warmup(iterations = 3)
    @Measurement(iterations = 10)
    fun testLongestSubString2(bh: Blackhole) {
        val sut = StringProblems()
        for (testUnit in longestSubStringSamples) {
            val lengthOfSubString = sut.lengthOfLongestSubString2(testUnit.first)
            bh.consume(lengthOfSubString)
        }
    }

    val longestSubStringSamples = listOf(
        Pair("abcabcbb", 3),
        Pair("pwwkew", 3),
        Pair("GEEKSFORGEEKS", 7),
        Pair("ABCDEFGABEF", 7),
        Pair("bbbbb", 1),
        Pair("z", 1),
        Pair("abcaxyz", 6)
    )
}
