Line 3: Char 9: error: destructuring declarations are only allowed for local variables/values
val (rows, cols) = intArrayOf(matrix.size, matrix[0].size)
- не дает разбивать вне init и пришлось поочередно вручную

### 06/12/2024
WA 4/22
- невнимательность и лень: ошибся в индексе col2, не добавил +1. Отправил не проверяя, потому что 
подумал "точно правильно".