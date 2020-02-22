package leetcode_java;

import java.util.HashMap;
import java.util.Map;

public class Solution6 {
    public String convert(String s, int numRows) {
        if(numRows == 1) return s;

        Map<Integer, String> strMap = new HashMap<>();
        int curIdx = 0;
        int curRow = 0;
        boolean isInverseDir = true;
        String resultStr = "";

        for(int i=0;i<numRows;i++){
            strMap.put(i, "");
        }

        while(curIdx<s.length()){
            strMap.put(curRow, strMap.get((Integer)curRow)+s.charAt(curIdx));
            if(isInverseDir){
                curRow++;
                if(curRow==numRows){
                    isInverseDir = false;
                    curRow-=2;
                }
            }else{
                curRow--;
                if(curRow==-1){
                    isInverseDir = true;
                    curRow+=2;
                }
            }
            curIdx++;
        }

        for(int i=0;i<numRows;i++){
            resultStr+=strMap.get((Integer)i);
        }

        return resultStr;
    }
}
