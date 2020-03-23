package leetcode_java;

import java.util.*;

public class Solution399 {
    private Map<String, List<NodeInfo>> graphMap;
    private Set<String> visitedSet;
    private double[] result;

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        graphMap = new HashMap<>();
        visitedSet = new HashSet<>();
        result = new double[queries.size()];

        int i = 0;

        for(List<String> item: equations){
            String fromStr = item.get(0);
            String toStr = item.get(1);

            NodeInfo tempNodeInfo1 = new NodeInfo(toStr, values[i]);
            NodeInfo tempNodeInfo2 = new NodeInfo(fromStr, 1.0);
            List<NodeInfo> tempList;
            if(graphMap.containsKey(fromStr)){
                tempList = graphMap.get(fromStr);
            }else{
                tempList = new ArrayList<>();
            }
            tempList.add(tempNodeInfo1);
            tempList.add(tempNodeInfo2);
            graphMap.put(fromStr, tempList);

            tempNodeInfo1 = new NodeInfo(fromStr, 1/values[i]);
            tempNodeInfo2 = new NodeInfo(toStr, 1.0);
            if(graphMap.containsKey(toStr)){
                tempList = graphMap.get(toStr);
            }else{
                tempList = new ArrayList<>();
            }
            tempList.add(tempNodeInfo1);
            tempList.add(tempNodeInfo2);
            graphMap.put(toStr, tempList);

            i++;
        }

        i = 0;
        for(List<String> item: queries){
            visitedSet = new HashSet<>();
            String fromStr = item.get(0);
            String toStr = item.get(1);

            result[i] = getDivision(fromStr, toStr, 1);
            i++;
        }

        return result;
    }

    private double getDivision(String fromStr, String toStr, double divVal){
        List<NodeInfo> tempList;
        double result = -1;

        visitedSet.add(fromStr);

        if(graphMap.containsKey(fromStr)){
            tempList = graphMap.get(fromStr);
            for(NodeInfo item: tempList){
                if((item.getDest()).equals(toStr)) return divVal*item.getVal();
            }

            for(NodeInfo item: tempList){
                if(!visitedSet.contains(item.getDest())){
                    result = getDivision(item.getDest(), toStr, divVal*item.getVal());
                    if(result != -1) return result;
                }
            }
        }

        return result;
    }
}

class NodeInfo {
    private String dest = "";
    private double val = 0.0;

    public NodeInfo(String dest, double val){
        this.dest = dest;
        this.val = val;
    }

    public String getDest(){
        return dest;
    }

    public double getVal(){
        return val;
    }
}
