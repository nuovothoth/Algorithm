import java.util.Stack;

/*
1. Problem
- There are 3 types of bracket.
- Input string contains of some brackets.
- Determine whether the brackets in this string make a pair and right order of open and close.
- example 1) "()" is the pair of parentheses and the close bracket places right after open bracket. -> true
- example 2) "([)]" has two pair of brackets but each pair of the outer and inner bracket didn't match. -> false

2. Constraints
- we have 3 types of brackets. '(', ')', '{', '}', '[' and ']'

3. Algorithm
- Stack: this data structure keeps FILO(First In Last Out)

4. Time Complexity
- O(n)
 */
public class Solution20 {
    public boolean isValid(String s) {
        char[] sChArr = s.toCharArray();
        Stack<Character> charStack = new Stack<>();

        for (char ch: sChArr) {
            //'(', '{', '[' is open bracket, start point. just restore in stack.
            //')', '}', ']' is close bracket. At this point, we have to check if the bracket right before this bracket is the pair bracket of this.
            switch (ch) {
                case '(' :
                    charStack.push('(');
                    break;
                case '{' :
                    charStack.push('{');
                    break;
                case '[' :
                    charStack.push('[');
                    break;
                case ')' :
                    if(!charStack.isEmpty() && charStack.peek() == '(') charStack.pop();
                    else return false;
                    break;
                case '}' :
                    if(!charStack.isEmpty() && charStack.peek() == '{') charStack.pop();
                    else return false;
                    break;
                case ']' :
                    if(!charStack.isEmpty() && charStack.peek() == '[') charStack.pop();
                    else return false;
                    break;
            }
        }

        //In cases of "(((" "{{}{({[{"... (open bracket is more than close bracket), we should be sure to stack is empty.
        if(charStack.isEmpty()) return true;
        else return false;
    }
}
