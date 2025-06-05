package postupashki.telegram.`наибольший общий префикс`

fun main(){
    fun helper(input: List<String>): IntArray {
        val n = input.size
        val ans = IntArray(n){-1}

        val newInput = mutableListOf<Pair<String,Int>>()

        for (i in 0 until n){
            newInput.add(Pair(input[i], i))
        }

        newInput.sortBy{it.first}

        fun findCommon(first: String, second: String): Int {
            var counter = 0

            for (i in 0 until minOf(first.length, second.length)){
                if (first[i] == second[i]){
                    counter++
                } else {
                    break
                }
            }
            return counter
        }

        for (i in 0 until n){
            val curStr = newInput[i].first
            val curIndex = newInput[i].second

            var maxCommon = 0
            var bestIdx = -1

            if (i > 0){
                val common = findCommon(curStr, newInput[i - 1].first)
                if (common > maxCommon){
                    maxCommon = common
                    bestIdx = newInput[i - 1].second
                }
            }
            if (i < n - 1){
                val common = findCommon(curStr, newInput[i + 1].first)
                if (common > maxCommon){
                    maxCommon  = common
                    bestIdx = newInput[i + 1].second
                }
            }
            ans[curIndex] = bestIdx
        }

        return ans
    }

    val input = listOf("apple", "apricot", "banana", "bandana", "apex")
    val result = helper(input)
    println(result.joinToString())
}