## 652. Find Duplicate Subtrees



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
    fun serialize(node: TreeNode?, map: MutableMap<String,Int>, ans: MutableList<TreeNode>): String {
        if (node == null) return "#"

        val left = serialize(node.left, map, ans)
        val right = serialize(node.right, map, ans)

        val str = "${node.`val`},$left,$right"
        
        map[str] = map.getOrDefault(str, 0) + 1

        if (map[str]!! == 2){
            ans.add(node)
        }
        return str
    }
    fun findDuplicateSubtrees(root: TreeNode?): List<TreeNode?> {
        val map = mutableMapOf<String, Int>()

        val ans = mutableListOf<TreeNode>()

        serialize(root, map, ans)

        return ans


    }
}

```

**Оценка по времени**: O(n)


**Оценка по памяти**: 


**Описание решения**
```

```

