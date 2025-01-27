package leetcode.contests.weekly434
//3433. Count Mentions Per User
fun main(){

    class Solution {
        fun countMentions(numberOfUsers: Int, events: List<List<String>>): IntArray {
            val n = numberOfUsers

            val online = mutableSetOf<Int>()

            val offline = mutableMapOf<Int, Int>()

            for (i in 0 until n){
                online.add(i)
            }

            val sortedEvents = events.sortedWith(
                compareBy({it[1].toInt()},{if (it[0] == "OFFLINE") 0 else 1})
            )
            val ans = IntArray(n)

            for (event in sortedEvents){
                when(event[0]){
                    "MESSAGE" -> {
                        when (event[2]) {
                            "ALL" -> {
                                for (i in 0 until n){
                                    ans[i]++
                                }
                            }
                            "HERE" -> {
                                val time = event[1].toInt()

                                val toRemove = mutableListOf<Int>()
                                for ((user, timer) in offline){
                                    if (timer <= time){
                                        online.add(user)
                                        toRemove.add(user)
                                    }
                                }
                                toRemove.forEach{
                                    offline.remove(it)
                                }

                                online.forEach{
                                    ans[it]++
                                }
                            }
                            else -> {
                                val users = event[2].split(" ").map{it.replace("id", "").toInt()}
                                for (id in users){
                                    ans[id]++
                                }
                            }
                        }
                    }

                    "OFFLINE" -> {
                        val userOff = event[2].toInt()
                        val timeOff = event[1].toInt() + 60

                        online.remove(userOff)
                        offline[userOff] = timeOff
                    }
                }
            }
            return ans
        }
    }
}