## 103. Binary Tree Zigzag Level Order Traversal


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
    fun zigzagLevelOrder(root: TreeNode?): List<List<Int>> {
        val ans = mutableListOf<List<Int>>()
        if (root == null) return ans
        val queue: Queue<TreeNode> = LinkedList()   
        queue.add(root)
        var level = 0

    
        while(queue.isNotEmpty()){
            val arr = mutableListOf<Int>()

            val size = queue.size

            for (i in 0 until size){
                val node = queue.poll()
                arr.add(node.`val`)

                node.left?.let{
                    queue.add(node.left)
                }
                node.right?.let{
                    queue.add(node.right)
                }
            }
            if (level % 2 != 0){
                arr.reverse()
            }

            ans.add(arr)
            level += 1
        }
        return ans
    }
}

```

**Оценка по времени**: О(n)


**Оценка по памяти**: О(n)


**Описание решения**
```
check if root == null тогда верни пустой ans или emptyList() иначе добавишь null в queue
и потом queue.poll будет null получишь NullPointerException
```

