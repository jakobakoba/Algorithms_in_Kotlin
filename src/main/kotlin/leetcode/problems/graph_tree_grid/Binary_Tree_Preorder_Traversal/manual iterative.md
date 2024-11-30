## 144. Binary Tree Preorder Traversal

```
class Solution{
    
    fun preorderTraversal(root: TreeNode?) : List<Int> {
    
        if (root == null) return emptyList()
        val stack = mutableListOf<TreeNode?>()
        
        stack.add(root)
        val answer = mutableListOf<Int>()
        
        while(stack.isNotEmpty()){
            val node = stack.removeLast()!!
            answer.add(node.`val`)
            if (node.right != null){
                stack.add(node.right)
            } 
            if (node.left != null){
                stack.add(node.left)
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