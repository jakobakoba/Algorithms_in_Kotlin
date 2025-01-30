package leetcode.problems.algo_fatin.linked_list.Palindrome_Linked_List
//
//class ListNode(var `val`: Int) {
//         var next: ListNode? = null
//     }

// НЕОПТИМАЛЬНОЕ:
//class Solution{
//    fun isPalindrome(head: ListNode?): Boolean {
//        val list = mutableListOf<Int>()
//
//        var cur = head
//        while(cur != null){
//            list.add(cur.`val`)
//            cur = cur!!.next
//        }
//        val n = list.size
//        var left = n / 2
//        var right = n / 2
//
//        if (list.size % 2 == 0){
//            left = n / 2 - 1
//        }
//
//        while(left >= 0 && right < n){
//            if (list[left] != list[right]){
//                return false
//            }
//            left--
//            right++
//        }
//
//        return true
//    }
//}

