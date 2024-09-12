package org.leetcode.code

import java.util.*

class S394DecodeString {
    init {
        init()
    }
    private fun init(){
        val test01 = "3[a]2[bc]"
        val test02 = "3[a2[c]]"
        val test03 = "2[abc]3[cd]ef"
        val test04 = "10[a]"
        check(decodeString(test01) == "aaabcbc")
        check(decodeString(test02) == "accaccacc")
        check(decodeString(test03) == "abcabccdcdcdef")
        check(decodeString(test04) == "aaaaaaaaaa")
    }
    private fun decodeString(s: String): String {
        val charList : Stack<String> = Stack()
        val leftBrace = "["
        val rightBrace = "]".toCharArray()[0]
        for (char in s){
            if (char != rightBrace){
                //println(charList)
                charList.push(char.toString())
            } else {
                var stringSeg = ""
                while (charList.peek() != leftBrace){
                    //println(charList)
                    stringSeg = charList.pop() + stringSeg
                }
                charList.pop()
                var numString = ""
                while (!charList.isEmpty() && charList.peek() >= "0" && charList.peek() <= "9") {
                    numString = charList.pop() + numString
                }
                //println(charList)
                val number = numString.toInt()
                var stringChain = ""
                for (i in 0 until number) {
                    //println(stringChain)
                    stringChain += stringSeg
                }
                //println(stringChain)
                charList.push(stringChain)
                //println(charList)
            }
        }
        var answer = ""
        for (string in charList){
            answer += string
        }
        return answer
    }
}