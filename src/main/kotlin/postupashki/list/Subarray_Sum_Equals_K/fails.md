### 04/12/2024
Line 5: Char 31: error: 2 type arguments expected for inline fun <K, V> mutableMapOf(): MutableMap<K, V>
val map = mutableMapOf<Pair<Int, Int>>
- неправильная инициализация

WA 84/93
- добавление в map должно происходить после добавления значения из map в answer
. Иначе в answer может пойти текущий элемент. 

### 06/12/2024
WA 38/93
- сначала увеличиваем prefixSum и потом находим needed на нее

### 07/12/2024
Line 9: Char 13: error: val cannot be reassigned
prefixSum += nums[i]
- var and val

ans.add(map[needed]!!)
- попытался использовать add метод в Int переменную

WA 22/93
- ошибка в том, что делал k - prefixSum, а нужно было prefixSum - k

### 22/03/2025
Сделал sliding window и оказалось, что оно под эту задачу не работает.
WA 29/93
- sliding window не работает, потому что тут есть отрицательные числа

### 10/05/2025
не забудь добавить в map (0 to 1). 
