package postupashki.list.`One Edit Distance`


fun main(){
    fun distance(s: String, t: String): Boolean {
        if (s.length < t.length){
            return distance(t, s)
        }

        val (n, m) = listOf(s.length, t.length)

        if (n - m > 1) return false

        for (i in 0 until m){
            if (s[i] != t[i]){
                if (n == m){
                    return s.substring(i + 1) == t.substring(i + 1)
                } else {
                    return s.substring(i + 1) == t.substring(i)
                }
            }
        }
        return n == m + 1
    }

    println(distance("aDb", "adb")) // false (разные буквы в середине)
    println(distance("ab", "ab")) // false (одинаковые слова, разница = 0)
    println(distance("cat", "bat")) // true (замена 'c' на 'b')
    println(distance("cats", "cat")) // true (удаление 's')
    println(distance("cat", "cats")) // true (вставка 's')



}