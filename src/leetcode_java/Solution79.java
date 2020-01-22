package leetcode_java;

/*
1. Problem
- There is a 2D matrix filled with characters.
- We can move 4 directions at a point. left, right, top, bottom (Not allowed diagonal directions.)
- We can't use one character being at a point more than once.
- Return if it's possible to tracking the word in a 2D matrix.
- Example1)
    board = [
              ['A','B','C','E'],
              ['S','F','C','S'],
              ['A','D','E','E']
            ]
    If the word is "ABCCED",
                [A->  B->   C   E]
                            |
                [S    F     C   S]
                            |
                [A    D   <-E   E]
    It's possible so that return true.
- Example2)
    <same board with example1>
    If the word is "ABCB",
                [A->  B->   C-(x)E]
                 |          |
                (x)        (x)
                [S    F     C    S]
                ||
                (x)
                [A=(x)D     E    E]
    It's impossible so that return false.


2. Constraints & Edge Case
- Edge Case1) word is empty
- Edge Case2) board(2D array) is empty

3. Algorithm
- DFS(Depth First Search), BackTracking, (be able to use BFS(Breadth First Search))
- Handle the edge cases.
- Start the each starting points using double for loop.
- In the double for loop, run the function which implements DFS.


4. Time Complexity
- O(n^2)
 */

public class Solution79 {
    public boolean exist(char[][] board, String word) {
        int[][] visitedBoard = new int[board.length][board[0].length];

        if(word.equals("")){
            return true;
        }else if(board.length==0 && !word.equals("")){
            return false;
        }else{
            for(int i=0;i<board.length;i++){
                for(int j=0;j<board[0].length;j++){
                    if(backTracking(board, i, j, word, 0, visitedBoard)){
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean backTracking(char[][] board, int x, int y, String word, int wordIdx, int[][] visitedBoard){
        if(word.length() == wordIdx) return true;
        if(x<0 || x>board.length-1 || y<0 || y>board[0].length-1 || visitedBoard[x][y] == 1) return false;

        if(board[x][y] == word.charAt(wordIdx)){
            visitedBoard[x][y] = 1; //because we shouldn't visit again at this point.
            if(word.length() == wordIdx+1){
                return true;
            }

            if(backTracking(board, x-1, y, word, wordIdx+1, visitedBoard)) return true;
            if(backTracking(board, x+1, y, word, wordIdx+1, visitedBoard)) return true;
            if(backTracking(board, x, y-1, word, wordIdx+1, visitedBoard)) return true;
            if(backTracking(board, x, y+1, word, wordIdx+1, visitedBoard)) return true;
            visitedBoard[x][y] = 0; //It never match for next directions, so we make this point unvisited.
        }
        //if(board[x][y] != word.charAt(wordIdx)) we couldn't go further anymore.
        return false;
    }
}
