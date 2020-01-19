package leetcode_java;

/*
1. Problem
- Find the index of a nums array which number of element at the index is equal to target.
- The time complexity of a solution is less than O(log n).

2. Constraints
- There is no duplicate in the array.

3. Algorithm
if> nums[0]<nums[nums.length-1]: just pure ascending order. -> binary search.
if> nums[0]>nums[nums.length-1]: the index of the minimum number in the array isn't 0. (not pure)
    In this case, if> nums[n]>nums[n+1]: nums[n] is maximum number in a nums array.
3-1. Edge Case
The legnth of a nums array is 0. -> always return -1.
The legnth of a nums array is 1. -> binary search is impossible. just check first index.


4. Time Complexity
- O(n)
 */

public class Solution33 {
    public int search(int[] nums, int target) {
        int numsSize = nums.length;

        if(numsSize==0) return -1;
        if(numsSize==1){
            if(nums[0] == target) return 0;
            else return -1;
        }

        if(nums[0]<nums[numsSize-1]){//normal case -> binary search
            return binarySearch(0, numsSize-1, target, nums);
        }else{//find the maxPoint
            int startIdx = numsSize-nums[numsSize-1]-2;
            if(startIdx<0) startIdx = 0;
            while(startIdx<numsSize-1 && nums[startIdx]<nums[startIdx+1]) startIdx++;

            if(target == nums[numsSize-1]) return numsSize-1;
            if(target == nums[startIdx]) return startIdx;
            if(target<nums[numsSize-1]){//find the idx with right-side of startIdx.
                return binarySearch(startIdx, numsSize-1, target, nums);
            }else{
                return binarySearch(0, startIdx, target, nums);
            }
        }
    }

    private int binarySearch(int leftIdx, int rightIdx, int target, int[] numsArr){
        int midIdx = 0;

        while(leftIdx<=rightIdx){
            midIdx = (leftIdx+rightIdx)/2;
            if(numsArr[midIdx] == target) return midIdx;
            if(leftIdx == midIdx) leftIdx++;
            else if(numsArr[midIdx] > target) rightIdx = midIdx;
            else leftIdx = midIdx;
        }

        return -1;
    }
}
