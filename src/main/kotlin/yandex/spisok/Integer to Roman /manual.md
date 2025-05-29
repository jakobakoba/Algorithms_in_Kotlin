## 12. Integer to Roman



``` 
class Solution {
    fun intToRoman(num: Int): String {
        val map = listOf(
            1000 to "M",
            900 to "CM",
            500 to "D",
            400 to "CD",
            100 to "C",
            90 to "XC",
            50 to "L",
            40 to "XL",
            10 to "X",
            9 to "IX",
            5 to "V",
            4 to "IV",
            1 to "I",
        )

        val sb = StringBuilder()
        var temp = num
        for ((number, roman) in map){
            while(temp >= number){
                sb.append(roman)
                temp -= number
            }
        }
        return sb.toString()
    }
}

```

**Оценка по времени**: O(1)


**Оценка по памяти**: O(1)


**Описание решения**
```

```

