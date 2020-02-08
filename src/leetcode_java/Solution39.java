package leetcode_java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution39 {
    private List<List<Integer>> resultList;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        int startIdx = candidates.length-1;
        resultList = new ArrayList<List<Integer>>();
        List<Integer> tempList = new ArrayList<>();

        while(startIdx>-1 && candidates[startIdx]>target){
            startIdx--;
        }

        if(startIdx<0) return resultList;

        helper(candidates, target, startIdx, tempList);

        return resultList;
    }

    private void helper(int[] candidates, int target, int curIdx, List<Integer> list){
        if(target == 0){
            List<Integer> temp = new ArrayList<Integer>();
            for(Integer item: list){
                temp.add(item);
            }
            resultList.add(temp);
            return;
        }else{
            if(curIdx<0){
                return;
            }else{
                if(target>=candidates[curIdx]){
                    list.add(candidates[curIdx]);
                    helper(candidates, target-candidates[curIdx], curIdx, list);
                    list.remove(list.size()-1);
                }
                helper(candidates, target, curIdx-1, list);

            }
        }
    }
}
