package postupashki.telegram.панграмма

/*
Дан некоторый алфавит и строка. Необходимо найти в строке панграмму минимальной длины,
где панграмма - это такая подстрока исходной строки, в которую входят все буквы из
алфавита (но необязательно только они).

Пример:
A = {a, b, c}
s = "dfagabkaceb"
Ответом могут быть строки "bkac" и "aceb"
 */





fun main(){
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

                val charLeft = s[left]
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

    println(pangramma(listOf('a', 'b', 'c'), "dfagabkaceb")) //bkac
    println(pangramma(listOf('a', 'b'), "dfagabkaceb")) //ab
    println(pangramma(listOf('a', 'k'), "dfagabkaceb")) //ka
    println(pangramma(listOf('a', 'e', 'b'), "dfagabkaceb")) //aceb
    println(pangramma(listOf('d'), "dfagabkaceb")) //d
    println(pangramma(listOf('x'), "dfagabkaceb")) //net takogo


}