package leetcode_java;

import java.util.ArrayList;
import java.util.List;

public class Solution1272 {
    class Solution {
        public List<List<Integer>> removeInterval(int[][] intervals, int[] toBeRemoved) {
            List<List<Integer>> resultList = new ArrayList<>();
            List<Integer> tempList = new ArrayList<>();
            int startIdx = 0;
            int minStartIdx = 0;
            int endIdx = 0;

            while(startIdx<intervals.length){
                if(intervals[startIdx][0] >=  toBeRemoved[1]) break;

                if(intervals[startIdx][0] < toBeRemoved[0]){
                    tempList.add(intervals[startIdx][0]);
                    startIdx++;
                    if(startIdx<intervals.length && intervals[endIdx][1] < intervals[startIdx][0]){
                        if(intervals[endIdx][1] < toBeRemoved[0]){
                            tempList.add(intervals[endIdx][1]);
                        }else{
                            tempList.add(toBeRemoved[0]);
                        }
                        resultList.add(tempList);
                        tempList = new ArrayList<>();
                        endIdx++;
                    }
                }else{
                    if(intervals[startIdx][0] >= intervals[endIdx][1]){
                        endIdx++;
                    }else if(intervals[endIdx][1] >= toBeRemoved[0]){
                        if(intervals[endIdx][1] >= toBeRemoved[1]){
                            tempList = new ArrayList<>();
                            tempList.add(toBeRemoved[1]);
                            tempList.add(intervals[endIdx][1]);
                            resultList.add(tempList);
                            tempList = new ArrayList<>();
                        }else{
                            if(tempList.size()>0){
                                tempList.add(toBeRemoved[0]);
                                resultList.add(tempList);
                            }
                        }
                        startIdx++;
                    }
                }
            }

            if(tempList.size()>0){
                if(intervals[endIdx][1] < toBeRemoved[0]){
                    tempList.add(intervals[endIdx][1]);
                    resultList.add(tempList);
                }else if(intervals[endIdx][1] < toBeRemoved[1]){
                    tempList.add(toBeRemoved[0]);
                    resultList.add(tempList);
                }else{
                    tempList.add(toBeRemoved[0]);
                    resultList.add(tempList);
                    tempList = new ArrayList<>();
                    tempList.add(toBeRemoved[1]);
                    tempList.add(intervals[endIdx][1]);
                    resultList.add(tempList);
                }
            }

            while(startIdx<intervals.length){
                if(intervals[startIdx][0]>=intervals[endIdx][1]){
                    endIdx++;
                }else{
                    tempList = new ArrayList<>();
                    tempList.add(intervals[startIdx++][0]);
                    tempList.add(intervals[endIdx++][1]);
                    resultList.add(tempList);
                }
            }

            return resultList;
        }
    }
}
