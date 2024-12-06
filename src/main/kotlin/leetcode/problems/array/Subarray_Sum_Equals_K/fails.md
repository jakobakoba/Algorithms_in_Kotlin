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