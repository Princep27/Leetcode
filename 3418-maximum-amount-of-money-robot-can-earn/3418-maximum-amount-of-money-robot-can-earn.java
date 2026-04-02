class Solution {

    static int solve(int[][] coins,int n,int m,int rem,int[][][] dp){
        int ans = Integer.MIN_VALUE;
        int left = Integer.MIN_VALUE, upper = Integer.MIN_VALUE;
        
        if(n == 1 && m == 1){
            if(rem > 0 && coins[0][0] < 0) return 0;
            else return coins[0][0];
        }

        if(dp[n][m][rem] != Integer.MIN_VALUE)
            return dp[n][m][rem];

        if(coins[n-1][m-1] < 0 && rem > 0){

            if(m != 1) left = solve(coins,n,m-1,rem-1,dp);
            if(n != 1) upper = solve(coins,n-1,m,rem-1,dp);
            ans =  Math.max(left,upper);
        }

        if(m != 1) left = solve(coins,n,m-1,rem,dp);
        if(n != 1) upper = solve(coins,n-1,m,rem,dp);
        ans = Math.max(coins[n-1][m-1] + Math.max(left,upper), ans);

        return dp[n][m][rem] = ans;
    }

    public int maximumAmount(int[][] coins) {

        int n = coins.length, m = coins[0].length;
        int[][][] dp = new int[n+1][m+1][3];
        for(int i=0;i<=n;++i)
        for(int j=0;j<=m;++j)
        for(int k=0;k<3;++k)
        dp[i][j][k] = Integer.MIN_VALUE;

        return solve(coins,n,m,2,dp);
    }
}