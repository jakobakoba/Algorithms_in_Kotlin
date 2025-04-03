## 404. Sum of Left Leaves


```
/**
 * Example:
 * var ti = TreeNode(5)
 * var v = ti.`val`
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */
class Solution {
    fun sumOfLeftLeaves(root: TreeNode?): Int {
        
        if (root == null) return 0
        var sum = 0

        val queue: Queue<TreeNode> = LinkedList()
        queue.add(root)

        while(queue.isNotEmpty()){
            val node = queue.poll()

            node.left?.let {
                if (it.left == null && it.right == null){
                    sum += it.`val`
                } else {
                    queue.add(it)
                }
            }
            node.right?.let {
                queue.add(it)
            }
        }
        return sum
    }
}

```

**Оценка по времени**: О(n)


**Оценка по памяти**: О(n)


**Описание решения**
```
bfs

```

