package org.leetcode.code

import java.util.Stack

class S232ImplementQueueUsingStacks {

    init {
        val queue = MyQueue()

    }

    class MyQueue() {
        private val pushStack = Stack<Int>()
        private val popStack = Stack<Int>()

        fun push(x: Int) {
            if (pushStack.isEmpty()) popStackToPushStack()
            pushStack.push(x)
        }

        fun pop(): Int {
            if (popStack.isEmpty()) pushStackToPopStack()
            return popStack.pop()
        }

        fun peek(): Int {
            if (popStack.isEmpty()) pushStackToPopStack()
            return popStack.peek()
        }

        fun empty(): Boolean {
            return popStack.isEmpty() && pushStack.isEmpty()
        }

        private fun pushStackToPopStack(){
            while (!popStack.isEmpty()){
                popStack.push(pushStack.pop())
            }
        }

        private fun popStackToPushStack(){
            while (!pushStack.isEmpty()){
                pushStack.push(popStack.pop())
            }
        }

    }
}