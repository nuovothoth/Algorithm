package leetcode_java;

public class Solution256 {
    int min;
    int[][] minCostArr;

    public int minCost(int[][] costs) {
        min = Integer.MAX_VALUE;
        minCostArr = new int[costs.length][3];

        for(int i=0;i<3;i++){
            int temp = helper(costs, 0, i);
            if(min>temp) min = temp;
        }

        return min;
    }

    private int helper(int[][] costs, int curHouseIdx, int curColorIdx){
        if(curHouseIdx >= costs.length) return 0;
        if(minCostArr[curHouseIdx][curColorIdx]!=0) return minCostArr[curHouseIdx][curColorIdx];

        int sum = 0;
        switch(curColorIdx){
            case 0:
                sum = costs[curHouseIdx][curColorIdx] + (Math.min(helper(costs, curHouseIdx+1, 1), helper(costs, curHouseIdx+1, 2)));
                break;
            case 1:
                sum = costs[curHouseIdx][curColorIdx] + (Math.min(helper(costs, curHouseIdx+1, 0), helper(costs, curHouseIdx+1, 2)));
                break;
            case 2:
                sum = costs[curHouseIdx][curColorIdx] + (Math.min(helper(costs, curHouseIdx+1, 0), helper(costs, curHouseIdx+1, 1)));
                break;
        }

        minCostArr[curHouseIdx][curColorIdx] = sum;
        return sum;
    }
}
