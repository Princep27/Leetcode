class Solution {
    public int minPairSum(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int ans = 0, l = 0, r = n-1;
        while(l < r){
            ans = Math.max(ans, nums[l]+nums[r]);
            ++l; --r;
        }
        return ans;
    }
}