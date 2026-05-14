class Solution {
    public boolean isGood(int[] nums) {
        int n = nums.length;
        int[] cnt = new int[n];
        for(int i=0;i<n;++i){
            if(nums[i] >= n ) return false;
            ++cnt[nums[i]];
            if(nums[i] == n-1 && cnt[nums[i]] > 2) return false;
            if(nums[i] < n-1 && cnt[nums[i]] > 1) return false;
        }
        return true;
    }
}