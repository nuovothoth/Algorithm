package hackerrank_java;
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class SpecialStringAgain {

    static long substrCount(int n, String s) {
        char[] sChArr = s.toCharArray();
        int count = sChArr.length;

        for(int i=1;i<sChArr.length-1;i++){
            int offset = 1;
            char targetChar = sChArr[i-offset];
            while(i-offset>=0 && i+offset<sChArr.length){
                if(sChArr[i-offset] == targetChar && sChArr[i+offset] == targetChar){
                    count++;
                    offset++;
                }else{
                    break;
                }
            }
        }

        for(int i=1;i<sChArr.length;i++){
            int offset = 0;
            int left = i-1;
            int right = i;
            char targetChar = sChArr[i];
            while(left-offset>=0 && right+offset<sChArr.length){
                if(sChArr[left-offset] == targetChar && sChArr[right+offset] == targetChar){
                    count++;
                    offset++;
                }else{
                    break;
                }
            }
        }

        return count;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String s = scanner.nextLine();

        long result = substrCount(n, s);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
