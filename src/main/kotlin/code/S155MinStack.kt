package org.leetcode.code

import java.util.Stack
import kotlin.math.min

class S155MinStack {
    init {

    }
    private val stack: Stack<StackAndMin> = Stack()

    fun init (){

    }
    fun push(`val`: Int) {
        val previousMin = if(stack.isEmpty) `val` else stack.peek().minToNow
        val min = min(`val`, previousMin)
        val stackElement = StackAndMin(`val`, min)
        stack.push(stackElement)
    }

    fun pop() {
        stack.pop()
    }

    fun top(): Int {
        return stack.peek().number
    }

    fun getMin(): Int {
        return stack.peek().minToNow
    }

    data class StackAndMin(
        val number: Int,
        val minToNow: Int
    )
}