class Solution {
public:
    bool solve(vector<int>& stones, int index, int prevcnt, int n,vector<vector<int>> &dp) {
        if (index == n - 1) {
            return true;
        }

        if(dp[index][prevcnt] != -1){
            return dp[index][prevcnt] == 1 ? true : false;
        }

        bool ans = false;

        for(int k=-1;k<=1;++k){
            int nextVal = stones[index] + prevcnt + k;
            int next = lower_bound(stones.begin(),stones.end(),nextVal) - stones.begin();
            if(next != n && next > index && stones[next] == nextVal) 
                ans |= solve(stones,next,prevcnt+k,n,dp);
        }

        dp[index][prevcnt] = (ans == true ? 1 : 0);
        return ans;
    }

    bool canCross(vector<int>& stones) {
        int n = stones.size();
        if(stones[1] != 1) return false;
        vector<vector<int>> dp(n+1,vector<int>(n+1,-1));
        return solve(stones, 1, 1, n,dp);
    }
};