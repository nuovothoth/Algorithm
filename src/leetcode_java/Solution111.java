package leetcode_java;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

public class Solution111 {
    Queue<TreeNode> treeQueue;
    Queue<Integer> levelQueue;
    int minNodeCount = Integer.MAX_VALUE;

    public int minDepth(TreeNode root) {
        if(root==null) return 0;

        treeQueue = new LinkedList<>();
        levelQueue = new LinkedList<>();

        TreeNode curNode = root;
        treeQueue.offer(root);
        levelQueue.offer(1);

        trackTree();

        return minNodeCount;
    }

    private void trackTree(){
        while(!treeQueue.isEmpty()){
            TreeNode tempNode = treeQueue.poll();
            int level = levelQueue.poll();

            if(tempNode.left==null && tempNode.right==null){
                if(minNodeCount>level) minNodeCount=level;
            }else{
                if(tempNode.left!=null){
                    treeQueue.offer(tempNode.left);
                    levelQueue.offer(level+1);
                }

                if(tempNode.right!=null){
                    treeQueue.offer(tempNode.right);
                    levelQueue.offer(level+1);
                }

                trackTree();
            }
        }
    }

    private class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){val = x;}
    }
}
