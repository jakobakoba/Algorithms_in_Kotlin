Line 52: Char 15: error: unresolved reference: next
while(cur.next != null){
- я написал TreeNode вместо ListNode 

error: only safe (?.) or non-null asserted (!!.) calls are allowed 
on a nullable receiver of type ListNode?
  while(cur.next != null){
- переменная cur может быть nullable (типа ListNode?), 
 и компилятор Kotlin требует, чтобы вы сначала убедились, 
что cur не равен null, прежде чем обращаться к его свойствам, 
таким как next. 

Line 52: Exception in thread "main" java.lang.NullPointerException

- return prev должно быть, а не prev.next
- while(cur != null), а не while(cur.next != null)  
 