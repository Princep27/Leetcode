class Solution {
    public boolean winnerSquareGame(int n) {
        boolean[] dp = new boolean[n+1];
        Arrays.fill(dp,false);

        for(int i=1;i<=n;++i){
            int sq = (int)Math.sqrt(i);
            if(sq*sq == i){
                dp[i] = true;
            }else{
                for(int j=sq;j>0;--j){
                    if(dp[i-j*j] == false){
                        dp[i] = true; break;
                    }
                }
            }
        }

        return dp[n];
    }
}