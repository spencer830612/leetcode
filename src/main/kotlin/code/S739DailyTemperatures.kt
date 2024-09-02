package org.leetcode.code

import java.util.Stack

class S739DailyTemperatures {

    init {
        val test01 = intArrayOf(1,2,3)
        val answer01 = intArrayOf(1,1,0)
        val test02 = intArrayOf(73,74,75,71,69,72,76,73)
        val answer02 = intArrayOf(1,1,4,2,1,1,0,0)
        val test03 = intArrayOf(30,40,50,60)
        val answer03 = intArrayOf(1,1,1,0)
        val test04 = intArrayOf(60,50,40,30)
        val answer04 = intArrayOf(0,0,0,0)
        val test05 = intArrayOf(30,40,50,60,50,40,30)
        val answer05 = intArrayOf(1,1,1,0,0,0,0)
        check(answer01.contentEquals(dailyTemperatures(test01)))
        check(answer02.contentEquals(dailyTemperatures(test02)))
        check(answer03.contentEquals(dailyTemperatures(test03)))
        check(answer04.contentEquals(dailyTemperatures(test04)))
        check(answer05.contentEquals(dailyTemperatures(test05)))
    }
    fun dailyTemperatures(temperatures: IntArray): IntArray {
        val length = temperatures.size
        val answer = IntArray(length)

        val stack: Stack<StackElement> = Stack()

        for (i in 0 until length){
            var top = if(stack.isEmpty()) null else stack.peek()
            val days = (top?.day ?: 0) + 1
            while (top != null && temperatures[top.index] < temperatures[i]){
                answer[top.index] = days - top.day
                stack.pop()
                top = if(stack.isEmpty()) null else stack.peek()
            }

            val element = StackElement(i, days)
            stack.push(element)
        }
        if (!stack.isEmpty()) {
            for (element in stack){
                answer[element.index] = 0
            }
        }
        return answer
    }

    class StackElement(
        val index: Int,
        val day: Int
    )
}