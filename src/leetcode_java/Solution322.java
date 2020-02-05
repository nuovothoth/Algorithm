package leetcode_java;

import java.util.Arrays;

public class Solution322 {
    int min = -1;

    public int coinChange(int[] coins, int amount) {
        Arrays.sort(coins);
        return getCoinCount(coins, coins.length-1, 0, amount);
    }

    private int getCoinCount(int[] coins, int curIdx, int coinCount, int leftAmount){
        if(leftAmount == 0) return coinCount;
        if(leftAmount < 0) return -1;
        if(curIdx<0) return -1;

        if(leftAmount%coins[curIdx]==0){
            return coinCount+(leftAmount/coins[curIdx]);
        }

        if(leftAmount-coins[curIdx]>0){
            int maxCoinCount = leftAmount/coins[curIdx];
            if(leftAmount == maxCoinCount*coins[curIdx]){
                return getCoinCount(coins, curIdx-1, coinCount+maxCoinCount, 0);
            }else{
                for(int i=maxCoinCount; i>-1; i--){
                    if(min!= -1 && min<coinCount+i) break;
                    int temp = getCoinCount(coins, curIdx-1, coinCount+i, leftAmount-(coins[curIdx]*i));
                    if(temp!= -1 && (min==-1 || min>temp)) min = temp;
                }
            }
            return min;
        }

        return getCoinCount(coins, curIdx-1, coinCount, leftAmount);
    }
}
