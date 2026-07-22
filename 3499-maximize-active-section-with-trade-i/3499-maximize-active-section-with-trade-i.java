class Solution {
    public int maxActiveSectionsAfterTrade(String s){
        int one = 0, cur = 0;
        if(s.charAt(0) == '0') ++cur;
        else ++one;
        
        ArrayList<Integer> arr = new ArrayList<>();
        for(int i=1;i<s.length();++i){
            if(s.charAt(i) == '1'){
                ++one;
                if(cur > 0) arr.add(cur);
                cur = 0;
            }else{
                ++cur;
            }
        }

        if(cur > 0) arr.add(cur);

        int ans = 0;
        for(int i=1;i<arr.size();++i){
            ans = Math.max(ans, arr.get(i-1)+arr.get(i));
        }

        ans += one;

        return ans;
    }
}