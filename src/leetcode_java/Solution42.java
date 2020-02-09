package leetcode_java;

/*
1. Problem
- Calculating total amount of trapped water in between bars.

2. Constraints & Edge Case
- If there is no bars in array, it returns 0.

3. Algorithm
<Brute Force>
- Let's consider the y-axis instead of x-axis as target.
    Then the minimum value can be 1 and maximum one can be the longest height among bars.
- In an each inner while loop, search the leftmost and rightmost point which matches curHeight. (These will be a barrier which traps the water.)
- Then count the number of point which is not filled with bar from leftmost index to rightmost index.
- The outer while loop is finished when the leftmost point(index) is greater than or equal to rightmost point.

<Pivoting>
- Let's consider the x-axis.
- Start two pivots from leftmost and rightmost.
- The height of each pivot should be the highest one among previous height of bars.
- If the height with leftmost index is lower than rightmost one, we compare the height of leftmost one with next point of that and update the leftmost index after the below step is over.
    If not, the same process will be done for rightmost index.
- If the height of next point of pivot (if the pivot is leftmost, the next will be leftmost+1, or rightmost-1) is lower than pivot,
    we can count the gap between pivot and the height of next point as the amount of trapped water.
    But if not, we update the next point as leftmost or rightmost.
- The above 2 steps will be repeated until leftmost<rightmost.

4. Time Complexity
<Brute Force>
- O(mn)

<Pivoting>
- O(n)
 */

public class Solution42 {
    //Pivoting
    public int trap(int[] height) {
        if(height.length == 0) return 0;

        int count = 0;

        int leftIdx = 0;
        int rightIdx = height.length-1;

        int leftMaxHeight = height[leftIdx];
        int rightMaxHeight = height[rightIdx];

        while(leftIdx<rightIdx){
            if(height[leftIdx]<height[rightIdx]){
                if(leftMaxHeight>height[leftIdx]){
                    count+=(leftMaxHeight-height[leftIdx]);
                }else{
                    leftMaxHeight = height[leftIdx];
                }
                leftIdx++;
            }else{
                if(rightMaxHeight>height[rightIdx]){
                    count+=(rightMaxHeight-height[rightIdx]);
                }else{
                    rightMaxHeight = height[rightIdx];
                }
                rightIdx--;
            }
        }

        return count;
    }

    //Brute Force
    /*
    public int trap(int[] height) {
        if(height.length == 0) return 0;

        int count = 0;
        int leftIdx = 0;
        int rightIdx = height.length-1;
        int curHeight = 1;

        while(true){
            while(height[leftIdx]<curHeight && leftIdx<height.length-1){
                leftIdx++;
            }

            while(height[rightIdx]<curHeight && rightIdx>0){
                rightIdx--;
            }

            int tempLeftIdx = leftIdx;
            int tempRightIdx = rightIdx;
            if(tempLeftIdx<tempRightIdx){
                while(tempLeftIdx<tempRightIdx){
                    if(height[tempLeftIdx]<curHeight) count++;
                    tempLeftIdx++;
                }
                curHeight++;
            }else{
                break;
            }
        }

        return count;
    }
    */
}
