class Solution {
public:
    long long maxSubarraySum(vector<int>& arr, int k) {
        long long curSum = 0,ans = 0;
        vector<long long> nums(arr.size()); for(int i=0;i<arr.size();++i) nums[i] = arr[i];
        for(int i=1;i<=nums.size();++i){
            curSum += nums[i-1];
            if(i < k){
                nums[i-1] = curSum; continue;
            }

            if(i == k){
                nums[i-1] = curSum;
                ans = curSum; continue;
            }

            int prevIndex = i - k;
            ans = max(ans,curSum - nums[prevIndex-1]);
            if(i%k == 0) ans = max(ans,curSum);
            nums[i-1] = min(curSum,nums[prevIndex-1]);
        }

        return ans;
    }
};