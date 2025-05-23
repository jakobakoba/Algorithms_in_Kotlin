package postupashki.telegram.`пары индексов между нет повторяющихся`

fun main(){
    fun count(s: String): Int {
        val n = s.length

        var last = -1
        var left = 0
        var result = 0

        val map = mutableMapOf<Char,Int>()

        for (right in 0 until n){
            val cur = s[right]

            last = map[cur] ?: -1

            if (last != -1 && last >= left){
                left = last + 1
            }

            map[cur] = right
            result += right - left + 1

        }
        return result
    }

    println(count("aba"))
    println(count("baab"))
}