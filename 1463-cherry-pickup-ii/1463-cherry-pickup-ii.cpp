class Solution {
public:

    vector<vector<vector<int>>> dp;

    int solve(vector<vector<int>> &grid,vector<vector<vector<int>>> &dp,int col1,int col2,int row){

        int ans = 0;
        int curVal = 0;
        int n = grid.size();
        int m = grid[0].size();

        if(dp[col1][col2][row] != -1) return dp[col1][col2][row];

        if(row == n-1){
            if(col1 != col2) return grid[row][col1] + grid[row][col2];
            else return grid[row][col1];
        }

        if(col1 != col2) curVal = grid[row][col1] + grid[row][col2];
        else curVal = grid[row][col1];

        for(int i=-1;i<=1;++i){
            for(int j=-1;j<=1;++j){
                int newCol1 = col1 + i;
                int newCol2 = col2 + j;
                if(newCol1 < m && newCol2 < m && newCol1 >= 0 && newCol2 >= 0)
                    ans = max(ans, curVal + solve(grid,dp,newCol1,newCol2,row+1));
            }
        }

        return dp[col1][col2][row] = ans;
    }

    int cherryPickup(vector<vector<int>>& grid) {
        int n = grid.size();
        int m = grid[0].size();
        dp.resize(m+1,vector<vector<int>>(m+1,vector<int>(n+1,-1)));
        return solve(grid,dp,0,m-1,0);
    }
};