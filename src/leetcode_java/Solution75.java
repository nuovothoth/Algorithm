package leetcode_java;

public class Solution75 {
    public void sortColors(int[] nums) {
        int[] sortCount = new int[3];
        int idx = 0;

        for(int i=0;i<nums.length;i++){
            sortCount[nums[i]]++;
        }

        for(int i=0;i<3;i++){
            for(int j=0;j<sortCount[i];j++){
                nums[idx++] = i;
            }
        }
    }
}
