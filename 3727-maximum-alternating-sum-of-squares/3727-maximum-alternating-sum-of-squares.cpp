class Solution {
public:
    long long maxAlternatingSum(vector<int>& nums) {
        int n = nums.size();
        vector<long long> arr(n);
        for(int i=0;i<n;++i) arr[i] = 1LL*nums[i]*nums[i];
        sort(arr.begin(),arr.end());
        int m = n/2;
        long long ans = 0;
    
        for(int i=0;i<n;++i){
            if(i < m) ans -= arr[i];
            else ans += arr[i];
        }

        return ans;
    }
};