package Beakjoon_java;
import java.nio.charset.CharacterCodingException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/*
* <For applying basic sort methods>
* Problem: Sort inside
* Sort each digit of the number in descending order with given number.
* The number n is 1 <= n <= 1,000,000,000
* */

public class Solution1427 {
    private static char[] inputChArr;
    private static char[] mergeChArr;

    public static void main(String args[]) {
        int input;

        Scanner sc = new Scanner(System.in);
        input = sc.nextInt();

        inputChArr = (input+"").toCharArray();
        mergeChArr = new char[inputChArr.length];

        //selectionSort();
        //insertionSort();
        //bubbleSort();
        //mergeSort(inputChArr, 0, inputChArr.length-1);
        quickSort(0, inputChArr.length-1);
        System.out.println(new String(inputChArr));
    }

    //selection sort
    private static void selectionSort(){
        int curIdx = 0;
        int maxIdx = 0;
        while(curIdx<inputChArr.length){
            for(int i=curIdx;i<inputChArr.length;i++){
                if(inputChArr[maxIdx]<inputChArr[i]) maxIdx = i;
            }
            char temp = inputChArr[maxIdx];
            inputChArr[maxIdx] = inputChArr[curIdx];
            inputChArr[curIdx] = temp;
            curIdx++;
            maxIdx = curIdx;
        }
    }

    //insertion sort
    private static void insertionSort(){
        for(int i=1;i<inputChArr.length;i++){
            char target = inputChArr[i];
            int j = i-1;
            for(;j>-1;j--){
                if(target>inputChArr[j]){
                    inputChArr[j+1] = inputChArr[j];
                }else{
                    break;
                }
            }

            inputChArr[j+1] = target;
        }
    }

    //bubble sort
    private static void bubbleSort(){
        for(int i=1;i<inputChArr.length;i++){
            for(int j=0;j<inputChArr.length-i;j++){
                if(inputChArr[j]<inputChArr[j+1]){
                    char temp = inputChArr[j];
                    inputChArr[j] = inputChArr[j+1];
                    inputChArr[j+1] = temp;
                }
            }
        }
    }

    //merge sort
    private static void mergeSort(char[] chArr, int left, int right){//divide, conquer
        int mid;

        if(left<right){
            mid = (left+right)/2;
            mergeSort(chArr, left, mid);
            mergeSort(chArr, mid+1, right);
            merge(chArr, left, mid, right);
        }
    }

    private static void merge(char[] chArr, int left, int mid, int right){//combine
        int curLeft = left;
        int curRight = mid+1;
        int sortedIdx = left;

        while(curLeft<=mid && curRight<=right){
            if(chArr[curLeft]<=chArr[curRight]){
                mergeChArr[sortedIdx++] = chArr[curRight++];
            }else{
                mergeChArr[sortedIdx++] = chArr[curLeft++];
            }
        }

        while(curLeft<=mid){
            mergeChArr[sortedIdx++] = chArr[curLeft++];
        }

        while(curRight<=right){
            mergeChArr[sortedIdx++] = chArr[curRight++];
        }

        for(int i=left;i<=right;i++){
            chArr[i] = mergeChArr[i];
        }
    }

    //quick sort
    private static void quickSort(int left, int right){
        if(left<right){
            int point = pivoting(left, right);

            quickSort(left, point-1);
            quickSort(point+1, right);
        }
    }

    private static int pivoting(int left, int right){
        int pivot = left;
        char temp;
        left++;

        while(left<right){
            while(inputChArr[left] > inputChArr[pivot] && left<=right) left++;
            while(inputChArr[pivot] > inputChArr[right] && left<=right) right--;

            if(left<right) {
                temp = inputChArr[left];
                inputChArr[left] = inputChArr[right];
                inputChArr[right] = temp;
            }
        }

        temp = inputChArr[pivot];
        inputChArr[pivot] = inputChArr[right];
        inputChArr[right] = temp;

        return right;
    }
}
