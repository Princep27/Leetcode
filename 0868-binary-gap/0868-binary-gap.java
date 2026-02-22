class Solution {
    public int binaryGap(int n) {
        int prev = -1,pos = 0,ans = 0;
        while(n > 0){
            if(n % 2 == 1){
                if(prev != -1) ans = Math.max(ans, pos - prev);
                prev = pos;
            }
            ++pos; n /= 2;
        }
        return ans;
    }
}