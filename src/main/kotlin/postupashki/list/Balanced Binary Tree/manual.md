## 110. Balanced Binary Tree


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
    fun isBalanced(root: TreeNode?): Boolean {
        
        fun dfs(node: TreeNode?) : Pair<Boolean, Int> {
            if (node == null) return true to 0

            val left = dfs(node.left)
            val right = dfs(node.right)

            val balanced = left.first && right.first && abs(left.second - right.second) <= 1

            return balanced to 1 + maxOf(left.second, right.second)
        }
        return dfs(root).first
    }
}

```

**Оценка по времени**: О(n)


**Оценка по памяти**: О(n) вытянутое дерево O(logn) в среднем


**Описание решения**
```
post-order (L → R → Node)

```

