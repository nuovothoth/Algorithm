package leetcode_java;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution543 {
    private int maxDiam = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        helper(root, 0);
        return maxDiam;
    }

    private int helper(TreeNode curNode, int depth){
        if(curNode == null) return depth;
        if(curNode.left == null && curNode.right == null){
            return depth;
        }

        int left = 0;
        int right = 0;

        if(curNode.left != null){
            left = 1+helper(curNode.left, 0);
        }

        if(curNode.right != null){
            right = 1+helper(curNode.right, 0);
        }

        maxDiam = Math.max(maxDiam, depth+left+right);

        if(left>right) return left;
        else return right;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
