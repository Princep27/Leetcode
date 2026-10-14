class Solution {
public:
    bool canPartition(vector<int>& nums) {
        int sum = 0;
        for(auto it: nums) sum += it;
        int n = nums.size();
        if(sum%2 == 1) return false;

        sum /= 2;

        vector<vector<int>> dp(sum+1,vector<int>(n+1,0));
        for(int i=0;i<=n;++i) dp[0][i] = true;
        
        for(int i=1;i<=sum;++i){
            for(int j=1;j<=n;++j){
                int rem_sum = i - nums[j-1];
                if(rem_sum < 0) dp[i][j] = dp[i][j-1];
                else dp[i][j] = dp[rem_sum][j-1] | dp[i][j-1];
            }
        }

        return dp[sum][n];
    }
};