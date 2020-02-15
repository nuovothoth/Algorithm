package leetcode_java;

import java.util.Arrays;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution654 {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        TreeNode rootNode = new TreeNode(nums[0]);
        int maxVal = nums[0];
        int maxIdx = 0;
        if(nums.length == 1) return rootNode;

        for(int i=1;i<nums.length;i++){
            if(maxVal<nums[i]){
                maxVal = nums[i];
                maxIdx = i;
            }
        }
        rootNode.val = maxVal;

        //helper(rootNode, Arrays.copyOfRange(nums, 0, maxIdx), Arrays.copyOfRange(nums, maxIdx+1, nums.length));
        helper(rootNode, 0, maxIdx-1, maxIdx+1, nums.length-1, nums);
        return rootNode;
    }

    /*First Solution*/
    /*
    private void helper(TreeNode curNode, int[] leftArr, int[] rightArr){
        if(curNode == null) return;

        if(leftArr.length > 0){
            int leftMax = leftArr[0];
            int leftMaxIdx = 0;
            for(int i=1;i<leftArr.length;i++){
                if(leftMax<leftArr[i]){
                    leftMax = leftArr[i];
                    leftMaxIdx = i;
                }
            }

            curNode.left = new TreeNode(leftMax);
            helper(curNode.left, Arrays.copyOfRange(leftArr, 0, leftMaxIdx), Arrays.copyOfRange(leftArr, leftMaxIdx+1, leftArr.length));
        }

        if(rightArr.length > 0){
            int rightMax = rightArr[0];
            int rightMaxIdx = 0;
            for(int i=1;i<rightArr.length;i++){
                if(rightMax<rightArr[i]){
                    rightMax = rightArr[i];
                    rightMaxIdx = i;
                }
            }

            curNode.right = new TreeNode(rightMax);
            helper(curNode.right, Arrays.copyOfRange(rightArr, 0, rightMaxIdx), Arrays.copyOfRange(rightArr, rightMaxIdx+1, rightArr.length));
        }
    }
    */

    /*Second Solution*/
    private void helper(TreeNode curNode, int leftStart, int leftEnd, int rightStart, int rightEnd, int[] nums){
        if(leftStart <= leftEnd){
            int leftMax = nums[leftStart];
            int leftMaxIdx = leftStart;
            for(int i=leftStart;i<=leftEnd;i++){
                if(leftMax<nums[i]){
                    leftMax = nums[i];
                    leftMaxIdx = i;
                }
            }

            curNode.left = new TreeNode(leftMax);
            helper(curNode.left, leftStart, leftMaxIdx-1, leftMaxIdx+1, leftEnd, nums);
        }

        if(rightStart <= rightEnd){
            int rightMax = nums[rightStart];
            int rightMaxIdx = rightStart;
            for(int i=rightStart;i<=rightEnd;i++){
                if(rightMax<nums[i]){
                    rightMax = nums[i];
                    rightMaxIdx = i;
                }
            }

            curNode.right = new TreeNode(rightMax);
            helper(curNode.right, rightStart, rightMaxIdx-1, rightMaxIdx+1, rightEnd, nums);
        }
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
