## 199. Binary Tree Right Side View


```
class Solution{

    fun preorder(node: TreeNode?, level: Int, levels: MutableList<Int> ): List<Int> {
        if (node == null) return levels
        if (levels.size <= level){
            levels.add(node.`val`)
        } else {
            levels[level] = node.`val`
        }
        
        
        preorder(node.left, level + 1, levels)
        preorder(node.right, level + 1, levels)
        return levels
    }
    
    fun rightSideView(root: TreeNode?): List<Int> {
        
        return preorder(root, 0, mutableListOf())
        
    
    }
}

```

**Оценка по времени**: О(...)


**Оценка по памяти**: О(...)


**Описание решения**
```
    

```