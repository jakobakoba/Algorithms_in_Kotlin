## 180. Самая сложная буква

```
import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter


/*
	Для чтения входных данных необходимо получить их
	из стандартного потока ввода (System.in).
	Данные во входном потоке соответствуют описанному
	в условии формату. Обычно входные данные состоят
	из нескольких строк. Можно использовать более производительные
	и удобные классы BufferedReader, BufferedWriter, Scanner, PrintWriter.

	С помощью BufferedReader можно прочитать из стандартного потока:
	* строку -- reader.readLine()
	* число -- val n = reader.readLine().toInt();
	* массив чисел известной длины (во входном потоке каждое число на новой строке) --
	val nums = arrayOfNulls<Int>(len)
	for (i in 0 until len) {
		nums[i] = reader.readLine().toInt()
	}

	* последовательность слов в строке --
	val parts = reader.readLine().split(" ")

	Чтобы вывести результат в стандартный поток вывода (System.out),
	Через BufferedWriter можно использовать методы
	writer.write("Строка"), writer.write('A') и writer.newLine().

	Возможное решение задачи "Вычислите сумму чисел в строке":
	var sum = 0
	val parts = reader.readLine().split(" ")
	for (i in 0 until parts.length) {
		val num = parts[i].toInt()
		sum += num
	}
	writer.write(sum.toString()) 
*/
fun main(args: Array<String>) {
	val reader = BufferedReader(InputStreamReader(System.`in`))
	val writer = BufferedWriter(OutputStreamWriter(System.out))

	val n = reader.readLine().toInt()
	val s = reader.readLine()
	val nums = reader.readLine().split(" ").map{it.toInt()}

	var ans = s[0]
	var max = nums[0]

	for (i in 1 until n){
		val time = nums[i] - nums[i-1]
		if (time >= max){
			ans = s[i]
			max = time
		}
	}
	writer.write(ans.toString())



	reader.close()
	writer.close()
}

```

**Оценка по времени**: О(n)


**Оценка по памяти**: О(1)


**Описание решения**
```

```

