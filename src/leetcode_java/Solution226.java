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
class Solution226 {
    public TreeNode invertTree(TreeNode root) {
        if(root == null) return null;

        TreeNode newRoot = new TreeNode(root.val);
        helper(newRoot, root);

        return newRoot;
    }

    private void helper(TreeNode newCurNode, TreeNode curNode){
        TreeNode left;
        TreeNode right;

        if(curNode.left == null && curNode.right == null){
            return;
        }else if(curNode.left != null && curNode.right != null){
            left = new TreeNode(curNode.right.val);
            right = new TreeNode(curNode.left.val);
            newCurNode.left = left;
            newCurNode.right = right;
            helper(newCurNode.right, curNode.left);
            helper(newCurNode.left, curNode.right);
        }else if(curNode.left != null){
            right = new TreeNode(curNode.left.val);
            newCurNode.right = right;
            helper(newCurNode.right, curNode.left);
        }else{
            left = new TreeNode(curNode.right.val);
            newCurNode.left = left;
            helper(newCurNode.left, curNode.right);
        }
    }
    public class TreeNode {
        int val;
        Solution226.TreeNode left;
        Solution226.TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
