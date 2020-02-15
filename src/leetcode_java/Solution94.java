package leetcode_java;

import java.util.ArrayList;
import java.util.List;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution94 {
    List<Integer> resultList;

    public List<Integer> inorderTraversal(TreeNode root) {
        resultList = new ArrayList<>();

        helper(root);
        return resultList;
    }

    private void helper(TreeNode curNode){
        if(curNode == null) return;

        if(curNode.left != null) helper(curNode.left);
        resultList.add(curNode.val);
        if(curNode.right != null) helper(curNode.right);
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
