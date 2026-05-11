class Solution {
    public int maximumJumps(int[] nums, int target) {
        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = 1;

        for(int i=1;i<n;++i) 
            for(int j=0;j<i;++j)
                if(Math.abs(nums[i]-nums[j]) <= target && dp[j] > 0) 
                    dp[i] = Math.max(dp[i],dp[j]+1);
        
        return dp[n-1] == 0 ? -1 : dp[n-1] - 1;
    }
}