package postupashki.telegram.`пары индексов между нет повторяющихся`

/*
Дана строка символов.
Найти количество пар индексов i и j (i <= j),
между которыми включительно нет повторяющихся символов.

Пример
aba -> 5
 */


fun main(){
    fun helper(s: String): Int {
        var left = 0
        val n = s.length
        val map = mutableMapOf<Char,Int>()
        var ans = 0
        for (right in 0 until n) {
            val cur = s[right]

            val last = map[cur] ?: -1

            if (last != -1 && last >= left){
                left = last + 1
            }
            map[cur] = right
            ans += right - left + 1
        }
        return ans
    }

    println(helper("aba"))
    println(helper("baab"))

}