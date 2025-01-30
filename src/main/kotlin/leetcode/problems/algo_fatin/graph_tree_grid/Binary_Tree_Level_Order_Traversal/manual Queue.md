## 102. Binary Tree Level Order Traversal


```
class Solution {
    fun levelOrder(root: TreeNode?): List<List<Int>> {
        if (root == null) return emptyList()
        
        val queue: Queue<TreeNode> = LinkedList()
        
        queue.add(root)
        val answer = mutableListOf<List<Int>>()
        
        while(queue.isNotEmpty()){
            val temp = mutableListOf<Int>()
            for (i in 0 until queue.size){
                val node = queue.poll()
                temp.add(node.`val`)
                node.left?.let{
                    queue.add(node.left)
                }
                node.right?.let{
                    queue.add(node.right)
                }
            }
            answer.add(temp)
        }
        return answer
    }
}

```

**Оценка по времени**: О(n)


**Оценка по памяти**: О(m) max nodes at the same level


**Описание решения**
```

```