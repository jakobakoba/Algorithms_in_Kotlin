package yandex.yandex_6_training.yandex_6_training_3_dz_DONE

// ЭТОТ КОД НА КОТЛИНЕ ПАДАЕТ В ЯНДЕКС КОНТЕСТЕ С ОШИБКОЙ CE, НО в IDE все работает.
// ПРИШЛОСЬ ОТПРАВИТЬ ЭТОТ ЖЕ КОД ПЕРЕПИСАННЫЙ JAVA

//import java.io.File
//import java.io.PrintWriter
//import java.util.*
//
//fun main() {
//    val INPUT = File("input.txt").inputStream()
//    val OUTPUT = File("output.txt").outputStream()
//
//    val bufferedReader = INPUT.bufferedReader()
//    val outputWriter = PrintWriter(OUTPUT, true)
//
//
//
//    var n = bufferedReader.readLine().toInt()
//    val w = bufferedReader.readLine()
//    val s = bufferedReader.readLine()
//
//    val stack = Stack<Char>()
//    val ans = StringBuilder()
//
//    var k = s.length
//
//    var open = 0
//    var close = 0
//
//    val map = mapOf(')' to '(', ']' to '[')
//
//    for (c in s) {
//        ans.append(c)
//        if (c in map.values) {
//            stack.push(c)
//            open++
//        } else if (c in map.keys && stack.isNotEmpty() && stack.peek() == map[c]) {
//            stack.pop()
//            close++
//        }
//    }
//
//    while (ans.length < n) {
//        for (c in w) {
//            if (c in map.values && open < n / 2) {
//                open++
//                ans.append(c)
//                stack.push(c)
//                break
//            } else if (c in map.keys && stack.isNotEmpty() && stack.peek() == map[c]) {
//                close--
//                ans.append(c)
//                stack.pop()
//                break
//            }
//        }
//    }
//    outputWriter.println(ans.toString())
//    outputWriter.close()
//}