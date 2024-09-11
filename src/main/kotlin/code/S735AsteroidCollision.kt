package org.leetcode.code

import java.util.*

class S735AsteroidCollision {
    init {
        val test01 = intArrayOf(5, 10, -5)
        val test02 = intArrayOf(8, -8)
        val test03 = intArrayOf(10, 2, -5)
        val test04 = intArrayOf(-5, 10, 2)
        val test05 = intArrayOf(-2,-1,1,2)
        val test06 = intArrayOf(-2,-2,1,-1)
        val test07 = intArrayOf(-2,-2,1,-2)
        check(asteroidCollision(test01).contentEquals(intArrayOf(5, 10)))
        check(asteroidCollision(test02).contentEquals(intArrayOf()))
        check(asteroidCollision(test03).contentEquals(intArrayOf(10)))
        check(asteroidCollision(test04).contentEquals(intArrayOf(-5, 10, 2)))
        check(asteroidCollision(test05).contentEquals(intArrayOf(-2,-1,1,2)))
        check(asteroidCollision(test06).contentEquals(intArrayOf(-2,-2)))
        check(asteroidCollision(test07).contentEquals(intArrayOf(-2,-2, -2)))
    }

    private fun asteroidCollision(asteroids: IntArray): IntArray {
        val stack = Stack<Int>()
        for (number in asteroids) {
            if (stack.isEmpty()) {
                stack.push(number)
                continue
            }

            if (number < 0) {
                var isPush = true
                while (!stack.isEmpty() && stack.peek() >= 0) {
                    if (stack.peek() < -number) {
                        stack.pop()
                    } else if (stack.peek() == -number) {
                        isPush = false
                        stack.pop()
                        break
                    } else if (stack.peek() > -number) {
                        isPush = false
                        break
                    }
                }
                if (isPush){
                    stack.push(number)
                }
            } else {
                stack.push(number)
            }
        }
        val length = stack.size
        val answer = IntArray(length)
        for (i in 0 until length){
            answer[i] = stack[i]
        }
        return answer
    }
}