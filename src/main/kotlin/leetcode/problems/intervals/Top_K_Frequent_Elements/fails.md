# sorting
### 07/12/2024 
Line 9: Char 43: error: type mismatch: inferred type is MutableList<Int> but Int was expected
val arr = IntArray(nums.size + 1){mutableListOf<Int>()}
- должно быть Array(nums.size + 1)

WA 8/21
надо добавлять все элементы из ячейки, а я добавлял лишь самый первый

### 09/12/2024
WA 5/21
- if size >= k break должно быть, а поставил >k и поэтому 1 ненужный элемент добавлял, один ненужный
цикл запускался.