## 2127. Maximum Employees to Be Invited to a Meeting

```
class Solution {
    fun maximumInvitations(favorite: IntArray): Int {
        val n = favorite.size
        var longest = 0
        val visited = BooleanArray(n)

        val length2 = mutableListOf<Pair<Int,Int>>()

        for (i in 0 until n){
            if (visited[i]) continue

            var start = i
            var cur = i

            val curSet = mutableSetOf<Int>()

            while(!visited[cur]){
                visited[cur] = true
                curSet.add(cur)
                cur = favorite[cur]
            }

            if (cur in curSet){
                var length = curSet.size
                while(start != cur){
                    length -= 1
                    start = favorite[start]
                }
                longest = maxOf(longest, length)
                if(length  == 2){
                    length2.add(Pair(cur, favorite[cur]))
                }
            }
        }

        val inverted = mutableMapOf<Int,MutableList<Int>>()

        for ((dst, src) in favorite.withIndex()){
            inverted.computeIfAbsent(src){mutableListOf()}.add(dst)
        }

        fun bfs(src: Int, parent: Int): Int {
            val deque: Deque<Pair<Int,Int>> = LinkedList()
            deque.add(Pair(src, 0))

            var maxLength = 0

            while(deque.isNotEmpty()){
                val (node, length) = deque.pollFirst()
                if (node == parent){
                    continue
                }
                maxLength = maxOf(maxLength, length)
                for(neighbor in inverted[node] ?: emptyList()){
                    deque.add(Pair(neighbor, length + 1))
                }
            }
            return maxLength
        }

        var chainSum = 0
        for ((n1, n2) in length2){
            chainSum += bfs(n1, n2) + bfs(n2, n1) + 2
        }
        return maxOf(chainSum, longest)
    }
}
```

**Оценка по времени**: О(...)


**Оценка по памяти**: О(...)


**Описание решения**
```
https://www.youtube.com/watch?v=aPBELJa-LM8
```