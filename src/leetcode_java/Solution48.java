package leetcode_java;

public class Solution48 {
    public void rotate(int[][] matrix) {
        int size = matrix.length;

        for(int i=0;i<size;i++){
            for(int j=i+1;j<size;j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        for(int i=0;i<size;i++){
            int left = 0;
            int right = size-1;
            while(left<=right){
                int temp = matrix[i][left];
                matrix[i][left] = matrix[i][right];
                matrix[i][right] = temp;
                left++;
                right--;
            }
        }
    }
}
