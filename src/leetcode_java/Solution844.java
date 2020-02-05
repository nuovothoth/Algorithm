package leetcode_java;

import java.util.Stack;

public class Solution844 {
    public boolean backspaceCompare(String S, String T) {
        Stack<Character> sStack = new Stack<>();
        Stack<Character> tStack = new Stack<>();
        char[] sChArr = S.toCharArray();
        char[] tChArr = T.toCharArray();

        for(char s: sChArr){
            if(s == '#'){
                if(!sStack.isEmpty()){
                    sStack.pop();
                }
            }else{
                sStack.push(s);
            }
        }

        for(char t: tChArr){
            if(t == '#'){
                if(!tStack.isEmpty()){
                    tStack.pop();
                }
            }else{
                tStack.push(t);
            }
        }

        if(sStack.size() != tStack.size()){
            return false;
        }else{
            while(!sStack.isEmpty()){
                if(sStack.peek() == tStack.peek()){
                    sStack.pop();
                    tStack.pop();
                }else{
                    return false;
                }
            }
        }

        return true;
    }
}
