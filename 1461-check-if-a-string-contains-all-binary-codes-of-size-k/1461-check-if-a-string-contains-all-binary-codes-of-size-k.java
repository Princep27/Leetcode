class Solution {
    public boolean hasAllCodes(String s, int k) {
        int count = (int)Math.pow(2,k) - 1;
        boolean[] cnt = new boolean[count+1];
        int sum = 0;

        for(int i=0; i < s.length(); ++i){
            sum *= 2;
            if(s.charAt(i) == '1') ++sum;
            if(i < k-1) continue;
            else if(i == k-1) cnt[sum] = true;
            else{
                if(s.charAt(i-k) == '1') sum -= (int)Math.pow(2, k);
                cnt[sum] = true;
            }
        }

        for(int i=0;i<=Math.pow(2,k)-1;++i) if(cnt[i] == false) return false;
        return true;
    }
}