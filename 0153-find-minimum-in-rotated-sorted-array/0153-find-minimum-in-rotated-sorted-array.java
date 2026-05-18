class Solution {
    public int findMin(int[] nums) {
        int n = nums.length;
        int l = 0, r = n-1;
        int ans = nums[0];
        
        while(l <= r){
            int mid = (l+r)/2;
            if(l == r){
                ans = Math.min(ans, nums[mid]);
                break;
            }
            else if(nums[mid] < nums[r]){
                ans = Math.min(ans, nums[mid]);
                r = mid - 1;
            }else{
                l = mid + 1;
            }
        }

        return ans;
    }
}