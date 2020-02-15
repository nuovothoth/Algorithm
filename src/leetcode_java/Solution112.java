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
class Solution112 {
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root == null) return false;

        return helper(root, sum, 0);
    }

    private boolean helper(TreeNode node, int sum, int curSum){
        if(node == null){
            if(sum == curSum) return true;
            else return false;
        }

        if(node.left == null && node.right == null){
            if(sum == curSum+node.val) return true;
            else return false;
        }else if(node.left != null && node.right != null){
            return helper(node.left, sum, curSum+node.val) || helper(node.right, sum, curSum+node.val);
        }else if(node.left != null){
            return helper(node.left, sum, curSum+node.val);
        }else{
            return helper(node.right, sum, curSum+node.val);
        }
    }

    public class TreeNode {
        int val;
        Solution112.TreeNode left;
        Solution112.TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
