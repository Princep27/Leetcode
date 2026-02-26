class Solution {

    static void addOne(StringBuilder str){
        int n = str.length();
        int rem = 1;
        for(int i=n-1;i>=0;--i){
            int cnt = str.charAt(i) == '1' ? 1 : 0;
            cnt += rem;
            if(cnt == 1){
                str.setCharAt(i,'1'); rem = 0;
            }else if(cnt == 2){
                str.setCharAt(i,'0'); rem = 1;
            }
        }
        if(rem == 1) str.insert(0,'1');
    }

    public int numSteps(String s) {
        StringBuilder str = new StringBuilder(s);
        int ans = 0;
        while(str.length() != 1){
            int lastIndex = str.length() - 1;
            if(str.charAt(lastIndex) == '1'){
                addOne(str); ++ans;
            }else{
                str.deleteCharAt(lastIndex); ++ans;
            }
        }
        return ans;
    }
}