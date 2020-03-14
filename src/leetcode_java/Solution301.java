package leetcode_java;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution301 {
    List<String> resultList;
    int maxLength = 0;

    public List<String> removeInvalidParentheses(String s) {
        resultList = new ArrayList<>();

        while(s.length()>0){
            if(s.charAt(0)==')'){
                s = s.substring(1);
            }else{
                break;
            }
        }

        while(s.length()>0){
            if(s.charAt(s.length()-1)=='('){
                s = s.substring(0, s.length()-1);
            }else{
                break;
            }
        }

        System.out.println("s: "+s);
        for(int i=0;i<s.length();i++){
            helper(s, i, "");
        }

        if(resultList.isEmpty()) resultList.add("");
        return resultList;
    }

    private void helper(String s, int curIdx, String resultStr){
        if(curIdx == s.length()){
            if(isValid(resultStr)){
                int strLength = resultStr.length();
                if(resultList.isEmpty()){
                    maxLength = strLength;
                    resultList.add(resultStr);
                }else{
                    if(maxLength<strLength){
                        resultList = new ArrayList<>();
                        resultList.add(resultStr);
                        maxLength=strLength;
                    }else if(maxLength==strLength){
                        if(!resultList.contains(resultStr)) resultList.add(resultStr);
                    }
                }
            }
        }

        for(int i=curIdx+1;i<=s.length();i++){
            helper(s, i, resultStr+s.charAt(curIdx));
        }
    }

    private boolean isValid(String s){
        char[] sChArr = s.toCharArray();
        Stack<Character> chStack = new Stack<>();

        for(int i=0;i<sChArr.length;i++){
            if(sChArr[i] == '('){
                chStack.push(sChArr[i]);
            }else if(sChArr[i] == ')'){
                if(chStack.isEmpty()){
                    return false;
                }else{
                    chStack.pop();
                }
            }
        }

        if(chStack.isEmpty()) return true;
        else return false;
    }
}
