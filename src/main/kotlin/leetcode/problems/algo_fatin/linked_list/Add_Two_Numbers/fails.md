### 07/12/2024
Line 24: Char 31: error: only safe (?.) or non-null asserted (!!.) calls are allowed on a nullable receiver of type ListNode?
val newValue = (c1.`val` + c2.`val` + leftover) % 10 
- получил nullability обработку, поставил "!!" на "val" (Не исправлено)

Line 24: Char 31: error: only safe (?.) or non-null asserted (!!.) calls are allowed on a nullable receiver of type ListNode?
val newValue = (c1.`val` + c2.`val` + leftover) % 10 
- получил ту же nullability обработку, нужно было ставить на c1 (не исправлено)

Line 24: Char 31: error: only safe (?.) or non-null asserted (!!.) calls are allowed on a nullable receiver of type ListNode?
val newValue = (c1.`val` + c2.`val` + leftover) % 10 
- я продолжаю пока эти условия выполняются  while(c1 != null || c2 != null || leftover > 0){
, поэтому нужно ставить c1.`val` ?: 0 (не исправлено)

Line 24: Char 31: error: only safe (?.) or non-null asserted (!!.) calls are allowed on a nullable receiver of type ListNode?
val newValue = (c1.`val` + c2.`val` + leftover) % 10 
- не поставил "?" после c1 то есть в двух местах обработка должна быть.
После c1 и ?:

цифры и так стоят в reversed виде и поэтому нет необходимости делать reverse

MLE
перепутал расчет newValue and carry. Должно быть newValue %10 и carry /10 

### 31/05/2025
- ошибка не поставил ? после variable когда использовал ?: элвис оператор