package leetcode_java;

import java.util.ArrayList;
import java.util.List;

public class Solution134 {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        List<Integer> startIdxList = new ArrayList<>();

        for(int i=0;i<gas.length;i++){
            if(gas[i]>=cost[i]) startIdxList.add(i);
        }

        for(Integer startIdx: startIdxList){
            int curGas = 0;
            int curIdx = startIdx;
            boolean isFirst = true;
            while(isFirst || curGas>=0){
                curGas += gas[curIdx];
                if(!isFirst && curIdx==startIdx){
                    return startIdx;
                }
                isFirst = false;
                curGas-=cost[curIdx];
                curIdx++;
                if(curIdx>=gas.length) curIdx = 0;
            }

        }

        return -1;
    }
}
