class Solution {
public:

    int dp[501][501];

    int solve(string &word1,string &word2,int i,int j){
        int n = word1.size();
        int m = word2.size();
        if(j == m) return n-i;
        if(i == n) return m-j;

        if(dp[i][j] != -1) return dp[i][j];

        int ans = max(n+1,m+1);

        ans = min(ans, 1 + solve(word1,word2,i,j+1));
        ans = min(ans, 1 + solve(word1,word2,i+1,j));
        ans = min(ans, 1 + solve(word1,word2,i+1,j+1));
        if(word1[i] == word2[j])
        ans = min(ans, solve(word1,word2,i+1,j+1));

        return dp[i][j] = ans;
    }

    int minDistance(string word1, string word2) {
        int n = word1.length();
        int m = word2.length();
        memset(dp,-1,sizeof(dp));
        return solve(word1,word2,0,0);
    }
};