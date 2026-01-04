class Solution {
public:
    int sumFourDivisors(vector<int>& nums) {
        int ans = 0;
        for(int i=0;i<nums.size();++i){

            int tmp = nums[i],sum = 0, cnt = 0;
            for(int j=1;j<=sqrt(tmp);++j){
                if(tmp%j == 0){
                    sum += j; ++cnt;
                    if(tmp/j == j) continue;
                    sum += tmp/j; ++cnt;
                }
                if(cnt > 4) break;
            }

            if(cnt == 4) ans += sum;
        }
        
        return ans;
    }
};