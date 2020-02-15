package leetcode_java;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution235 {
    /* first solution*/
    /*
    private Map<Integer, List<Integer>> ancMap;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        ancMap = new HashMap<>();
        List<Integer> rootList = new ArrayList<>();

        helper(root, new ArrayList<Integer>());

        List<Integer> pList = ancMap.get((Integer)p.val);
        List<Integer> qList = ancMap.get((Integer)q.val);
        TreeNode resultNode = new TreeNode(-1);

        if(pList.size()>qList.size()){
            for(int i=qList.size()-1;i>-1;i--){
                if(pList.contains(qList.get(i))){
                    resultNode = new TreeNode(qList.get(i));
                    return resultNode;
                }
            }
        }else{
            for(int i=pList.size()-1;i>-1;i--){
                if(qList.contains(pList.get(i))){
                    resultNode = new TreeNode(pList.get(i));
                    return resultNode;
                }
            }
        }

        return resultNode;

    }

    private void helper(TreeNode node, ArrayList<Integer> ancList){
        if(node == null) return;

        ArrayList<Integer> ancListTemp = (ArrayList)ancList.clone();
        ancListTemp.add(node.val);
        ancMap.put(node.val, ancListTemp);

        if(node.left==null && node.right==null){
            return;
        }else if(node.left!=null && node.right!=null){
            helper(node.left, ancListTemp);
            helper(node.right, ancListTemp);
        }else if(node.left!=null){
            helper(node.left, ancListTemp);
        }else{
            helper(node.right, ancListTemp);
        }
    }
    */

    /*Second Solution*/
    //This solution is able to be applied when the tree is BST not just binary tree.
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return helper(root, p.val, q.val);
    }

    private TreeNode helper(TreeNode curNode, int pVal, int qVal){
        if(curNode.val > pVal && curNode.val > qVal){
            return helper(curNode.left, pVal, qVal);
        }else if(curNode.val < pVal && curNode.val < qVal){
            return helper(curNode.right, pVal, qVal);
        }else{
            return curNode;
        }
    }

    public class TreeNode {
        int val;
        Solution235.TreeNode left;
        Solution235.TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
