class Solution {
public:
    int maxProfit(vector<int>& prices) {
        int n = prices.size();
        int dp[n+1];
        memset(dp,0,sizeof(dp));
        for(int i=2;i<=n;++i){
            dp[i] = dp[i-1];
            for(int j=1;j<i;++j){
                int prev = j-2;
                int profit_till_prev = 0;
                if(prev > 0) profit_till_prev = dp[prev];
                dp[i] = max(dp[i], prices[i-1]-prices[j-1]+profit_till_prev);
            }
        }

        return dp[n];
    }
};