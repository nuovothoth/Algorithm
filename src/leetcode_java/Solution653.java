package leetcode_java;

import java.util.HashSet;
import java.util.Set;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution653 {
    /*First Solution*/
    //This is not fit in the intention of this problem.
    /*
    Set<Integer> treeSet;

    public boolean findTarget(TreeNode root, int k) {
        treeSet = new HashSet<>();

        helper(root);
        for(Integer item: treeSet){
            if(item*2 != k && treeSet.contains(k-item)) return true;
        }

        return false;
    }

    private void helper(TreeNode curNode){
        if(curNode == null) return;

        treeSet.add(curNode.val);

        if(curNode.left != null){
            helper(curNode.left);
        }
        if(curNode.right != null){
            helper(curNode.right);
        }
    }
    */

    /*Second Solution*/
    Set<Integer> remainSet;

    public boolean findTarget(TreeNode root, int k) {
        remainSet = new HashSet<>();

        return helper(root, k);
    }

    private boolean helper(TreeNode curNode, int k){
        if(curNode == null) return false;
        if(remainSet.contains(k-curNode.val)) return true;

        remainSet.add(curNode.val);
        return helper(curNode.left, k) || helper(curNode.right, k);

    }

    public class TreeNode {
        int val;
        Solution653.TreeNode left;
        Solution653.TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
