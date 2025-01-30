## 102. Binary Tree Level Order Traversal


```
class Solution {
    fun preorder(node: TreeNode?, level: Int, levels: MutableList<MutableList<Int>>): List<List<Int>> {
            if (node == null) return levels
            
            if (levels.size <= level){
                levels.add(mutableListOf<Int>())
            }
            levels[level].add(node.`val`)
        
            preorder(node.left, level + 1, levels)
            preorder(node.right, level + 1, levels)
            return levels            
        }
        
    fun levelOrder(root: TreeNode?): List<List<Int>> {
        
       return preorder(root, 0, mutableListOf())
    }
}

```

**Оценка по времени**: О(n)


**Оценка по памяти**: O(n)


**Описание решения**
```

```