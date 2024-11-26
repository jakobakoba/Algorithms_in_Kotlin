Line 16: Char 24: error: only safe (?.) or non-null asserted (!!.) calls are allowed on a nullable receiver of type ListNode?
slow = slow.next
- slow = head, а head был ListNode? slow!!.next дописал

неправильно обрабатывал середину при нечетных, потому что у меня было 
while(fast != null)
- исправил на while(fast != null && fast.next != null)
- если только fast != null то slow прыгает на 1 шаг дальше чем нужно