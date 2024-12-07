# sorting
### 07/12/2024 
Line 9: Char 43: error: type mismatch: inferred type is MutableList<Int> but Int was expected
val arr = IntArray(nums.size + 1){mutableListOf<Int>()}
- должно быть Array(nums.size + 1)

WA 8/21
надо добавлять все элементы из ячейки, а я добавлял лишь самый первый

