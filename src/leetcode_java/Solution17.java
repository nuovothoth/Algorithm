package leetcode_java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution17 {
    private static List<List<Character>> keyCharList;
    private List<String> returnList;

    public List<String> letterCombinations(String digits) {
        returnList = new ArrayList<>();

        if(digits.length()>0){
            char[] digitsChArr = digits.toCharArray();

            keyCharList = new ArrayList<List<Character>>();
            keyCharList.add(new ArrayList<>(Arrays.asList('a', 'b', 'c')));
            keyCharList.add(new ArrayList<>(Arrays.asList('d', 'e', 'f')));
            keyCharList.add(new ArrayList<>(Arrays.asList('g', 'h', 'i')));
            keyCharList.add(new ArrayList<>(Arrays.asList('j', 'k', 'l')));
            keyCharList.add(new ArrayList<>(Arrays.asList('m', 'n', 'o')));
            keyCharList.add(new ArrayList<>(Arrays.asList('p', 'q', 'r', 's')));
            keyCharList.add(new ArrayList<>(Arrays.asList('t', 'u', 'v')));
            keyCharList.add(new ArrayList<>(Arrays.asList('w', 'x', 'y', 'z')));

            helper(digitsChArr, 0, 0, "");
        }

        return returnList;
    }

    private void helper(char[] digitsChArr, int curDigitIdx, int curKeyIdx, String curStr){
        if(curDigitIdx == digitsChArr.length){
            returnList.add(curStr);
            return;
        }

        int digit = digitsChArr[curDigitIdx] - '0';
        digit-=2;
        String str;
        if(digit == 5 || digit == 7){
            for(int i=0;i<4;i++){
                str = curStr+(keyCharList.get((Integer)digit)).get((Integer)i);
                helper(digitsChArr, curDigitIdx+1, i, str);
            }
        }else{
            for(int i=0;i<3;i++){
                str = curStr+(keyCharList.get((Integer)digit)).get((Integer)i);
                helper(digitsChArr, curDigitIdx+1, i, str);
            }
        }
    }
}
