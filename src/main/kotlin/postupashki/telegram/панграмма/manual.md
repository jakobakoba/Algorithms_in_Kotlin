## панграмма

```
Задача с собеседования в Яндекс

Дан некоторый алфавит и строка. Необходимо найти в строке панграмму минимальной длины, 
где панграмма - это такая подстрока исходной строки, в которую входят все буквы из 
алфавита (но необязательно только они).

Пример:
A = {a, b, c}
s = "dfagabkaceb"
Ответом могут быть строки "bkac" и "aceb"

Решение:
Халявные два указателя буквально подарят тебе оффер
Будем двигать правый указатель, расширяя подстроку, пока не включим все символы из алфавита. 
Как только все символы оказались в окне, будем двигать левый указатель, обновляя ответ и 
сохраняя все необходимые символы.
Обязательно надо проверить, что панграмма с концом в конце исходной строки также
 рассматривается.
Асимптотика O(N)

В целом, можно предложить алгоритм без сдвига начала строки за O(NS), что тоже прокатит
Типичные ошибки:
1) Не обработать ненахождение панграммы в принципе
2) Неправильно похендлить алфавит длиной один
3) Ненахождение ответа в конце текста

 fun pangramma(alphabet: List<Char>, s: String): String {
        val set = alphabet.toSet()
        val required = set.size

        val n = s.length

        var minLength = Int.MAX_VALUE
        var minStart = -1

        val charCount = mutableMapOf<Char, Int>()
        var formed = 0

        var left = 0
        var right = 0

        while (right < n){
            val char = s[right]

            if (char in set){
                charCount[char] = charCount.getOrDefault(char, 0) + 1
                if (charCount[char] == 1){
                    formed++
                }
            }

            while(formed == required){
                if (right - left + 1 < minLength){
                    minLength = right - left + 1
                    minStart= left
                }

                var charLeft = s[left]
                if (charLeft in set){
                    charCount[charLeft] = charCount[charLeft]!! - 1
                    if(charCount[charLeft] == 0){
                        formed--
                    }
                }
                left++
            }
            right++
        }

        return if (minStart == -1) "" else s.substring(minStart, minStart + minLength)
    }
```

**Оценка по времени**: О(n)


**Оценка по памяти**: О(k) алфавит или O(1) 


**Описание решения**
```

```