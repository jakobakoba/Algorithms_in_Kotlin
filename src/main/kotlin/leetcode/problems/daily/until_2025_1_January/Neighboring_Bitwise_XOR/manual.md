## 2683. Neighboring Bitwise XOR


```
class Solution {
    fun doesValidArrayExist(derived: IntArray): Boolean {
        var start = 0
        var last = 0

        for (num in derived){
            if (num == 1){
                last = last xor 1
            }
        }
        return start == last
    }
}

```

**Оценка по времени**: О(...)


**Оценка по памяти**: О(...)


**Описание решения**
```
If derived[i] is 1, it implies that the XOR of the i-th and (i+1)-th element should be 1. 
To simulate this in a single pass without knowing the actual elements of the original array,
 we use last = last xor 1:
If last was 0, XORing with 1 makes last become 1.
If last was 1, XORing with 1 makes last become 0 again.

```