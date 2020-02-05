package leetcode_java;

public class Solution121 {
    public int maxProfit(int[] prices) {
        int pricesSize = prices.length;
        if(pricesSize == 0) return 0;

        int[] minPrices = new int[pricesSize];
        int[] maxPrices = new int[pricesSize];
        int maxGap = 0;

        minPrices[0] = prices[0];
        maxPrices[pricesSize-1] = prices[pricesSize-1];

        for(int i=1;i<pricesSize;i++){
            minPrices[i] = (prices[i]<minPrices[i-1])? prices[i]: minPrices[i-1];
            maxPrices[pricesSize-i-1] = (prices[pricesSize-i-1]>maxPrices[pricesSize-i])? prices[pricesSize-i-1] : maxPrices[pricesSize-i];
        }

        for(int i=0;i<pricesSize;i++){
            int tempVal = maxPrices[i]-minPrices[i];
            if(maxGap<tempVal) maxGap = tempVal;
        }

        return maxGap;
    }
}
