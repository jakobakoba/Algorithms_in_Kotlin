## 94. Binary Tree Inorder Traversal

```
class Solution {
    fun traverse(node: TreeNode?, arr: MutableList<Int>){
        if (node == null) return
        
        traverse(node.left, arr)
        arr.add(node.`val`)
        traverse(node.right, arr)
    }

    fun inorderTraversal(root: TreeNode?) : List<Int> {
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