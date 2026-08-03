class Solution {
    int solve(int[] nums,int[] dp,int index){
        if(index >= nums.length) return 0;
        if(dp[index] != -1) return dp[index];

        int sum = 0;
        int ans = Integer.MIN_VALUE;
        for(int cnt=1; cnt<=3 && index+cnt-1 < nums.length; ++cnt){
            sum += nums[index+cnt-1];
            ans = Math.max(ans, sum - solve(nums,dp,index+cnt));
        }

        return dp[index] = ans;
    }

    public String stoneGameIII(int[] nums) {
        int n = nums.length;
        int dp[] = new int[n];
        Arrays.fill(dp,-1);

        int tmp = solve(nums,dp,0);
        if(tmp < 0) return "Bob";
        else if(tmp == 0) return "Tie";
        else return "Alice";
    }
}