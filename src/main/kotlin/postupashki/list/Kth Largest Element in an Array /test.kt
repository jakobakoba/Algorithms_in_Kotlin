package postupashki.list.`Kth Largest Element in an Array `

import java.util.PriorityQueue

fun main(){
    val maxHeap = PriorityQueue<Int>(compareByDescending { it })
    val minHeap = PriorityQueue<Int>()

    for (i in 0 until 5){
        maxHeap.add(i)
        minHeap.add(i)
    }
    while(minHeap.isNotEmpty()){
        println(minHeap.poll())
    }

}



