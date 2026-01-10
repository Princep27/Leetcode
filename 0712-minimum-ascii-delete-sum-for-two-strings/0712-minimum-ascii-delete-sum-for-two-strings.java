class Solution {

    static int solve(String s1,String s2,int[] sum1,int[] sum2,int n,int m,int[][] dp){
        if(dp[n][m] != -1) return dp[n][m];
        if(n == 0 || m == 0) return sum1[n] + sum2[m];
        if(s1.charAt(n-1) == s2.charAt(m-1)) return solve(s1,s2,sum1,sum2,n-1,m-1,dp);
        return dp[n][m] = Math.min((int)s1.charAt(n-1) + solve(s1,s2,sum1,sum2,n-1,m,dp), (int)s2.charAt(m-1) + solve(s1,s2,sum1,sum2,n,m-1,dp));
    }

    public int minimumDeleteSum(String s1, String s2) {
        int n = s1.length(), m = s2.length();
        int[] sum1 = new int[n+1];
        int[] sum2 = new int[m+1];
        for(int i=0;i<n;++i) sum1[i+1] = sum1[i] + (int)s1.charAt(i);
        for(int i=0;i<m;++i) sum2[i+1] = sum2[i] + (int)s2.charAt(i);
        int[][] dp = new int[n+1][m+1]; for(int i=0;i<=n;++i) for(int j=0;j<=m;++j) dp[i][j] = -1;
        return solve(s1,s2,sum1,sum2,n,m,dp);
    }
}