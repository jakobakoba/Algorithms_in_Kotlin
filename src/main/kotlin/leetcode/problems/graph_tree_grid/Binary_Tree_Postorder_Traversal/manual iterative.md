## 145. Binary Tree Postorder Traversal

```

class Solution {
    
    fun postorderTraversal(root: TreeNode?): List<Int> {
        val answer = mutableListOf<Int>()
        
        val stack = mutableListOf<TreeNode>()
        
        var cur = root
        
        var lastVisited: TreeNode? = null
        
        while(cur != null || stack.isNotEmpty()){
            while(cur != null){
                stack.add(cur)
                cur = cur.left
            }
            
            val top = stack.last()
            
            if (top.right != null && top.right != lastVisited){
                cur = top.right
            } else {
                stack.removeLast()
                answer.add(top.`val`)
                lastVisited = top
            }
        }
        
        return answer
    }
}

```

**Оценка по времени**: О(n)


**Оценка по памяти**: О(n)


**Описание решения**
```

```