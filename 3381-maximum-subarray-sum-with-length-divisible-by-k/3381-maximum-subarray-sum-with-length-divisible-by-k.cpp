class Solution {
public:
    long long maxSubarraySum(vector<int>& nums, int k) {
        long long curSum = 0,ans = 0;
        vector<long long> minimum(k); 

        // We maintain prefix sums and minimum[r] = smallest prefix sum seen so far
        // at indices where index % k == r. For each index i, the best valid subarray
        // ending at i has sum = curSum - minimum[i % k], because such subarrays have
        // length divisible by k. We also check prefixes starting at 0 when i % k == 0.
        // This lets us compute the maximum valid subarray sum in O(n) time.

        for(int i=0;i<nums.size();++i){
            curSum += (long long)nums[i];
            if(i < k){
                minimum[i] = curSum; 
                ans = curSum; continue;
            }

            int mod = i%k;
            ans = max(ans,curSum - minimum[mod]);
            if((i+1)%k == 0) ans = max(ans,curSum);
            minimum[mod] = min(curSum,minimum[mod]);
        }

        return ans;
    }
};