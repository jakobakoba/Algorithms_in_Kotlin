## 2471. Minimum Number of Operations to Sort a Binary Tree by Level


```
class Solution {
    fun minSwaps(arr: MutableList<Int>): Int {
        val n = arr.size
        val indexedArr = arr.mapIndexed{index, value -> Pair(value, index)}.sortedBy{it.first}

        val visited = BooleanArray(n)
        var swaps = 0

        for (i in arr.indices){
            if (visited[i] || indexedArr[i].second == i) continue

            var cycleSize = 0
            var j = i
            while(!visited[j]){
                visited[j] = true
                j = indexedArr[j].second
                cycleSize++
            }
            if (cycleSize > 1){
                swaps += cycleSize - 1
            }
        }
        return swaps
    }
    fun minimumOperations(root: TreeNode?): Int {
        val queue: Queue<TreeNode> = LinkedList()

        queue.add(root)
        var ans = 0
        while(queue.isNotEmpty()){
            val size = queue.size
            val nodes = mutableListOf<Int>()

            for (i in 0 until size){
                val node = queue.poll()
                nodes.add(node.`val`)

                node.left?.let{
                    queue.add(node.left)
                }
                node.right?.let{
                    queue.add(node.right)
                }
            }

            ans += minSwaps(nodes)
        }
        return ans
    }
}

```

**Оценка по времени**: О(nlogn)


**Оценка по памяти**: О(n)


**Описание решения**
```

```