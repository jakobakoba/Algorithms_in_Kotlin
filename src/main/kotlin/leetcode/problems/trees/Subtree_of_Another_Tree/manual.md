## 572. Subtree of Another Tree

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
    fun sameTree(a: TreeNode?, b: TreeNode?): Boolean {
        if (a == null && b == null){
            return true
        }

        if (a != null && b != null && a.`val` == b.`val`){
            return sameTree(a.left, b.left) && sameTree(a.right, b.right)
        }
        return false
    }

    fun isSubtree(root: TreeNode?, subRoot: TreeNode?): Boolean {
        if (subRoot == null){
            return true
        }
        if (root == null){
            return false
        }

        if (sameTree(root, subRoot)){
            return true
        }

        return  isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot)
    }
}

```

**Оценка по времени**: О(...)


**Оценка по памяти**: О(...)


**Описание решения**
```
https://www.youtube.com/watch?v=E36O5SWp-LE
```