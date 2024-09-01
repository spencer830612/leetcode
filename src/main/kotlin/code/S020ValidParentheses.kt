package org.leetcode.code

import com.sun.source.doctree.SummaryTree
import java.util.Stack

class S020ValidParentheses {
    init {
        test()
    }

    private fun test() {
        val testString01 = "()"
        val test02 = "()[]{}"
        val test03 = "(]"
        val test04 = "([])"
        val test05 = "({["
        val test06 = ")"
        val test07 = "("
        val test08 = "(){}}{}"

        check(isValid(testString01))
        check(isValid(test02))
        check(!isValid(test03))
        check(isValid(test04))
        check(!isValid(test05))
        check(!isValid(test06))
        check(!isValid(test07))
        check(!isValid(test08))

    }

    fun isValid(s: String): Boolean {
        val leftSmallBracket = "("[0]
        val leftMiddelBracket = "["[0]
        val leftBigBracket = "{"[0]
        val rightSmallBracket = ")"[0]
        val rightMiddleBracket = "]"[0]
        val rightBigBracket = "}"[0]
        val charStack = Stack<Char>()

        for (index in s.indices){
            if (s[index] == rightSmallBracket){
                if (charStack.isEmpty() || charStack.peek() != leftSmallBracket){
                    return false
                }
                charStack.pop()
            } else if (s[index] == rightMiddleBracket){
                if (charStack.isEmpty() || charStack.peek() != leftMiddelBracket) return false
                charStack.pop()
            } else if (s[index] == rightBigBracket){
                if (charStack.isEmpty() || charStack.peek() != leftBigBracket) return false
                charStack.pop()
            }
            else {
                charStack.push(s[index])
            }
        }
        return charStack.isEmpty()
    }
}