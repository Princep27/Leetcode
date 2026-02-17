class Solution {
    void solve(List<String> ans,int remaining,int pos,int hour,int minutes){
        
        if(remaining == 0){
            if(minutes < 60 && hour < 12){
                String hr = "" + hour;
                String min = minutes < 10 ? "0" + minutes : "" + minutes;
                ans.add(hr + ":" + min);
            }
        }else if(pos < 0){
            return;
        }else{
            //0 - 5 -> min, 6 - 9 -> hour
            solve(ans,remaining,pos-1,hour,minutes);
            if(pos >= 6) solve(ans,remaining-1,pos-1,hour + (int)Math.pow(2,pos-6),minutes);
            else solve(ans,remaining-1,pos-1,hour,minutes + (int)Math.pow(2,pos));
        }
    }
    public List<String> readBinaryWatch(int turnedOn) {
        List<String> ans = new ArrayList<>();
        solve(ans,turnedOn,9,0,0);
        return ans;
    }
}