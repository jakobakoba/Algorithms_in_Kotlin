Line 14: Exception in thread "main" 
java.lang.ArrayIndexOutOfBoundsException: -1
написал prefix вместо postfix

WA 549 / 746
в условии написано leftmost pivot index. поэтому нужно идти слева 
направо. Нельзя на ходу справа уже искать ответ. Сначала
нужно построить prefix and postfix.