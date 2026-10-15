class Solution {
public:
    int solve(vector<int> &dp,vector<int> &nums,int target){
        if(target == 0) return 1;
        if(dp[target] != -1) return dp[target];
        int n = nums.size();
        int cnt = 0;
        for(int i=0;i<n;++i){
            if(nums[i] <= target) cnt += solve(dp,nums,target-nums[i]); 
        }
        return dp[target] = cnt;
    }

    int combinationSum4(vector<int>& nums, int target) {
        int n = nums.size();
       
        // vector<int> dp(target+1,-1);
        // return solve(dp,nums,target);

        vector<unsigned int> dp(target+1,0);
        dp[0] = 1;
        for(int i=1;i<=target;++i){
            for(int j=1;j<=n;++j){
                if(nums[j-1] <= i) dp[i] += dp[i-nums[j-1]];
            }
        }
        return (int)dp[target];
    }
};