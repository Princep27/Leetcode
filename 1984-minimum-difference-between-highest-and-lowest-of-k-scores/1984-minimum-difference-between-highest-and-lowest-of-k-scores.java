class Solution {
    public int minimumDifference(int[] nums, int k) {
        int n = nums.length;
        int ans = Integer.MAX_VALUE;
        Arrays.sort(nums);
        for(int i=0;i<=n-k;++i){
            ans = Math.min(ans, nums[i+k-1] - nums[i]);
        }
        return ans;
    }
}