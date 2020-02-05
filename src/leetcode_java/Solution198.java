package leetcode_java;

public class Solution198 {
    private int[] memoArr;

    public int rob(int[] nums) {
        if(nums.length == 0) return 0;

        memoArr = new int[nums.length];
        for(int i=0;i<nums.length;i++){
            memoArr[i] = -1;
        }
        helper(0, 0, nums);
        return memoArr[nums.length-1];
    }

    private int helper(int curIdx, int total, int[] nums){

        if(curIdx >= nums.length) return memoArr[nums.length-1];
        if(memoArr[curIdx] != -1) return memoArr[curIdx];

        if(curIdx>1){
            memoArr[curIdx] = Math.max(memoArr[curIdx-1], memoArr[curIdx-2]+nums[curIdx]);
        }else if(curIdx == 0){
            memoArr[curIdx] = nums[curIdx];
        }else if(curIdx == 1){
            memoArr[curIdx] = (nums[curIdx-1]>nums[curIdx])? nums[curIdx-1] : nums[curIdx];
        }

        helper(curIdx+1, total, nums);
        helper(curIdx+2, total+nums[curIdx], nums);

        return memoArr[curIdx];
    }
}
