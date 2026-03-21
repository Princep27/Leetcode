class Solution {
    public int[][] reverseSubmatrix(int[][] grid, int x, int y, int k) {
        for(int col=y; col<y+k; ++col){
            for(int row=x; row<x+(k/2); ++row){
                int tmp = grid[row][col];
                grid[row][col] = grid[x+k-1-(row-x)][col];
                grid[x+k-1-(row-x)][col] = tmp;
            }
        }
        return grid;
    }
}