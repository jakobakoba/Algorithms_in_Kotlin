package yandex.iartr.view_sizes

/*
Условия задачи:

Дан родительский контейнер с фиксированной шириной parentWidth и список спецификаций ширин
дочерних View (childSpecs).
Каждый элемент childSpecs[i] описывает, как рассчитывать ширину дочернего View:

    Если childSpecs[i] > 0, то ширина дочернего View фиксированная и равна childSpecs[i].
    Если childSpecs[i] <= 0, то это доля, которую этот дочерний View займет от оставшегося пространства в родительском контейнере
     (после учета всех фиксированных ширин).

Требуется: Определить итоговые размеры всех дочерних View.

Пример: Входные данные:

    parentWidth = 100
    childSpecs = listOf(50, -3, -2)

Результат:

    Итоговые размеры: listOf(50, 30, 20)
 */

fun main(){
    fun measureWidths(parentWidth: Int, childSpecs: List<Int>): List<Int> {
        val fixedWidth = childSpecs.filter{it > 0}.sum()

        val remainingWidth = parentWidth - fixedWidth

        val totalRatio = childSpecs.filter { it <= 0 }.sumOf{-it}

        return childSpecs.map{spec ->
                if (spec > 0){
                    spec
                } else {
                    -spec * remainingWidth / totalRatio
                }
        }
    }

    println(measureWidths(100, listOf(50, -3, -2)))
}