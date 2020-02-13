package leetcode_java;

public class Solution34 {
    public int[] searchRange(int[] nums, int target) {
        int[] resultArr = {-1, -1};

        if(nums.length==0) return resultArr;

        int left = 0;
        int right = nums.length-1;
        int mid = 0;

        while(left<=right){
            mid = (left+right)/2;
            if(target>nums[mid]){
                left = mid+1;
            }else if(target<nums[mid]){
                right = mid-1;
            }else{
                break;
            }
        }

        if(left<=right){
            left = mid;
            right = mid;
            while(left>0 && nums[left-1]==target){
                left--;
            }
            while(right<nums.length-1 && nums[right+1]==target){
                right++;
            }
            resultArr[0] = left;
            resultArr[1] = right;
        }

        return resultArr;
    }
}
