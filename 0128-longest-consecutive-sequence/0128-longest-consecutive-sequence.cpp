class Solution {
public:
    unordered_map<int,int> mp;
    int find(int num,unordered_map<int,int> &dp){
        if(dp.find(num) != dp.end()) return dp[num];

        if(mp[num] == 0)
           return 0;
        
        mp[num] = 0;
        return dp[num] = 1 + find(num-1,dp) + find(num+1,dp);
    }

    int longestConsecutive(vector<int>& nums) {
        int ans = 0, n =  nums.size();
        for(int i=0;i<n;i++)
           mp[nums[i]] = 1;
        
        for(int i=0;i<n;i++){
            if(mp[nums[i]]){
                unordered_map<int,int> dp;
                ans = max(ans,find(nums[i],dp));
            }
        }

        return ans;
    }
};