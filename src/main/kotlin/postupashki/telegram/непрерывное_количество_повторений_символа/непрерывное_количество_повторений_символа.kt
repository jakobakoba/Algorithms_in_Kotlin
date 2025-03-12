package postupashki.telegram.непрерывное_количество_повторений_символа
/*
Дана строка, нужно вывести для каждого символа в ней максимальное количество
непрерывных повторений этого символа в строке
Например, для строки "aafbaaaaffc" ответом будет
a: 4
b: 1
c: 1
f: 2
 */
fun main(){
    fun countSymbols(s: String): Map<Char, Int> {
        val d = mutableMapOf<Char, Int>()

        var prev: Char? = null
        var count = 1

        for (char in s + '\u0000'){
            if (char == prev){
                count++
            } else {
                if (prev != null){
                    d[prev] = maxOf(d.getOrDefault(prev, 0), count)
                }
                count = 1
                prev = char
            }
        }
        return d
    }

    val result = countSymbols("aafbaaaaffc")
    for ((key, value) in result){
        println("$key: $value")
    }
}