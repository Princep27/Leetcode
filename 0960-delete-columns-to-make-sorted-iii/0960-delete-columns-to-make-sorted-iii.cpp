class Solution {
public:

    vector<vector<int>> dp;

    bool isValid(vector<string> &strs,int cur,int prev){
        if(prev == strs[0].size()) return true;
        for(int i=0;i<strs.size();++i){
            if(strs[i][cur] > strs[i][prev]) return false;
        }
        return true;
    }

    int solve(vector<string> &strs,int cur,int prev){
        if(cur < 0) return 0;
        int ans = 1000;
        if(dp[cur][prev] != -1) return dp[cur][prev];

        if(isValid(strs,cur,prev)){
            ans = solve(strs,cur-1,cur);
        }

        ans = min(ans,1 + solve(strs,cur-1,prev));
        return dp[cur][prev] = ans;
    }

    int minDeletionSize(vector<string>& strs) {
        dp.resize(strs[0].size()+1,vector<int>(strs[0].size()+1,-1));
        return solve(strs,strs[0].size()-1,strs[0].size());
    }
};