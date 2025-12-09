class Solution {
public:
    int specialTriplets(vector<int>& nums) {
        unordered_map<int,int> left,right;
        long ans = 0;
        for(int i=1;i<nums.size();++i) ++right[nums[i]]; ++left[nums[0]];
        for(int i=1;i<nums.size()-1;++i){
            --right[nums[i]];
            if(left.count(nums[i]*2) && right.count(nums[i]*2)){
                ans += ((long)left[nums[i]*2])*((long)right[nums[i]*2]);
                ans %= 1000000007;
            }
            ++left[nums[i]];
        }
        return ans;
    }
};