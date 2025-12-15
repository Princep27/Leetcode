class Solution {
public:
    long long getDescentPeriods(vector<int>& prices) {
        long long ans = 0,cnt = 0,prev = -1;
        for(int i=0;i<prices.size();++i){
            if((prev-prices[i]) == 1){
                ++cnt; ans += cnt;
            }else{
                ans += 1; cnt = 1;
            }
            prev = prices[i];
        }
        return ans;
    }
};