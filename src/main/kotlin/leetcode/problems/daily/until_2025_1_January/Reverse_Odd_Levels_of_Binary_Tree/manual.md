## 2415. Reverse Odd Levels of Binary Tree


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
    fun reverseOddLevels(root: TreeNode?): TreeNode? {
        val queue: Queue<TreeNode?> = LinkedList()

        queue.add(root)
        var step = 0
        while(queue.isNotEmpty()){
            val size = queue.size
            val levelNodes = mutableListOf<TreeNode>()
            for (i in 0 until size){
                val num = queue.poll()!!
                levelNodes.add(num)
                num.left?.let{
                    queue.add(num.left)
                }
                num.right?.let{
                    queue.add(num.right)
                }
            }
            if (step % 2 != 0){
                var left = 0
                var right = size - 1
                while(left <= right){
                    val temp = levelNodes[left].`val`
                    levelNodes[left].`val` = levelNodes[right].`val`
                    levelNodes[right].`val` = temp
                    left++
                    right--
                }
            }
            step++
        }
        return root
    }
}

```

**Оценка по времени**: О(n)


**Оценка по памяти**: О(n)


**Описание решения**
```

```