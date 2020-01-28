package leetcode_java;

/*
1. Problem
- We have a dictionary called 'wordDict' that contains a few words.
- We also have one string, 's'
- If it's possible to make 's' with combination of some of words in 'wordDict', return true. Or if not, return false
- The number of using each words in 'wordDict' can be more than once.

2. Constraints & Edge Case


3. Algorithm (DP)
- 1. Decide the end index of substring of 's'. this step is repeated from index 0 to s.length()-1 of 's'.
- 2. Every 1. loop, check if 'wordDict' contains the substring as the start index is moved through 0 to the end index.
- if 2's result is true and also the substring in front of the 2's substring exists, the substring at that end index will return true.
- if 2's result is false or the substring before the 2's substring doesn't exists, go to next start index.
- 3. Repeat until the end index is the end of 's', return the last result.

4. Time Complexity
- O(nm)
 */

import java.util.List;

public class Solution139 {
    Boolean[] boolArr;
    public boolean wordBreak(String s, List<String> wordDict) {
        if(s==null || s.length()==0) return false;

        boolArr = new Boolean[s.length()];
        for(int i=0;i<s.length();i++){
            boolArr[i] = false;
        }

        for(int i=0;i<s.length();i++){
            helper(0, i, s, wordDict);
        }
        return boolArr[s.length()-1];
    }

    private void helper(int curIdx, int endIdx, String s, List<String> wordDict){
        if(curIdx>endIdx) return;

        String sub = s.substring(curIdx, endIdx+1);
        if(wordDict.contains(sub) && (curIdx == 0 || boolArr[curIdx-1])){
            boolArr[endIdx] = true;
        }else{
            helper(curIdx+1, endIdx, s, wordDict);
        }
    }
}
