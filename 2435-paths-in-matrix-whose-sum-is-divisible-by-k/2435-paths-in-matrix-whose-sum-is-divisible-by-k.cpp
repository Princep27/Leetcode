class Solution {
public:
    int numberOfPaths(vector<vector<int>>& grid, int k) {
        int n = grid.size(), m = grid[0].size(),mod = 1e9 + 7;
        vector<vector<vector<int>>> dp(n+1,vector<vector<int>>(m+1,vector<int>(k,0)));
        dp[1][1][grid[0][0]%k] = 1;

        for(int i=1;i<=n;++i){
            for(int j=1;j<=m;++j){
                if(i == 1 && j == 1) continue;

                for(int p=0;p<k;++p){
                    int rem = (p + grid[i-1][j-1])%k;
                    dp[i][j][rem] = (dp[i][j][rem] + dp[i-1][j][p])%mod;
                }

                for(int p=0;p<k;++p){
                    int rem = (p + grid[i-1][j-1])%k;
                    dp[i][j][rem] = (dp[i][j][rem] + dp[i][j-1][p])%mod;
                }
            }
        }

        return dp[n][m][0];
    }
};