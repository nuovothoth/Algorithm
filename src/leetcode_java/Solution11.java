package leetcode_java;

/*
1. Problem
- Find the area of container which the most water can be filled in.

2. Constraints & Edge Case
-

3. Algorithm
- We can think about two points in this problem, the width and the height.
- the Width, We don't have much things to think because the width between 0 index and n index is the longest, and i and i+1 is the shortest.
- The height, We have to just consider left-side line and right-side line of container (That means, we don't need to think about the middle lines.)
- Let's start the widest width (0 to n)
    -> Pick the line up which is shorter between height[0] and height[n].
    -> The value that shorter-line times width is max area.
    -> ***Next step*** (It's the key point of this solution!!!!)
        -> we choose "the next line of shorter line".
        (if height[n] is shorter, we select n-1 or height[0] is shorter, we select 0+1)
        (***Because, The possibility of longer line than prep one. Instead of shrinking width, height can be higher.)
- Repeat the above step until left index is smaller than right one.

4. Time Complexity
- O(n)
 */

public class Solution11 {
    public int maxArea(int[] height) {
        int maxSquare = 0;
        int leftIdx = 0;
        int rightIdx = height.length-1;

        while(leftIdx<rightIdx){
            int square;

            if(height[leftIdx]>height[rightIdx]){
                square = height[rightIdx]*(rightIdx-leftIdx);
                rightIdx--;
            }else{
                square = height[leftIdx]*(rightIdx-leftIdx);
                leftIdx++;
            }

            if(maxSquare<square) maxSquare = square;
        }

        return maxSquare;
    }
}
