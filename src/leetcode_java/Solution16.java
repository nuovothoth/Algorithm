package leetcode_java;

import java.util.HashMap;
import java.util.Map;

public class Solution16 {
    public int threeSumClosest(int[] nums, int target) {
        Map<Integer, Integer> sumMap = new HashMap<>(); //sum, count;
        int offset = 0;

        for(int i=0;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
                for(int k=j+1; k<nums.length;k++){
                    int sum = nums[i]+nums[j]+nums[k];
                    if(!sumMap.containsKey(sum)) sumMap.put(sum, 1);
                }
            }
        }

        while(true){ //It is able to be used because of the condition "Each input would have exactly one solution".
            if(sumMap.containsKey(target+offset)){
                return target+offset;
            }

            if(sumMap.containsKey(target-offset)){
                return target-offset;
            }

            offset++;
        }
    }
}
