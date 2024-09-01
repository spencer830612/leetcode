package org.leetcode.code

import java.util.Stack

class S150EvaluateReversePolishNotation {

    init {
        test()
    }

    private fun test(){
        val token01 = arrayOf("1", "2", "+")
        val token02 = arrayOf("2", "1", "+", "3", "*")
        val token03 = arrayOf("4","13","5","/","+")
        check(evalRPN(token01) == 3)
        check(evalRPN(token02) == 9)
        check(evalRPN(token03) == 6)
    }

    fun evalRPN(tokens: Array<String>): Int {
        val stack = Stack<String>()
        val operateSet: Set<String> = setOf("+","-","*","/")
        for (token in tokens){
            if (operateSet.contains(token)) {
                val result = calculate(stack.pop(), stack.pop(), token)
                stack.push(result)
            } else {
                stack.push(token)
            }
        }
        return if (stack.size == 1) stack.pop().toInt()
        else -1
    }

    private fun calculate(top: String, down: String, operate: String): String{
        val downNumber = down.toInt()
        val topNumber = top.toInt()
        val value = when (operate){
            "+" -> downNumber + topNumber
            "-" -> downNumber - topNumber
            "*" -> downNumber * topNumber
            "/" -> downNumber / topNumber
            else -> 0
        }
        return value.toString()
    }
}