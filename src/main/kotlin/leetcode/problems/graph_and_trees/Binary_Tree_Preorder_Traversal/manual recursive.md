## 144. Binary Tree Preorder Traversal

```
class Solution{
    fun traverse(node: TreeNode?, ans: MutableList<Int>){
        if (node == null) return
        
        ans.add(node.`val`)
        traverse(node.left, ans)
        traverse(node.right, ans)
    }

    fun preorderTraversal(root: TreeNode?) : List<Int> {
        val ans = mutableListOf<Int>()
        traverse(root, ans)
        return ans
    }
}

```

**Оценка по времени**: О(n)


**Оценка по памяти**: О(n)


**Описание решения**
```

```