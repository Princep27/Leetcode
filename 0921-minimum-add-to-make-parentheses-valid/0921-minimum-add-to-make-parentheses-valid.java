class Solution {
    public int minAddToMakeValid(String s) {
        int n = s.length();
        int open = 0,ans = 0;
        for(int i=0;i<n;++i){
            if(s.charAt(i) == '('){
                ++open;
            }else{
                if(open == 0) ++ans;
                else --open;
            }
        }
        ans += open;
        return ans;
    }
}