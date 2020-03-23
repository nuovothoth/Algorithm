package leetcode_java;

public class Solution70 {
    /*Top-Down Approach*/
    private int[] countArr;

    public int climbStairs(int n) {
        countArr = new int[n+1];
        return getWayCount(n);
    }

    private int getWayCount(int n){
        if(n<0){
            return 0;
        }else if(n==0){
            return 1;
        }

        if(countArr[n]!=0) return countArr[n];
        countArr[n]=getWayCount(n-2)+getWayCount(n-1);
        return countArr[n];
    }

    /*Bottom-Up Approach*/
    /*
    public int climbStairs(int n) {
        int[] countArr = new int[n+1];
        countArr[1] = 1;
        if(n>1){
            countArr[2] = 2;

            for(int i=3;i<=n;i++){
                countArr[i] = countArr[i-1]+countArr[i-2];
            }
        }

        return countArr[n];
    }
    */
}
