package leetcode_java;

public class Solution338 {
    public int[] countBits(int num) {
        int[] calcArr = new int[num+1];
        boolean isKeepGoing = true;
        int twoPower = 1;

        if(num>0){
            for(int i=1;i<=num;i++){
                calcArr[i] = 1;
            }

            while(isKeepGoing){
                int curNum = twoPower;
                twoPower *=2;
                for(int i=0;i+curNum<twoPower;i++){
                    if(i+curNum > num){
                        isKeepGoing = false;
                        break;
                    }
                    calcArr[i+curNum] += calcArr[i];

                }
            }
        }

        return calcArr;
    }
}
