package leetcode_java;

public class Solution746 {
    /*Bottom-Up Approach*/
    /*
    public int minCostClimbingStairs(int[] cost) {
        for(int i=2;i<cost.length;i++){
            cost[i] = Math.min(cost[i-1], cost[i-2])+cost[i];
        }

        return Math.min(cost[cost.length-1], cost[cost.length-2]);
    }
    */

    /*Top-Down Approach*/
    private int[] minCostArr;

    public int minCostClimbingStairs(int[] cost) {
        minCostArr = new int[cost.length];
        for(int i=0;i<cost.length;i++){
            minCostArr[i] = -1;
        }

        helper(cost.length-1, cost);

        return Math.min(minCostArr[cost.length-1], minCostArr[cost.length-2]);
    }

    private int helper(int curIdx, int[] cost){
        if(curIdx == 0 || curIdx == 1) minCostArr[curIdx] = cost[curIdx];
        if(minCostArr[curIdx] != -1) return minCostArr[curIdx];

        minCostArr[curIdx] = Math.min(helper(curIdx-1, cost), helper(curIdx-2, cost))+cost[curIdx];
        return minCostArr[curIdx];
    }
}
