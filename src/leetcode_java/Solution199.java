package leetcode_java;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution199 {
    /*First Solution*/
    /*
    TreeMap<Integer, Integer> treeMap;

    public List<Integer> rightSideView(TreeNode root) {
        treeMap = new TreeMap<>();
        List<Integer> resultList = new ArrayList<>();
        if(root!=null){
            helper(root, 0);
        }

        for(Map.Entry<Integer, Integer> item: treeMap.entrySet()){
            resultList.add(item.getValue());
        }

        return resultList;
    }

    private void helper(TreeNode curNode, int depth){
        if(curNode == null) return;

        helper(curNode.left, depth+1);
        helper(curNode.right, depth+1);

        treeMap.put(depth, curNode.val);
    }
    */

    /*Second Solution*/
    List<Integer> resultList;

    public List<Integer> rightSideView(TreeNode root) {
        resultList = new ArrayList<>();

        if(root!=null){
            if(root.left == null && root.right == null){
                resultList.add(root.val);
            }else{
                helper(root, 0);
            }
        }

        return resultList;
    }

    private void helper(TreeNode curNode, int depth){
        if(curNode == null) return;

        helper(curNode.left, depth+1);
        helper(curNode.right, depth+1);

        int size = resultList.size();
        if(size<=depth){
            for(int i=0;i<depth-size;i++){
                resultList.add(0);
            }
            resultList.add(curNode.val);
        }else{
            resultList.remove(depth);
            resultList.add(depth, curNode.val);
        }
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
