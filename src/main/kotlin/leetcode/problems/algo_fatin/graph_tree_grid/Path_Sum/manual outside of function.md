## 112. Path Sum


```
class Solution {
    /*
    идем через preorder и если у ноды нет детей сравниваем с target 
    в функции держим сумму
    */
    
    
    
    fun hasPathSum(root: TreeNode?, target: Int) : Boolean {
        val leafs = mutableListOf<Int>()
        
        fun preorder(node: TreeNode?, curSum: Int) {
            if (node == null) return
            var curSum = curSum
            
            curSum += node.`val`
                
            if (node.left == null && node.right == null){
                leafs.add(curSum)
            }
            
            preorder(node.left, curSum)
            preorder(node.right, curSum)
         }
         
        preorder(root, 0)
        
        return leafs.contains(target)
    }
}
```

**Оценка по времени**: О(n)


**Оценка по памяти**: О(n)


**Описание решения**
```

```