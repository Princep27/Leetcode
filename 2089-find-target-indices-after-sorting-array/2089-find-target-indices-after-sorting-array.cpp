class Solution {
public:
    vector<int> targetIndices(vector<int>& nums, int target) {
        int cnt = 0, pos = 0;
        int n = nums.size();
        for(int i=0;i<n;++i){
            if(nums[i] == target) ++cnt;
            if(nums[i] < target) ++pos; 
        }

        vector<int> ans(cnt);
        for(int i=pos;i<pos+cnt;++i) ans[i-pos] = i;
        return ans;
    }
};