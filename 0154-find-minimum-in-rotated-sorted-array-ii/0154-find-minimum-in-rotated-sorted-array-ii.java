class Solution {
    public int findMin(int[] nums) {
        int n = nums.length;
        int l = 0, r = n-1;
        int ans = nums[0];

        while(l <= r){
            int mid = (l+r)/2;

            if(nums[mid] == nums[r]){
                --r;
            }
            else if(nums[mid] > nums[r]){
                l = mid + 1;
            }else{
                r = mid - 1;
            }

            ans = Math.min(ans, nums[mid]);
        }

        return ans;
    }
}