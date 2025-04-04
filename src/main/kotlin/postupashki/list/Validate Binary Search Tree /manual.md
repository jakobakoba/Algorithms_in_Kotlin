## 98. Validate Binary Search Tree


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
    fun isValidBST(root: TreeNode?): Boolean {
        fun valid(node: TreeNode?, left: Long, right: Long): Boolean{
            if (node == null) return true

            if (node.`val` <= left || node.`val` >= right) return false


            return valid(node.left, left, node.`val`.toLong()) && valid(node.right, node.`val`.toLong(), right)
        }
        return valid(root, Long.MIN_VALUE, Long.MAX_VALUE)
    }
}

```

**Оценка по времени**: О(n)


**Оценка по памяти**: О(n)


**Описание решения**
```

```

