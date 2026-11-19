class Solution {
public:
    int minimizeSum(vector<int>& nums) {
        int n = nums.size();
        sort(nums.begin(),nums.end());
        int ans = nums[n-1]-nums[2];
        ans = min(ans , nums[n-2]-nums[1]);
        ans = min(ans , nums[n-3]-nums[0]);
        return ans;
    }
};

// 1 4 5 7 8 9