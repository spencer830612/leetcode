package org.leetcode.code

class S844BackspaceStringCompare02 {
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

    fun backspaceCompare(s: String, t: String): Boolean {
        val sStack = arrayListOf<Char>()
        val tStack = arrayListOf<Char>()
        val deleteChar = "#"[0]
        for (char in s){
            if (char == deleteChar){
                if (sStack.isNotEmpty()) sStack.removeLast()
            } else {
                sStack.add(char)
            }
        }
        for (char in t){
            if (char == deleteChar){
                if (tStack.isNotEmpty()) tStack.removeLast()
            } else {
                tStack.add(char)
            }
        }
        if (sStack.size != tStack.size) return false
        while (sStack.isNotEmpty()) {
            val sChar = sStack.last()
            val tChar = tStack.last()
            if (sChar != tChar) return false
            sStack.removeLast()
            tStack.removeLast()
        }
        return true
    }
}