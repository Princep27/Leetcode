class Solution {
    public int concatenatedBinary(int n) {
        long ans = 1,prod = 2,maxi = 2;
        long mod = 1000000007;
        for(int i=2;i<=n;++i){
            
            if(i == maxi){
                maxi *= 2;
                prod = (prod*2)%mod;
            }

            ans = ((ans*prod)%mod + i) % mod;
        }
        return (int)(ans%mod);
    }
}