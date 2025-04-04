## 235. Lowest Common Ancestor of a Binary Search Tree


```
/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int = 0) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution {
    fun lowestCommonAncestor(root: TreeNode?, p: TreeNode?, q: TreeNode?): TreeNode? {
        var cur = root!!

        while(true){
            if (p!!.`val` < cur.`val` && q!!.`val` < cur.`val`){
                cur = cur.left
            } else if (p!!.`val` > cur.`val` && q!!.`val` > cur.`val`){
                cur = cur.right
            }
            else {
                return cur
            }
        }

        throw IllegalStateException(" ")

    }
}

```

**Оценка по времени**: О(logn) 1 раз на каждый уровень, но если skewed tree то O(n)


**Оценка по памяти**: О(1)


**Описание решения**
```

```

