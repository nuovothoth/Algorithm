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

public class Solution104 {
    private int maxDepth = 0;

    public int maxDepth(TreeNode root) {
        helper(root, 0);

        return maxDepth;
    }

    private void helper(TreeNode node, int curDepth){
        if(node == null){
            if(maxDepth<curDepth) maxDepth = curDepth;
            return;
        }

        helper(node.left, curDepth+1);
        helper(node.right, curDepth+1);
    }

    public class TreeNode {
        int val;
        Solution104.TreeNode left;
        Solution104.TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
