Line 53: Exception in thread "main" 
java.lang.ArrayIndexOutOfBoundsException: -1
- неправильный вывод: внутри if statement нужно соблюдать порядок проверок,
нельзя первым ставить то, что выбросит исключение
- правильный вывод: перепутал || и &&
- еще одна ошибка: перепутал !in and in

Line 53: Exception in thread "main" java.lang.ClassCastException:
kotlin.Triple cannot be cast to java.lang.Comparable
- pq было без compareBy, добавил compareBy{it.first}