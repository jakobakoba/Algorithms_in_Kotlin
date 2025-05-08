## 1007. Minimum Domino Rotations For Equal Row


```
class Solution {
    fun minDominoRotations(tops: IntArray, bottoms: IntArray): Int {
        if (tops.all{it == tops.first()}) return 0
        val top = mutableMapOf<Int,Int>()
        val bottom = mutableMapOf<Int,Int>()

        for (i in 0 until tops.size){
            if (tops[i] in top) continue
            val target = tops[i]
            for (j in 0 until tops.size){
                if (i != j){
                    if (tops[j] == target){
                        continue
                    } else if (tops[j] != target && bottoms[j] == target){
                        top[target] = top.getOrDefault(target, 0) + 1
                    } else {
                        top[target] = -1
                        break
                    }
                }
            }
        }

        for (i in 0 until bottoms.size){
            if (bottoms[i] in bottom) continue
            val target = bottoms[i]
            for (j in 0 until bottoms.size){
                if (i != j){
                    if (bottoms[j] == target){
                        continue
                    } else if (bottoms[j] != target && tops[j] == target){
                        bottom[target] = bottom.getOrDefault(target, 0) + 1
                    } else {
                        bottom[target] = -1
                        break
                    }
                }
            }
        }

        var min = Int.MAX_VALUE

        for ((num, t) in top){
            if (t == -1) continue
            min = minOf(min, t)
        }
        for ((num, t) in bottom){
            if (t == -1) continue
            min = minOf(min, t)
        }
        return if (min == Int.MAX_VALUE) -1 else min
    }
}

```

**Оценка по времени**: О(n^2)


**Оценка по памяти**: О(1) возможные значения от 1 до 6


**Описание решения**
```

```

