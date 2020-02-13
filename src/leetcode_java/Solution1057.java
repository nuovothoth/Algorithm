package leetcode_java;

import java.util.*;
//Bucket Sort (https://aerocode.net/115)

public class Solution1057 {
    public int[] assignBikes(int[][] workers, int[][] bikes) {
        Map<Integer, List<int[]>> bucketSortMap = new HashMap<Integer, List<int[]>>(); //length, index;

        int[] assignBikesArr = new int[workers.length];
        boolean[] isBikeDisable = new boolean[bikes.length];

        for(int i=0;i<workers.length;i++){
            assignBikesArr[i] = -1;
        }

        for(int i=0;i<workers.length;i++){
            for(int j=0;j<bikes.length;j++){
                int length = getLength(workers[i], bikes[j]);
                int[] newArr = {i,j};
                List<int[]> tempList;
                if(bucketSortMap.containsKey(length)){
                    tempList = bucketSortMap.get((Integer)length);
                }else{
                    tempList = new ArrayList<int[]>();
                }
                tempList.add(newArr);
                bucketSortMap.put(length, tempList);
            }
        }

        bucketSortMap =  new TreeMap<Integer, List<int[]>>(bucketSortMap);

        for(Map.Entry<Integer, List<int[]>> item: bucketSortMap.entrySet()){
            List<int[]> tempList = item.getValue();
            for(int[] innerItem: tempList){
                if(!isBikeDisable[innerItem[1]] && assignBikesArr[innerItem[0]] == -1){
                    assignBikesArr[innerItem[0]] = innerItem[1];
                    isBikeDisable[innerItem[1]] = true;
                }
            }
        }
        return assignBikesArr;
    }

    private int getLength(int[] worker, int[] bike) {
        int width = worker[0]-bike[0];
        int height = worker[1]-bike[1];
        if(width<0) width*=-1;
        if(height<0) height*=-1;

        return width+height;
    }
}
