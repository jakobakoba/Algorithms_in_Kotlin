## 112. Path Sum


```

class Solution {
    
    
    fun traverse(node: TreeNode?, curSum: Int, target: Int ) : Boolean {
        if (node == null) return false
        
        var curSum = curSum
        
        curSum += node.`val`
        
        if (node.left == null && node.right == null){
            return curSum == target
        }
        
        return traverse(node.left, curSum, target) || traverse(node.right, curSum, target)
    }
    
    
    fun hasPathSum(root: TreeNode?, target: Int) : Boolean {
        return traverse(root, 0, target)
    }
}
```

**Оценка по времени**: О(n)


**Оценка по памяти**: О(n)


**Описание решения**
```

```