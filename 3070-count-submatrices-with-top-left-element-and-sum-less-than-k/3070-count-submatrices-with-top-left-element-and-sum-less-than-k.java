class Solution {
    public int countSubmatrices(int[][] grid, int k) {
        int n = grid.length, m = grid[0].length,ans = 0;

        for(int row=0;row<n;++row){
            for(int col=1;col<m;++col){
                grid[row][col] += grid[row][col-1];
            }
        }
        
        for(int col=0;col<m;++col){
            for(int row=0;row<n;++row){
                int prev = row == 0 ? 0 : grid[row-1][col];
                grid[row][col] += prev;
                if(grid[row][col] <= k) ++ans;
            }
        }

        return ans;
    }
}