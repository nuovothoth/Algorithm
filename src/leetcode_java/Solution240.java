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

public class Solution240 {
    int[][] visitedMatrix;
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix.length == 0) return false;

        visitedMatrix = new int[matrix.length][matrix[0].length];

        if(matrixTracking(matrix, 0, 0, target, visitedMatrix)) return true;

        return false;
    }

    public boolean matrixTracking(int[][] matrix, int x, int y, int target, int[][] visitedMatrix){
        if(x<0 || x>matrix.length-1 || y<0 || y>matrix[0].length-1) return false;
        if(matrix[x][y] == target) return true;

        if(visitedMatrix[x][y] == 0){
            visitedMatrix[x][y] = 1;
            if(matrix[x][y]<target){
                if(matrixTracking(matrix, x+1, y, target, visitedMatrix)) return true;
                if(matrixTracking(matrix, x, y+1, target, visitedMatrix)) return true;
            }else{
                if(matrixTracking(matrix, x-1, y, target, visitedMatrix)) return true;
                if(matrixTracking(matrix, x, y-1, target, visitedMatrix)) return true;
            }
        }

        return false;
    }
}
