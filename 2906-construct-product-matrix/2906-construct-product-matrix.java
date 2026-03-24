class Solution {
    public int[][] constructProductMatrix(int[][] grid) {

        long mod = 12345;
        int n = grid.length, m = grid[0].length;
        int prefix[][] = new int[n][m];
        int suffix[][] = new int[n][m];
        int ans[][] = new int[n][m];

        for(int i = 0; i < n; ++i){
            for(int j = 0; j < m; ++j){
                if(i == 0 && j == 0) 
                    prefix[i][j] = grid[i][j];
                else if(j == 0) 
                    prefix[i][j] = (int)(((long)grid[i][j] * prefix[i-1][m-1]) % mod);
                else  
                    prefix[i][j] = (int)(((long)grid[i][j] * prefix[i][j-1]) % mod);
            }
        }

        for(int i = n-1; i >= 0; --i){
            for(int j = m-1; j >= 0; --j){
                if(i == n-1 && j == m-1) 
                    suffix[i][j] = grid[i][j];
                else if(j == m-1) 
                    suffix[i][j] = (int)(((long)grid[i][j] * suffix[i+1][0]) % mod);
                else 
                    suffix[i][j] = (int)(((long)grid[i][j] * suffix[i][j+1]) % mod);
            }
        }

        for(int i = 0; i < n; ++i){
            for(int j = 0; j < m; ++j){
                int left, right;

                if(j == 0){
                    if(i == 0) left = 1;
                    else left = prefix[i-1][m-1];
                } else {
                    left = prefix[i][j-1];
                }

                if(j == m-1){
                    if(i == n-1) right = 1;
                    else right = suffix[i+1][0];
                } else {
                    right = suffix[i][j+1];
                }

                ans[i][j] = (int)(((long)left * right) % mod);
            }
        }

        return ans;
    }
}