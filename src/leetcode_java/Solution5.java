package leetcode_java;

/*
1. Problem
- Find the longest palindromic substring in a string.
- If there is a words and the words is as same as the reversed thing of that words, the words is palindromic string.
  examples) abcba, abccba, aabcbaa

2. Constraints
- The maximum length of a string is 1000

3. Algorithm
choice: The length of string -> even or add
        The start point for checking whether the string is palindromic or not
reusable point: -

4. Time Complexity
- O(nm)
 */

public class Solution5 {
    char[] sChArr;
    int startIdx = 0;
    int endIdx = 0;

    public String longestPalindrome(String s) {
        if(s.equals("")) return "";

        sChArr = s.toCharArray();
        String resultStr;

        for(int i=0 ; i<sChArr.length ; i++) {
            findPalindrom(i, true);
            findPalindrom(i, false);
        }

        resultStr = s.substring(startIdx, endIdx+1);

        return resultStr;
    }

    public void findPalindrom(int i, boolean isEven){ //i is startPoint
        int tempStartIdx;
        int tempEndIdx;
        int tempLength;

        if(isEven) tempStartIdx = i;
        else tempStartIdx = i-1;
        tempEndIdx = i+1;

        while(tempStartIdx>-1 && tempEndIdx<sChArr.length) {
            if(sChArr[tempStartIdx]!=sChArr[tempEndIdx]) {
                break;
            }
            tempStartIdx--;
            tempEndIdx++;
        }
        tempStartIdx++;
        tempEndIdx--;

        tempLength = tempEndIdx-tempStartIdx;
        if((isEven && tempLength>0) || !isEven) {
            if(endIdx-startIdx<tempLength) {
                startIdx = tempStartIdx;
                endIdx = tempEndIdx;
            }
        }
    }
}
