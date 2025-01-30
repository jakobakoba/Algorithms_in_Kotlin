сделал return dummy, но ожидался Unit
 - убрать return

если premid.next не сделать null, то под конец оба pointers 
окажутся в одном элементе и это будет бесконечный цикл
- premid!!.next = null