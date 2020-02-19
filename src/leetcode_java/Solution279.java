package leetcode_java;

public class Solution279 {
    public int numSquares(int n) {
        int startWidth = (int)Math.sqrt(n);
        int[] cache = new int[n+1];
        cache[1] = 1;
        for(int i=2;i<=n;i++){
            int iSqrt = (int)Math.sqrt(i);
            if(iSqrt*iSqrt == i){
                cache[i] = 1;
            }else{
                int min = Integer.MAX_VALUE;
                for(int j=1;j<(i/2+1);j++){
                    min = Math.min(min, cache[i-j]+cache[j]);
                }
                cache[i] = min;
            }
        }

        return cache[n];
    }
}
