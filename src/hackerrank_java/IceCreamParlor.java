package hackerrank_java;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class IceCreamParlor {
    // Complete the whatFlavors function below.
    static void whatFlavors(int[] cost, int money) {
        Map<Integer, List<Integer>> costMap = new HashMap<>(); // cost, index list

        for(int i=0;i<cost.length;i++){
            List<Integer> tempList;
            if(costMap.containsKey(cost[i])){
                tempList = costMap.get((Integer)cost[i]);
                tempList.add(i);
                costMap.put(cost[i], tempList);
            }else{
                tempList = new ArrayList<>();
                tempList.add(i);
                costMap.put(cost[i], tempList);
            }
        }

        for(int i=0;i<cost.length;i++){
            int leftMoney = money-cost[i];
            if(leftMoney>0){
                if(costMap.containsKey((Integer)leftMoney)){
                    if(leftMoney == cost[i]){
                        if(costMap.get((Integer)cost[i]).size()>1){
                            List<Integer> tempList = costMap.get((Integer)cost[i]);
                            System.out.println((tempList.get(0)+1)+" "+(tempList.get(1)+1));
                            break;
                        }
                    }else{
                        int leftIdx = costMap.get((Integer)leftMoney).get(0);
                        if(i>leftIdx){
                            System.out.println((leftIdx+1)+" "+(i+1));
                        }else{
                            System.out.println((i+1)+" "+(leftIdx+1));
                        }
                        break;
                    }
                }
            }
        }

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            int money = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int[] cost = new int[n];

            String[] costItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < n; i++) {
                int costItem = Integer.parseInt(costItems[i]);
                cost[i] = costItem;
            }

            whatFlavors(cost, money);
        }

        scanner.close();
    }
}
