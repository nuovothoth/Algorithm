package hackerrank_java;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class RoadsAndLibraries {
    private static int[] visitedCity;
    private static Map<Integer, List<Integer>> adjMap;
    private static int count;

    static long roadsAndLibraries(int n, int c_lib, int c_road, int[][] cities) {
        if(c_lib<=c_road) return (long)c_lib*n;

        visitedCity = new int[n+1];
        adjMap = new HashMap<>();
        long totalCost = 0;

        for(int i=0;i<cities.length;i++){
            List<Integer> tempList;
            if(adjMap.containsKey(cities[i][0])){
                tempList = adjMap.get(cities[i][0]);
            }else{
                tempList = new ArrayList<>();
            }
            tempList.add(cities[i][1]);
            adjMap.put(cities[i][0], tempList);

            if(adjMap.containsKey(cities[i][1])){
                tempList = adjMap.get(cities[i][1]);
            }else{
                tempList = new ArrayList<>();
            }
            tempList.add(cities[i][0]);
            adjMap.put(cities[i][1], tempList);
        }

        for(int i=1;i<=n;i++){
            if(visitedCity[i]==0){
                count = 0;
                helper(i, n);
                totalCost+=(count*c_road+c_lib);
            }
        }

        return totalCost;
    }

    private static void helper(int curCity, int n){
        if(visitedCity[curCity]==0){
            visitedCity[curCity] = 1;
            if(adjMap.containsKey(curCity)){
                List<Integer> adjList = adjMap.get((Integer)curCity);
                for(Integer city: adjList){
                    if(visitedCity[city]==0){
                        count++;
                        helper(city, n);
                    }
                }
            }
        }
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String[] nmC_libC_road = scanner.nextLine().split(" ");

            int n = Integer.parseInt(nmC_libC_road[0]);

            int m = Integer.parseInt(nmC_libC_road[1]);

            int c_lib = Integer.parseInt(nmC_libC_road[2]);

            int c_road = Integer.parseInt(nmC_libC_road[3]);

            int[][] cities = new int[m][2];

            for (int i = 0; i < m; i++) {
                String[] citiesRowItems = scanner.nextLine().split(" ");
                scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

                for (int j = 0; j < 2; j++) {
                    int citiesItem = Integer.parseInt(citiesRowItems[j]);
                    cities[i][j] = citiesItem;
                }
            }

            long result = roadsAndLibraries(n, c_lib, c_road, cities);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
