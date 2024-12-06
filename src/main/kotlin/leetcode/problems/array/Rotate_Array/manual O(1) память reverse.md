## 189. Rotate Array


```
class Solution {
    
    fun rotate(nums: IntArray, k: Int): Unit {

        fun reverseIt(a: Int, b: Int){
            var a = a
            var b = b
           while (a < b){
                nums[a] = nums[b].also {nums[b] = nums[a]}
                a++
                b--
            }
        }
        val n = nums.size
        val steps = k % n
        reverseIt(0, n - 1)
        reverseIt(0, steps - 1)
        reverseIt(steps, n - 1)
    }
}

```

**Оценка по времени**: О(n)


**Оценка по памяти**: О(1)


**Описание решения**
```
объяснение про индексы:
например: к = 3 n = 10
steps = k % n даст 3 то есть нужно взять 3 элемента с начала
поэтому reverse(0, steps - 1) нужно брать 0, 1, 2 и поэтому steps - 1


```