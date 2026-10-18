class Solution {
public:
    int minOperations(vector<int>& nums) {
        int n = nums.size();
        int ans = 0;
        unordered_map<int,int> mp;
        for(auto it : nums){
            ++mp[it];
        }

        for(auto &[tmp,cnt]: mp){
            if(cnt == 1) return -1;
            ans += (cnt/3);
            if(cnt%3 != 0) ++ans;
        }

        return ans;
    }
};