## 93. Restore IP Addresses


```
class Solution {
    fun restoreIpAddresses(s: String): List<String> {
        val n = s.length
        val ans = mutableListOf<String>()
        fun backtrack(i: Int, dots: Int, cur: String){
            if (i == n && dots == 4){
                ans.add(cur.substring(0, cur.length - 1))
                return
            }
            if (dots == 4) return

            for (j in i until minOf(i + 3, n)){
                if (s.substring(i, j + 1).toInt() <= 255 && (i == j || s[i] != '0')){
                    backtrack(j + 1, dots + 1, cur + s.substring(i, j + 1) + ".")
                }
            }
        }

        backtrack(0,0,"")
        return ans
    }
}

```

**Оценка по времени**: О(1) потому что максимум это 12


**Оценка по памяти**: О(1) глубина стека не более 4
Почему глубина стека ≤ 4?
Каждый вызов backtrack добавляет один сегмент:
На каждом шаге мы выбираем очередной сегмент IP (1-3 цифры) и делаем рекурсивный вызов.
После выбора 4-го сегмента (когда dots == 4), рекурсия останавливается.


**Описание решения**
```

```

