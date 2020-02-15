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
class Solution404 {
    int sum = 0;

    public int sumOfLeftLeaves(TreeNode root) {
        if(root != null){
            helper(root, false);
        }

        return sum;
    }

    private void helper(TreeNode curNode, boolean isLeft){
        if(curNode.left == null && curNode.right == null){
            if(isLeft) sum+=curNode.val;
            return;
        }

        if(curNode.left != null){
            helper(curNode.left, true);
        }

        if(curNode.right != null){
            helper(curNode.right, false);
        }
    }
    public class TreeNode {
        int val;
        Solution404.TreeNode left;
        Solution404.TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
