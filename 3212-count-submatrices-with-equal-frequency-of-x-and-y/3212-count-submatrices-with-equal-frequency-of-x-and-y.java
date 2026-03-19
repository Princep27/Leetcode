class Solution {
    //rem = x, que = y
    public int numberOfSubmatrices(char[][] grid) {
        int n = grid.length, m = grid[0].length, ans = 0;
        long count[][] = new long[n][m];

        for(int row=0;row<n;++row){
            for(int col=0;col<m;++col){
                if(col == 0) count[row][col] = grid[row][col] == 'X' ? 1 : (grid[row][col] == 'Y' ? (long)10000000 : (long)0);
                else count[row][col] = count[row][col-1] + (grid[row][col] == 'X' ? (long)1 : (grid[row][col] == 'Y' ? (long)10000000 : 0));
            }
        }

        for(int col=0;col<m;++col){
            long sum_x = 0, sum_y = 0;
            for(int row=0;row<n;++row){
                long x = count[row][col]%(long)10000000, y = count[row][col]/(long)10000000;
                sum_x += x; sum_y += y;
                if(sum_x == sum_y && sum_x != 0) ++ans;
            }
        }

        return ans;
    }
}