## 938. Range Sum of BST


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
    fun rangeSumBST(root: TreeNode?, low: Int, high: Int): Int {
        if (root == null) return 0

        if (root.`val` < low){
            return rangeSumBST(root.right, low, high)
        }
        if (root.`val` > high){
            return rangeSumBST(root.left, low, high)
        }

        return root.`val` + rangeSumBST(root.left, low, high) + rangeSumBST(root.right, low, high)
    }
}

```

**Оценка по времени**: О(n)


**Оценка по памяти**: О(n)


**Описание решения**
```

```

