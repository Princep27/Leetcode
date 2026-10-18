class Solution {
public:
    int longestConsecutive(vector<int>& nums) {
        int ans = 0, n =  nums.size();
        map<int,int> mp;

        for(int i=0;i<n;i++)
           mp[nums[i]] = 1;
        
        for(int i=0;i<n;++i){
            int val = nums[i];

            if(mp[val]){
                int cnt = 0;
                while(mp[val]){
                     cnt += mp[val]; mp[val] = 0; --val; 
                }
                mp[nums[i]] = cnt;
                ans = max(ans,cnt);
            }
        }

        return ans;
    }
};