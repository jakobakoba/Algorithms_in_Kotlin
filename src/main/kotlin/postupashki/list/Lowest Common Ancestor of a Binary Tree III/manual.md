## Lowest Common Ancestor of a Binary Tree III

```
class Node(var `val`: Int){
    var left: Node? = null
    var right: Node? = null
    var parent: Node? = null
}

class Solution(){
    fun lowestCommonAncestor(p: Node?, q: Node?): Node? {
        var pointerA = p
        var pointerB = q
        
        while(pointerA != pointerB){
            pointerA = if (pointer?.parent != null ) pointerA.parent else q
            pointerB = if (pointer?.parent != null) pointerB.parent else p
        }
        
        return pointerA
    }
}

```

**Оценка по времени**: О(...)


**Оценка по памяти**: О(...)


**Описание решения**
```

```

