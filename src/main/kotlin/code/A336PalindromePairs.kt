package org.leetcode.code

class A336PalindromePairs {
    init {
        test()
    }

    private fun test() {
        val stringArray:Array<String> = arrayOf("abcd","dcba","lls","s","sssll")
        println(palindromePairs(stringArray))
        println(palindromePairs(arrayOf("bat","tab","cat")))
        println(palindromePairs(arrayOf("a","")))
    }

    private fun palindromePairs(words: Array<String>): List<List<Int>> {
        val wordIndexMap: HashMap<String, Int> = HashMap()
        for (index in words.indices) wordIndexMap[words[index]] = index
        //println(wordIndexMap)
        val answer: MutableList<List<Int>> = arrayListOf()
        words.forEach { word ->
            for (index in 0..word.lastIndex) {
                val frontWord = word.substring(0..index)
                //println("frontWord: $frontWord")
                val frontWordReversed = frontWord.reversed()
                val behindWord = word.substring((index + 1)..word.lastIndex)
                val behindWordReversed = behindWord.reversed()
                //println("behindWord: $behindWord")
                if (wordIndexMap.containsKey(frontWordReversed) && isPali(behindWord)){
                    if (wordIndexMap[word] != wordIndexMap[frontWordReversed]) {
                        answer.add(listOf(wordIndexMap[word]!!, wordIndexMap[frontWordReversed]!!))
                    }
                }
                if (wordIndexMap.containsKey(behindWordReversed) && isPali(frontWord)){
                    if (wordIndexMap[behindWordReversed] != wordIndexMap[word]!!) {
                        answer.add(listOf(wordIndexMap[behindWordReversed]!!, wordIndexMap[word]!!))
                        if (behindWord.isEmpty()) answer.add((listOf(wordIndexMap[word]!!, wordIndexMap[behindWord]!!)))
                    }
                }
                //println("------")
            }
        }
        return answer
    }

    private fun isPali(word: String): Boolean {
        val length = word.length
        for (index in 0 until length / 2) {
            if (word[index] != word[word.length - 1 - index]) return false
        }
        return true
    }
}