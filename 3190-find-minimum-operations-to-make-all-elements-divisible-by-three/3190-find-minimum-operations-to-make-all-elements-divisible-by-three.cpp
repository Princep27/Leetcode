class Solution {
public:
    int minimumOperations(vector<int>& nums) {
        int cnt = 0;
        for(auto it : nums) if(it%3 == 0) ++cnt;
        return nums.size() - cnt;
    }
};