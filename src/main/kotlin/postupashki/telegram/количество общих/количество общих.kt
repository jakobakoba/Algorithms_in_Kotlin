package postupashki.telegram.`количество общих`

/*
Вполне себе прикладная задача, которая может встретиться в проде.
Поисковая формулировка: для двух поисковых выдач, заданных массивами DocId-ов
(векторы целых чисел) длины N, для всех k от 1 до N нужно посчитать количество
 общих документов в топах размера k.
 Формальная формулировка: Для двух массивов
целых чисел длины N, для всех k от 1 до N, посчитать количество общих чисел на
префиксах длины k. Числа в пределах массива могут повторяться, пересечение
считается без учета кратности.
Решение:Пройдемся по префиксу, параллельно
поддерживая два хешсета для первого и второго массива с элементами на префиксе.
Когда начинаем обрабатывать новый элемент, проверяем его в хешсете второго,
 если есть то += 1, также для второго. При этом если элемент уже был в префиксе,
  то прибавлять 1 к ответу не нужно.
int n = A.size();
  vector<int> result(n);unordered_set<int> setA, setB;int
common = 0;for (int i = 0; i < n; ++i) {int a = A[i];int
      b = B[i];if (!setA.count(a)) {setA.insert(a);if (setB.count(a))
       {common++;}}if (!setB.count(b)) {setB.insert(b);if (setA.count(b))
        {common++;}}result[i] = common;}
Если повторы внутри одного вектора запрещены,
то возможно решение с одним хешсетом всех встреченных элементов
двух массивовНужно отдельно обговорить допускаем ли мы повторы
 чисел внутри одного вектора. Хорошо, если вы сами спросите об
 этом на собесеВ результате решение O(N)
 */

fun main(){
    fun helper(a: IntArray, b: IntArray): IntArray {
        val n = a.size
        val result = IntArray(n)

        val set1 = mutableSetOf<Int>()
        val set2 = mutableSetOf<Int>()

        var common = 0

        for (i in 0 until n){
            val left = a[i]
            val right = b[i]
            if (left !in set1){
                set1.add(left)
                if (right in set2 && left == right){
                    common++
                } else if (left in set2){
                    common++
                }
            }

            if (right !in set2){
                set2.add(right)
                if (left != right && right in set1){
                    common++
                }
            }

            result[i] = common
        }
        return result
    }

    println(helper(intArrayOf(1,2,3,2), intArrayOf(2, 3, 4, 1)).joinToString(" ").trim())
}