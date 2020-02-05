package leetcode_java;

public class Solution221 {
    int[][] squareArr;
    int maxSideLength;

    public int maximalSquare(char[][] matrix) {
        if(matrix.length == 0) return 0;

        int row = matrix.length;
        int col = matrix[0].length;

        squareArr = new int[row+1][col+1];
        maxSideLength = 0;

        for(int i=1; i<=row; i++){
            for(int j=1; j<=col; j++){
                squareArr[i][j] = matrix[i-1][j-1]-'0';
            }
        }

        for(int i=0;i<row;i++){
            helper(i, 0, matrix);
        }


        return maxSideLength*maxSideLength;
    }

    private void helper(int row, int col, char[][] matrix){
        if(col>=matrix[0].length) return ;

        if(matrix[row][col]=='1'){
            squareArr[row+1][col+1] = Math.min(squareArr[row][col], Math.min(squareArr[row+1][col], squareArr[row][col+1]))+1;
        }

        if(maxSideLength<squareArr[row+1][col+1]) maxSideLength = squareArr[row+1][col+1];
        helper(row, col+1, matrix);
    }
}
