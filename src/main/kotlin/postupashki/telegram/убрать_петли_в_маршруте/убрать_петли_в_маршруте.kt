package postupashki.telegram.убрать_петли_в_маршруте

/*
Дан список ненулевой длины, состоящий из направлений
L - left
R - right
D - down
U - up
Каждый элемент перемещает вас на 1 в заданном направлении.

Известно, что петли (возврат в уже посещенную точку) дают нулевое перемещение и являются пустой
тратой времени. Нужно удалить из списка все петли и вернуть оптимизированный короткий маршрут,
например:
[R, D, L, U, R] -> [R]
[R, D, L, R, U, U, R] -> [R, U, R]

Важно отметить, что цель не просто попасть в ту же самую конечную точку, но и придерживаться
 первоначального маршрута (не срезать по прямой):
[D, R, U] -> [D, R, U]

Вернуть нужно массив направлений.
Ограничения: O(N) по времени и памяти

Решение:

Большинство придумывают решение, в котором складывается текущая координата в хэшмапу.
Как только попадаем в ситуацию, когда точка есть, смотрим, какая позиция, и удаляем все до
текущей точки. Это неидеальное решение - при удалении можно случайно сделать квадрат, вырезать
лишнее и тд и пр, короче решение не очень

Решение по-лучше - есть хешсет (unordered_set) с посещенными координатами и список координат.
 Как только видим, что в хешсете что-то есть, отступаем по списку, пока не найдем ту самую координату,
  по пути очищая хешсет. Поиск в хешсете это O(1), поэтому получаем линию по времени и памяти.
  Просто и быстро, но мало кто догадывается на собесе

Другое хорошее решение - есть хешмапа, в хешмапе храним направление, куда идти дальше из этой точки.
 Если вернулись в ту же точку - перезатираем новым направлением. Тонкость: если финальная точка
  маршрута находится на петле, то в ней будет записано куда идти дальше

Третье хорошее решение - есть хешмапа и вектор посещенных точек. В хешмапе храним ласт индекс
точки в векторе

Стоит сказать, что решения не уникальны - если идти с конца, можно получить другое решение
 */
//ИСПРАВИТЬ КОД
//fun main(){
//    fun removeCycle(path: List<Char>): List<Char> {
//        val n = path.size
//
//        val directions = mapOf(
//            'L' to Pair(-1, 0),
//            'R' to Pair(1, 0),
//            'D' to Pair(0, -1),
//            'U' to Pair(0, 1)
//        )
//
//        val set = mutableSetOf<Pair<Int,Int>>()
//        set.add(0 to 0)
//        var cur = Pair(0,0)
//
//        val ans = mutableListOf<Char>()
//
//        for (d in path){
//            val (dr, dc) = directions[d]!!
//            cur = Pair(cur.first + dr, cur.second + dc)
//            if (cur in set){
//                while(ans.isNotEmpty() && cur != set.first()){
//                    ans.removeAt(ans.size - 1)
//                    cur = set.first()
//                }
//                set.clear()
//            } else {
//                set.add(cur)
//                ans.add(d)
//            }
//        }
//        return ans
//    }
//
//    println(removeCycle(listOf('R', 'D', 'L', 'R', 'U', 'U', 'R')))
//}