package org.leetcode.code

import kotlin.math.max

class A1235MaximumProfitInJobScheduling {
    init {
        test()
    }

    private fun test() {
        val startTimeArray = intArrayOf(1,1,1)
        val endTimeArray = intArrayOf(2,3,4)
        val profitArray = intArrayOf(5,6,4)
        println("Best profit: ${jobScheduling(startTimeArray, endTimeArray, profitArray)}")
    }

    fun jobScheduling(startTime: IntArray, endTime: IntArray, profit: IntArray): Int {
        val jobList: ArrayList<Job> = arrayListOf()
        val dp: Array<Int?> = arrayOfNulls(startTime.size)
        for (index in startTime.indices) {
            jobList.add(Job(startTime[index], endTime[index], profit[index]))
        }

        jobList.sortBy { it.endTime }

        dp[0] = jobList.first().profit

        for (index in 1..< jobList.size) {
            val previousJobIndex : Int = findPreviousNearestNonOverlappingJobIndex(jobList, index)
            val profitIncludeNow = jobList[index].profit + if (previousJobIndex != -1) dp[previousJobIndex]!! else 0
            val profitExcludeNow = dp[index - 1]!!
            dp[index] = max(profitExcludeNow, profitIncludeNow)
        }

        return dp.last()!!
    }

    private fun findPreviousNearestNonOverlappingJobIndex(jobList: ArrayList<Job>, index: Int): Int {
        var rightIndex = index - 1
        var leftIndex = 0
        var middleIndex = (leftIndex + rightIndex) / 2

        while (leftIndex <= rightIndex){
            if (jobList[middleIndex].endTime <= jobList[index].startTime){
                if (jobList[middleIndex + 1].endTime <= jobList[index].startTime){
                    leftIndex = middleIndex + 1
                } else {
                    return middleIndex
                }
            } else {
                rightIndex = middleIndex - 1
            }
            middleIndex = (leftIndex + rightIndex) / 2
        }
        return -1
    }

    data class Job(
        val startTime: Int,
        val endTime: Int,
        val profit: Int
    )
}