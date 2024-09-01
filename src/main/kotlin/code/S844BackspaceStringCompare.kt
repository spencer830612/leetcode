package org.leetcode.code

import java.awt.datatransfer.StringSelection
import java.util.Stack

class S844BackspaceStringCompare {
    init {
        test()
    }

    private fun test(){
        val s1 = "ab#c"
        val t1 = "ad#c"
        val s2 = "ab##"
        val t2 = "c#d#"
        val s3 = "a#c"
        val t3 = "b"
        val s4 = "ab###"
        val t4 = "c##d##"
        val s5 = "bxj##tw"
        val t5 = "bxo#j##tw"

        check(backspaceCompare(s1,t1))
        check(backspaceCompare(s2,t2))
        check(!backspaceCompare(s3,t3))
        check(backspaceCompare(s4,t4))
        check(backspaceCompare(s5, t5))
    }

    private fun backspaceCompare(s: String, t: String): Boolean {
        val stringStack = arrayListOf<Char>()
        val deleteChar = "#"[0]
        for (char in s){
            if (char == deleteChar){
                if (stringStack.isNotEmpty()) stringStack.removeLast()
            } else {
                stringStack.add(char)
            }
        }
        var index = t.length - 1
        while (index >= 0){
            if (stringStack.isEmpty()){
                stringStack.add(t[index])
            } else if (stringStack.last() == t[index]){
                if (stringStack.last() != deleteChar) stringStack.removeLast()
                else stringStack.add(t[index])
            } else {
                if (stringStack.last() != deleteChar) stringStack.add(t[index])
                else stringStack.removeLast()
            }
            index --
        }
        while (stringStack.isNotEmpty() && stringStack.last() == deleteChar) stringStack.removeLast()
        return stringStack.isEmpty()
    }
}