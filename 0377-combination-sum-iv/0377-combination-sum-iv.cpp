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
       
        vector<int> dp(target+1,-1);
        return solve(dp,nums,target);

        // memset(dp,0,sizeof(dp));

        // for(int i=0;i<=n;++i) dp[0][i] = 1;

        // for(int sum=1;sum<=target;++sum){
        //     for(int len=1;len<=n;++len){
        //         //take
        //         if(sum >= nums[len-1])
        //             dp[sum][len] += dp[sum-nums[len-1]][len];
                
        //         //not take
        //         dp[sum][len] += dp[sum][len-1]; 
        //     }
        // }

        //return dp[target][n];
    }
};