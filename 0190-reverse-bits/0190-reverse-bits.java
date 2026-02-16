class Solution {
    public int reverseBits(int n) {
        int ans = 0;
        for(int i=0;i<=31;++i){
            int tmp = (n >> i ) & 1;
            ans = ans*2 + tmp;
        }
        return ans;
    }
}