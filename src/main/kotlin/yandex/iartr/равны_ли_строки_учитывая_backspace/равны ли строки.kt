package yandex.iartr.равны_ли_строки_учитывая_backspace

/**
 * Проверить равны ли строки с учетом операций backspace (#)
 * Без использования дополнительной памяти
 *
 * Временная сложность: O(n), где n - максимальная длина строк
 * Пространственная сложность: O(1)
 *
 *    println(backspaceCompare("ab#c", "ad#c")) // true
 *    println(backspaceCompare("ab##", "c#d#")) // true
 *    println(backspaceCompare("a#c", "b")) // false
 *    println(backspaceCompare("######abc", "#abc")) // true
 */

fun main(){
    fun backspaceCompare(s1: String, s2: String): Boolean {
        var i = s1.length - 1
        var j = s2.length - 1

        var skip1 = 0
        var skip2 = 0

        while(i >= 0 || j >= 0){
            while( i >= 0){
                if (s1[i] == '#'){
                    skip1++
                    i--
                } else if (skip1 > 0){
                    skip1--
                    i--
                } else {
                    break
                }
            }
            while (j >= 0){
                if(s2[j] == '#'){
                    skip2++
                    j--
                } else if (skip2 > 0){
                    skip2--
                    j--
                } else {
                    break
                }
            }

            if (i >= 0 && j >= 0 && s1[i] != s2[j]) return false

            i--
            j--
        }
        return true
    }

    println(backspaceCompare("ab#c", "ad#c")) // true
    println(backspaceCompare("ab##", "c#d#")) // true
    println(backspaceCompare("a#c", "b")) // false
    println(backspaceCompare("######abc", "#abc")) // true
    println(backspaceCompare("asdbb##", "asd"))
}