## 124. Binary Tree Maximum Path Sum


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
    fun maxPathSum(root: TreeNode?): Int {
        var max = root?.`val` ?: 0

        fun dfs(node: TreeNode?): Int {
            if (node == null) return 0

            val left = maxOf(dfs(node.left), 0)
            val right = maxOf(dfs(node.right), 0)

            max = maxOf(max, node.`val` + left + right)

            return node.`val` + max(left ,right)
        }

        dfs(root)
        return max

    }
}

```

**Оценка по времени**: О(n)


**Оценка по памяти**: О(n) skewed tree worst case and O(logn) balanced tree обычный


**Описание решения**
```

```

