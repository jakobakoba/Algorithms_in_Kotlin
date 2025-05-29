- Line 64: Char 35: error: unexpected tokens (use ';' to separate expressions on the same line)
   second = second!!.next?
  - можно вообще не заморачиваться над nullability
  - можно ListNode ставить для first and second и не париться над "?"

29/05/2025
- ошибка неправильно выбрал длину начального прыжка, надо прыгать на until n + 1, чтобы у left была возможность
поменять ссылки