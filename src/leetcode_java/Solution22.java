package leetcode_java;

import java.util.ArrayList;
import java.util.List;

public class Solution22 {
    //start always '('
    //end always ')'
    //openCount > 0 : we can use both '(' and ')'.
    //openCount == 0 : we can use only ')'.
    //openCount > closeCount : IMPOSSIBLE (DON'T CARE).
    //openCount < closeCount: we can use ')' or '(' (-> just in openCount>0 case).
    //closeCount == 0: DONE.
    //'(' -> ')' or another '(' (if usable '(')
    //')' -> '(' (if usable '(') or !!another ')'!! (if used '(' is over than used ')')
    //if unusable '(' -> just use ')' (if usable ')')


    public List<String> generateParenthesis(int n) {
        List<String> combList = new ArrayList<>();

        return combList;
    }
}
