package leetcode_java;

public class Solution647 {
    public int countSubstrings(String s) {
        char[] sChArr = s.toCharArray();
        int count = sChArr.length;

        for(int i=0;i<sChArr.length;i++){
            count+=getEvenPalNum(sChArr, i);
            count+=getOddPalNum(sChArr, i);
        }

        return count;
    }

    private int getEvenPalNum(char[] sChArr, int startIdx){
        int result = 0;
        int offset = 0;
        while(startIdx-offset>-1 && startIdx+1+offset<sChArr.length){
            if(sChArr[startIdx-offset] == sChArr[startIdx+1+offset]){
                result++;
                offset++;
            }else{
                break;
            }
        }

        return result;
    }

    private int getOddPalNum(char[] sChArr, int startIdx){
        int result = 0;
        int offset = 1;
        while(startIdx-offset>-1 && startIdx+offset<sChArr.length){
            if(sChArr[startIdx-offset] == sChArr[startIdx+offset]){
                result++;
                offset++;
            }else{
                break;
            }
        }

        return result;
    }
}
