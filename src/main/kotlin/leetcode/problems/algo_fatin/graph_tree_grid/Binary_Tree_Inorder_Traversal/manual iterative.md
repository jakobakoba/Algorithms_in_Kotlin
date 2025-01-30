## 94. Binary Tree Inorder Traversal

```
class Solution {
   

    fun inorderTraversal(root: TreeNode?) : List<Int> {
        
        
        val answer = mutableListOf<Int>()
        
        val stack = mutableListOf<TreeNode>()
        
        // if cur == null then while loop will not start thanks to "cur != null" condition
        var cur = root
        
        while(cur != null || stack.isNotEmpty()){
        
            while(cur != null){
                stack.add(cur)
                cur = cur.left
            }
            
            cur = stack.removeLast()
            answer.add(cur.`val`)
            
            cur = cur.right
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