package leetcode_java;

/*
1. Problem
- Find the length of the longest substring without repeating characters in a string.
- example1) "abcabcbb"
            "abc" string at the beginning has no same characters.
            but if moving next character, "abca",  'a' appears two times. so "abca" doesn't satisfy "no repeating" condition.
            "bca" (index 1 to 3) is substring without repeating characters but it isn't sure that is the "longest" or not.

2. Constraints
- only small characters

3. Algorithm
words   start-idx   end-idx     max-length
a       0           0           1
ab      0           1           2
abc     0           2           3
//start-idx move at the beggining point which doen't contain 'a'
abca(x) 0->1        3           -
bca     1           3           3
bcab(x) 1->2        4           -
cab     2           4           3
cabc(x) 2->3        5           -
abc     3           5           3
abcb(x) 3->5        6           -
cb      5           6           3
cbb(x)  5->7        7           -
b       7           7           3

4. Time Complexity
- O(nm)
 */

import java.util.HashMap;
import java.util.Map;

public class Solution3 {
    public int lengthOfLongestSubstring(String s) {
        if(s.equals("")) return 0;

        char[] sChArr = s.toCharArray();
        Map<Character, Integer> strMap = new HashMap<>(); //char, idx
        int maxLen = 0;
        int startIdx = 0;
        int endIdx = 0;

        strMap.put(sChArr[0], 0);
        maxLen = 1;
        for(int i=1 ; i<sChArr.length ; i++) {
            int tempLen = 0;
            if(strMap.containsKey(sChArr[i])){
                int keyIdx = strMap.get(sChArr[i]);
                for(int j=startIdx ; j<=keyIdx ; j++){
                    strMap.remove(sChArr[j]);
                }
                startIdx = keyIdx+1;
            }
            strMap.put(sChArr[i], i);
            endIdx = i;
            tempLen = endIdx-startIdx+1;
            if(tempLen>maxLen) maxLen = tempLen;
        }
        return maxLen;
    }
}