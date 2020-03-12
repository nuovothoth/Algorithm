package hackerrank_java;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class FindTheNearestClone {

    // Complete the findShortest function below.

    /*
     * For the unweighted graph, <name>:
     *
     * 1. The number of nodes is <name>Nodes.
     * 2. The number of edges is <name>Edges.
     * 3. An edge exists between <name>From[i] to <name>To[i].
     *
     */
    private static Map<Integer, List<Integer>> nodeMap;
    private static int minVal;

    static int findShortest(int graphNodes, int[] graphFrom, int[] graphTo, long[] ids, int val) {
        // solve here
        nodeMap = new HashMap<>();
        minVal = Integer.MAX_VALUE;

        for(int i=0;i<graphFrom.length;i++){
            List<Integer> tempList;
            if(nodeMap.containsKey(graphFrom[i])){
                tempList = nodeMap.get((Integer)graphFrom[i]);
            }else{
                tempList = new ArrayList<>();
            }
            tempList.add(graphTo[i]);
            nodeMap.put(graphFrom[i], tempList);

            if(nodeMap.containsKey(graphTo[i])){
                tempList = nodeMap.get((Integer)graphTo[i]);
            }else{
                tempList = new ArrayList<>();
            }
            tempList.add(graphFrom[i]);
            nodeMap.put(graphTo[i], tempList);
        }

        for(int i=1;i<=graphNodes;i++){
            if(ids[i-1]==val){
                helper(-1, i, val, ids, 0);
            }
        }

        if(minVal == Integer.MAX_VALUE) return -1;
        return minVal;
    }

    private static void helper(int beforeNode, int curNode, int val, long[] ids, int count){
        if(nodeMap.containsKey(curNode)){
            List<Integer> tempList = nodeMap.get((Integer)curNode);
            for(Integer node: tempList){
                if(node!=beforeNode){
                    //System.out.println("node: "+node+", ids[node]: "+ids[node-1]+", val: "+val);
                    if(ids[node-1]==val){
                        count++;
                        if(minVal>count) minVal = count;
                        return;
                    }
                    helper(curNode, node, val, ids, count+1);
                }
            }
        }
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] graphNodesEdges = scanner.nextLine().split(" ");
        int graphNodes = Integer.parseInt(graphNodesEdges[0].trim());
        int graphEdges = Integer.parseInt(graphNodesEdges[1].trim());

        int[] graphFrom = new int[graphEdges];
        int[] graphTo = new int[graphEdges];

        for (int i = 0; i < graphEdges; i++) {
            String[] graphFromTo = scanner.nextLine().split(" ");
            graphFrom[i] = Integer.parseInt(graphFromTo[0].trim());
            graphTo[i] = Integer.parseInt(graphFromTo[1].trim());
        }

        long[] ids = new long[graphNodes];

        String[] idsItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < graphNodes; i++) {
            long idsItem = Long.parseLong(idsItems[i]);
            ids[i] = idsItem;
        }

        int val = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int ans = findShortest(graphNodes, graphFrom, graphTo, ids, val);

        bufferedWriter.write(String.valueOf(ans));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}