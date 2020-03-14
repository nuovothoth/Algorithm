package leetcode_java;

public class Solution413 {
    public int numberOfArithmeticSlices(int[] A) {
        if(A.length==0) return 0;

        int count = 0;
        int curIdx = 1;
        int[] gap = new int[A.length-1];

        for(int i=1;i<A.length;i++){
            gap[i-1] = A[i]-A[i-1];
        }

        while(curIdx<gap.length){
            int sameGapCount = 1;
            while(curIdx<gap.length && gap[curIdx-1]==gap[curIdx++]){
                sameGapCount++;
            }
            count+=getNum(sameGapCount);
        }

        return count;
    }

    private int getNum(int n){
        int result = 0;

        for(int i=n-1;i>0;i--){
            result+=i;
        }

        return result;
    }
}
