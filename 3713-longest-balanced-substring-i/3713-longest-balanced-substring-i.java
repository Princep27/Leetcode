class Solution {
    public int longestBalanced(String s) {
        int ans = 0, n = s.length();
        int cnt[][] = new int[n+1][26];

        for(int i=0;i<n;++i){
            for(int j=0;j<26;++j) cnt[i+1][j] = cnt[i][j];
            ++cnt[i+1][(int)(s.charAt(i)-'a')];         
        }

        for(int i=1;i<=n;++i){
            for(int j=1;j<=n;++j){

                boolean valid = true;
                int count = 0;

                for(int k=0;k<26;++k){
                    int cur = cnt[j][k] - cnt[i-1][k];
                    if(count == 0) count = cur;
                    
                    if(cur != 0 && cur != count){
                        valid = false; break;
                    }

                }

                if(valid) ans = Math.max(ans, j-i+1);
            }
        }

        return ans;
    }
}