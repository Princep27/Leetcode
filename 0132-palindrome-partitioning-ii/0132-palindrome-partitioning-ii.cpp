class Solution {
public:
    int minCut(string s) {

        int n = s.length();
        vector<int> dp(n+1,2001);
        dp[0] = 0;

        vector<vector<bool>> valid(n + 1, vector<bool>(n + 1, false));

        for (int i = n; i >= 1; --i) {
            for (int j = i; j <= n; ++j) {
                if (i == j)
                    valid[i][j] = true;
                else if (i + 1 == j)
                    valid[i][j] = (s[i - 1] == s[j - 1]);
                else
                    valid[i][j] = (s[i - 1] == s[j - 1]) && valid[i + 1][j - 1];
            }
        }

        for(int i=1;i<=n;++i){
            for(int j=i;j>0;--j){
                if(valid[j][i]){
                    dp[i] = min(dp[i], 1 + dp[j-1]);
                }
            }
        }

    

        return dp[n]-1;

    }
};