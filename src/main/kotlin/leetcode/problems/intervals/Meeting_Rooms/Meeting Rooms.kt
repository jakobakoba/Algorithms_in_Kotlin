package leetcode.problems.intervals.Meeting_Rooms

fun main(){
    //answer = 2
    val input = listOf(intArrayOf(0,30), intArrayOf(5,10), intArrayOf(15,20))
    //anwer = 4 (мб нет)
    val input2 = listOf(intArrayOf(1,18), intArrayOf(18,23), intArrayOf(15,29), intArrayOf(4,15),
        intArrayOf(2,11), intArrayOf(9,19)
    )

    fun solveMeetingRoom(input: List<IntArray>): Int {
        val points = mutableListOf<Pair<Int,Int>>()
        for (meeting in input){
            points.add(Pair(meeting[0], 1))
            points.add(Pair(meeting[1], -1))
        }
        points.sortBy { it.first }

        var rooms = 0
        var temp = 0
        for (point in points){
            temp += point.second
            rooms = maxOf(rooms, temp)
        }
        return rooms
    }

    println(solveMeetingRoom(input))
    println(solveMeetingRoom(input2))
}