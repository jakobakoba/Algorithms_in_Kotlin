package yandex.iartr.taxi_name_predict


/*
Мы хотим вызвать такси своему другу.
Для этого нужно реализовать нечёткий поиск по списку контактов пользователя.

Условия задачи:

    Входные данные: строка поиска (input) и список контактов (dataSet).
    Нужно найти в списке контактов такие строки, которые максимально похожи на строку поиска.
    Похожесть определяется на основе частичного совпадения символов и подстрок (нечёткий поиск).

Примеры:

    Контакты: "John Smith", "Mike Marley", "Hillary Cosplay", "Mark Johnson"
    Ищем: "Joh"
    Результат: ["John Smith", "Mark Johnson"]

    Контакты: "John Smith", "Mike Marley", "Hillary Cosplay", "Mark Johnson"
    Ищем: "m John"
    Результат: ["Mark Johnson"]

    Контакты: "John Smith", "Mike Marley", "Hillary Cosplay", "Mark Johnson", "Kamil Englo", "Mjohn Kengsman", "Mjohn Keng"
    Ищем: "keng"
    Результат: ["Kamil Englo", "Mjohn Kengsman", "Mjohn Keng"]
 */

fun main(){
    //алгоритм для вычисления длины наибольшей общей подпоследовательности (LCS)
    fun lcsLength(s1: String, s2: String): Int{
        val n = s1.length
        val m = s2.length

        val dp = Array(n + 1){IntArray(m + 1) }

        for (i in 1 .. n){
            for (j in 1 .. m){
                if (s1[i-1] == s2[j -1]){
                    dp[i][j] = dp[i-1][j-1] + 1
                } else {
                    dp[i][j] = maxOf(dp[i-1][j], dp[i][j-1])
                }
            }
        }
        return dp[n][m]
    }
    fun predict(input: String, dataSet: List<String>): List<String> {
        val inputNormalized = input.lowercase().replace(" ", "")
        var maxScore = 0
        val results = mutableListOf<String>()

        for (contact in dataSet){
            val contactNormalized = contact.lowercase().replace(" ","" )
            val score = lcsLength(inputNormalized, contactNormalized)
            if(score > maxScore){
                maxScore = score
                results.clear()
                results.add(contact)
            } else if (score == maxScore){
                results.add(contact)
            }
        }
        return results
    }
    val answer = predict("Joh", mutableListOf("John Smith", "Mike Marley", "Hillary Cosplay", "Mark Johnson"))
    answer.forEach{println(it)}

}
