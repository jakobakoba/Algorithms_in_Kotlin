package yandex.yandex_1_training.yandex_1_training_1_dz_DONE
import java.util.Scanner

fun main(){
    val scanner = Scanner(System.`in`)
    val a = scanner.nextInt()
    val b = scanner.nextInt()
    val c = scanner.nextInt()

    if (a + b > c && a + c > b && b + c > a){
        println("YES")
    } else {
        println("NO")
    }
}