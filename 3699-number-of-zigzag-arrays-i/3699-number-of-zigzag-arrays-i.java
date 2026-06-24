class Solution {
    public int zigZagArrays(int n, int l, int r) {
        long increasing[] = new long[2001];
        long decreasing[] = new long[2001];
        long mod = 1000000007;
        
        for(int i=l;i<=r;++i){
            increasing[i] = 1;
            decreasing[i] = 1;
        }

        for(int i=2;i<=n;++i){
            long inc[] = new long[2001];
            long dec[] = new long[2001];

            for(int j=l+1;j<=r;++j){
                dec[l] = (dec[l] + increasing[j])%mod;
                dec[j] = (mod + dec[j] - increasing[j])%mod;
            }

            for(int j=l;j<=r-1;++j){
                inc[j+1] = (inc[j+1] + decreasing[j])%mod;
            }

            for(int j=l;j<=r;++j){
                inc[j] = (inc[j-1] + inc[j])%mod;
            }

            for(int j=l;j<=r;++j){
                dec[j] = (dec[j-1] + dec[j])%mod;
            }
            
            increasing = inc;
            decreasing = dec;
        }

        long ans = 0;
        for(int i=l;i<=r;++i){
            ans = (ans + increasing[i])%mod;
            ans = (ans + decreasing[i])%mod;
        }

        return (int)ans;  
    }
}