package leetcode_java;

public class Solution96 {
    int[] cache;

    public int numTrees(int n) {
        if(n == 1 || n == 2){
            return n;
        }

        cache = new int[n+1];
        cache[1] = 1;
        cache[2] = 2;

        for(int i=3;i<=n;i++){
            int left = 0;
            int right = i-1-left;

            while(left<i){
                if(left == 0){
                    cache[i] += cache[right];
                }else if(right == 0){
                    cache[i] += cache[left];
                }else{
                    cache[i] += (cache[left]*cache[right]);
                }

                left++;
                right--;
            }
        }

        return cache[n];
    }
}
