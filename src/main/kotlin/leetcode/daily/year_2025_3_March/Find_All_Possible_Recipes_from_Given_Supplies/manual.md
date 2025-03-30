## 2115. Find All Possible Recipes from Given Supplies

```
class Solution {
    fun findAllRecipes(recipes: Array<String>, ingredients: List<List<String>>, supplies: Array<String>): List<String> {

        val canCook = mutableMapOf<String, Boolean>()
        for (supply in supplies){
            canCook[supply] = true
        }

        val recipeIndex = mutableMapOf<String, Int>()
        for ((index, value) in recipes.withIndex()){
            recipeIndex[value] = index
        }

        
        fun dfs(recipe: String): Boolean {
            if(recipe in canCook){
                return canCook[recipe]!!
            }

            if(recipe !in recipeIndex){
                return false
            }

            canCook[recipe] = false
            for (neighbor in ingredients[recipeIndex[recipe]!!] ?: emptyList()){
                if (dfs(neighbor) == false){
                    return false
                }
            }
            canCook[recipe] = true
            return canCook[recipe]!!

        }

        val ans = mutableListOf<String>()

        for(recipe in recipes){
            if (dfs(recipe)){
                ans.add(recipe)
            }
        }
        return ans
    }
}

```

**Оценка по времени**: О(...)


**Оценка по памяти**: О(...)


**Описание решения**
```

```