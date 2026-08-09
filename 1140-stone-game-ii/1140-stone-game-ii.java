class Solution {
    int solve(int[] piles,int cur,int cnt,int n,int[][] dp){
        int sum = 0;
        int ans = Integer.MIN_VALUE;
        int m = 2*cnt;
        
        if(cur >= n) return 0;
        if(dp[cur][cnt] != Integer.MIN_VALUE) return dp[cur][cnt];

        for(int i=cur;i<cur+m && i<n;++i){
            sum += piles[i];
            ans = Math.max(ans,sum - solve(piles,i+1,Math.max(cnt, i - cur + 1),n,dp));
        }

        return dp[cur][cnt] = ans;
    }

    public int stoneGameII(int[] piles) {
        int n = piles.length;
        int sum = 0; for(int i: piles) sum += i;
        int[][] dp = new int[n+1][n+1];
        for(int i=0;i<=n;++i) Arrays.fill(dp[i], Integer.MIN_VALUE);
        int diff = solve(piles,0,1,n,dp);
        //a + b = sum.  
        //a - b = diff.  
        //2a = sum + diff 
        //a = (sum + diff)/2;
        return (sum + diff)/2;
    }
}