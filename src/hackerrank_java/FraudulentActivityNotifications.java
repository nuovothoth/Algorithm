package hackerrank_java;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

//Counter Sort
//fixed value range: 0<=n<=200
//Time Complexity: O(200n) => O(n)

public class FraudulentActivityNotifications {
    private static int medianStart;
    private static boolean isEven;
    private static int[] countingArr;

    static int activityNotifications(int[] expenditure, int d) {
        int notiCount = 0;
        countingArr = new int[201];

        if(d%2 == 0){
            isEven = true;
            medianStart = d/2;
        }else{
            medianStart = d/2+1;
        }

        for(int i=0;i<d;i++){
            countingArr[expenditure[i]]++;
        }

        for(int i=d;i<expenditure.length;i++){
            if(expenditure[i]>=getMedian()) notiCount++;
            countingArr[expenditure[i]]++;
            countingArr[expenditure[i-d]]--;
        }

        return notiCount;
    }

    private static int getMedian(){
        int median = 0;
        int curCount = 0;

        if(isEven){
            int count=2;
            for(int i=0;i<201;i++){
                if(countingArr[i]>0){
                    curCount += countingArr[i];
                    if(count == 1){
                        median+=i;
                        break;
                    }

                    if(curCount-medianStart==0){
                        median+=i;
                        count--;
                    }else if(curCount>medianStart){
                        median = i*2;
                        break;
                    }
                }
            }
        }else{
            for(int i=0;i<201;i++){
                curCount += countingArr[i];
                if(curCount>=medianStart){
                    median = i*2;
                    break;
                }
            }
        }

        return median;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nd = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nd[0]);
        int d = Integer.parseInt(nd[1]);
        int[] expenditure = new int[n];

        String[] expenditureItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int expenditureItem = Integer.parseInt(expenditureItems[i]);
            expenditure[i] = expenditureItem;
        }

        int result = activityNotifications(expenditure, d);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();
        bufferedWriter.close();

        scanner.close();
    }
}
