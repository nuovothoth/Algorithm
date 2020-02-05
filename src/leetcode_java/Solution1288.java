package leetcode_java;

public class Solution1288 {
    public int removeCoveredIntervals(int[][] intervals) {
        int resultVal = 0;

        for(int i=0;i<intervals.length;i++){
            for(int j=0;j<intervals.length;j++){
                if(intervals[i][0] == -1) break;
                if(i!=j && intervals[j][0]!=-1){
                    if(intervals[i][0]<=intervals[j][0] && intervals[i][1]>=intervals[j][1]) intervals[j][0] = intervals[j][1] = -1;
                }
            }
        }

        for(int i=0;i<intervals.length;i++){
            if(intervals[i][0]!=-1) resultVal++;
        }

        return resultVal;
    }
}
