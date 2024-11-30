## 145. Binary Tree Postorder Traversal

```
class Solution {
    fun traverse(node: TreeNode?, answer: MutableList<Int>){
        if (node == null) return
        traverse(node.left, answer)
        traverse(node.right, answer)
        answer.add(node.`val`)
    }
    
    fun postorderTraversal(root: TreeNode?): List<Int> {
        val answer = mutableListOf<Int>()
        
        traverse(root, answer)
        
        return answer
    }
}

```

**Оценка по времени**: О(n)


**Оценка по памяти**: О(n)


**Описание решения**
```

```