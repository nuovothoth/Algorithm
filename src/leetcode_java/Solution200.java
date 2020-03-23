package leetcode_java;

public class Solution200 {
    int[][] visitedGrid;

    public int numIslands(char[][] grid) {
        if(grid.length==0) return 0;

        visitedGrid = new int[grid.length][grid[0].length];
        int islandCount = 0;

        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(visitedGrid[i][j] == 0 && grid[i][j] == '1'){
                    trackIsland(i,j,grid);
                    islandCount++;
                }
            }
        }

        return islandCount;
    }

    private void trackIsland(int curX, int curY, char[][] grid){
        visitedGrid[curX][curY]=1;

        if(curX>0 && grid[curX-1][curY]=='1' && visitedGrid[curX-1][curY]==0){
            trackIsland(curX-1, curY, grid);
        }

        if(curX<grid.length-1 && grid[curX+1][curY]=='1' && visitedGrid[curX+1][curY]==0){
            trackIsland(curX+1, curY, grid);
        }

        if(curY>0 && grid[curX][curY-1]=='1' && visitedGrid[curX][curY-1]==0){
            trackIsland(curX, curY-1, grid);
        }

        if(curY<grid[0].length-1 && grid[curX][curY+1]=='1' && visitedGrid[curX][curY+1]==0){
            trackIsland(curX, curY+1, grid);
        }
    }
}
