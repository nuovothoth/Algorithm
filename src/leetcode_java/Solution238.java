package leetcode_java;

/*
1. Problem
- To get the array A which size is same of an array nums.
- The index i's element in A is result of product of all the element in nums except the number of index i.
- example)  Input:      [1, 2, 3, 4]
            A[0]:       2*3*4
            A[1]:       1*3*4
            A{2]:       1*2*4
            A[3]:       1*2*3
            result A:   [24, 12, 8, 6]

2. Constraints
- The length of an array nums is more than 1.
- Don't use Division.
- The time complexity should be less than O(n).

3. Algorithm
- We can split two chunk from an array nums, one is left-side of some element and the other is right-side of one.
- The both of chunks don't contain index i when that chunks are split at index i.
- We can reuse the total of left product and right one from right before step.

4. Time Complexity
- O(n)
 */

public class Solution238 {
    public int[] productExceptSelf(int[] nums) {
        int numsSize = nums.length;
        int[] outputArr = new int[numsSize];
        int left = nums[0];
        int right = nums[numsSize-1];

        for(int i=0 ; i<numsSize ; i++) outputArr[i] = 1;
        for(int i=1 ; i<numsSize-1 ; i++){
            outputArr[i]*=left;
            left*=nums[i];
            outputArr[numsSize-1-i]*=right;
            right*=nums[numsSize-1-i];
        }

        outputArr[0] = right;
        outputArr[numsSize-1] = left;

        return outputArr;
    }
}
