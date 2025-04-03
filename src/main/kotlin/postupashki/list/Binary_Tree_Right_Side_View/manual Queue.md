## 199. Binary Tree Right Side View


```
class Solution{
    fun rightSideView(root: TreeNode?): List<Int> {
        if (root == null) return emptyList()
        val queue: Queue<TreeNode> = LinkedList()
        
        queue.add(root)
        val answer = mutableListOf<Int>()
        while(queue.isNotEmpty()){  
        
            val n = queue.size
            
            for (i in 0 until n){
                val node = queue.poll()
                if (i == n - 1){
                    answer.add(node.`val`)
                }   
                node.left?.let{
                    queue.add(node.left)
                }
                node.right?.let{
                    queue.add(node.right)
                }
            }
        }
        return answer
    }
}

```

**Оценка по времени**: О(...)


**Оценка по памяти**: О(...)


**Описание решения**
```
    //делаем через queue и ставим последний элемент в ответ

```