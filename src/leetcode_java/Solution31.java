package leetcode_java;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/*
1. Problem
- To get the next permutation (permutation means arrangement of numbers as ascending order in this case.)
- If there isn't the next permutation, just return sorted one of a nums array by ascending order.
- example)  permutation step of {1, 2, 3}
            1,2,3 -> 1,3,2 -> 2,1,3 -> 2,3,1 -> 3,1,2 -> 3,2,1
            <Case1>
            Input: 1,2,3    Output: 1,3,2
            <Case2>
            Input: 2,1,3    Output: 2,3,1

2. Constraints & Edge Case
- if the length of a nums array is less than 1, it's not needed to find permutation.

3. Algorithm
-   if nums[n-1]<nums[n]
    -> put nums[n-1] into arraylist (be able to use count sort, but it returns bad performance.)
    -> pull out the number which is just larger than nums[n-1] from arraylist and assign that number in nums[n-1]
    -> from nums[n] to nums[nums.length-1], fill with ascending order of the numbers in arraylist.
    -> DONE.
-   if nums[n-1]>nums[n]
    -> put nums[n-1] to arraylist
    -> check next step (n->n+1)
- if n is over than nums.length-1, just arrange the nums array as ascending order.

4. Time Complexity
- O(nm)
 */

public class Solution31 {
    public void nextPermutation(int[] nums) {
        if(nums.length<2) return;
        List<Integer> sortedList = new ArrayList<>();
        int curIdx = 0;

        sortedList.add(nums[nums.length-1]);
        for(int i=nums.length-2;i>-1;i--){
            if(nums[i]<nums[i+1]){
                sortedList.add(nums[i]);

                Collections.sort(sortedList);
                for(Integer item: sortedList){
                    if(item>nums[i]){
                        nums[i] = item;
                        sortedList.remove(item);
                        break;
                    }
                }
                curIdx = i+1;
                break;
            }else{
                sortedList.add(nums[i]);
            }
        }


        if(curIdx==0) Collections.sort(sortedList);
        for(Integer item: sortedList){
            nums[curIdx++] = item;
        }
    }

    //first solution. bad performance.
    /*
    * public void nextPermutation(int[] nums) {
        if(nums.length<2) return;
        int[] countSortArr = new int[101];
        int numsSize = nums.length;
        boolean isInLoop = false;

        countSortArr[nums[numsSize-1]]++;
        //System.out.println("nums[numsSize-1]: "+nums[numsSize-1]);
        for(int i=numsSize-2;i>-1;i--){
            System.out.println("1");
            if(nums[i]<nums[i+1]){
                countSortArr[nums[i]]++;
                //System.out.println("nums[i]: "+nums[i]);
                //System.out.println("2");
                for(int j=nums[i]+1;j<countSortArr.length;j++){
                    //System.out.println("3");
                    if(countSortArr[j]>0){
                        //System.out.println("4");
                        nums[i] = j;
                        //System.out.println("j: "+j);
                        countSortArr[j]--;
                        break;
                    }
                }

                int curIdx = i+1;
                for(int j=0;j<countSortArr.length;j++){
                    while(countSortArr[j]>0){
                        //System.out.println("nums["+curIdx+"]: "+j);
                        nums[curIdx++] = j;
                        countSortArr[j]--;
                    }
                }
                isInLoop = true;
                break;
            }else{
                countSortArr[nums[i]]++;
            }
        }

        if(!isInLoop){
            int curIdx = 0;
            for(int j=0;j<countSortArr.length;j++){
                while(countSortArr[j]>0){
                    nums[curIdx++] = j;
                    countSortArr[j]--;
                }
            }
        }
    }
    * */
}
