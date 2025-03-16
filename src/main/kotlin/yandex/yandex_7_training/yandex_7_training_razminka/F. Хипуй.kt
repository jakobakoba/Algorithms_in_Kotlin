package yandex.yandex_7_training.yandex_7_training_razminka



fun main(){
    val heap = mutableListOf<Int>()

    fun insert(k: Int){
        heap.add(k)
        var index = heap.size - 1
        while(index > 0){
            val parentIndex = (index - 1) / 2
            if (heap[index] > heap[parentIndex]){
                heap[index] = heap[parentIndex].also{heap[parentIndex] = heap[index]}
                index = parentIndex
            } else {
                break
            }
        }
    }
    fun bubbleDown(index: Int) {
        var current = index
        while(true){
            val left = 2 * current +  1
            val right = 2 * current + 2
            var largest = current

            if (left < heap.size && heap[left] > heap[largest]){
                largest = left
            }
            if (right < heap.size && heap[right] > heap[largest]){
                largest = right
            }
            if (largest != current){
                heap[current] = heap[largest].also{heap[largest] = heap[current]}
                current = largest
            } else {
                break
            }
        }
    }
    fun extract(): Int{
        val max = heap[0]
        heap[0] = heap.last()
        heap.removeAt(heap.size - 1)
        if (heap.isNotEmpty()){
            bubbleDown(0)
        }
        return max
    }

    val n = readln().toInt()
    repeat(n){
        val command = readln().split(" ")
        when(command[0]){
            "0" -> insert(command[1].toInt())
            "1" -> println(extract())
        }
    }
}