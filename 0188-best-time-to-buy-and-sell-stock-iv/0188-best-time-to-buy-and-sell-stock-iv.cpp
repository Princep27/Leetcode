class Solution {
public:

    vector<vector<vector<int>>> dp;

    int solve(vector<int> &prices,int index,int k,int state,int n){
        int ans = 0;
        if(index == n || k == 0){
            return 0;
        }

        if(dp[index][k][state] != -1) return dp[index][k][state];

        if(state == 0){
            int included = -prices[index] + solve(prices,index+1,k,1,n);
            int not_included = solve(prices,index+1,k,state,n);
            ans = max(included,not_included);
        }

        else{
            int included = prices[index] + solve(prices,index+1,k-1,0,n);
            int not_included = solve(prices,index+1,k,state,n);
            ans = max(included, not_included);
        }

        return dp[index][k][state] = ans;
    }

    int maxProfit(int k, vector<int>& prices) {
        dp.resize(prices.size()+1,vector<vector<int>>(k+1,vector<int>(2,-1)));
        return solve(prices,0,k,0,prices.size());
    }
};