class Solution {
public:
    int countPartitions(vector<int>& nums) {
        int sum = 0,cur = 0,ans = 0; for(auto it: nums) sum += it;
        for(int i=0;i<nums.size()-1;++i){
            cur += nums[i]; sum -= nums[i];
            if(abs(cur-sum)%2 == 0) ++ans;
        }
        return ans;
    }
};