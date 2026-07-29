class Solution {
    public int candy(int[] nums) {
        int n = nums.length;
        int candies[] = new int[n];

        int cur = 1;
        int ans = 0;

        for(int i=1;i<n;++i){
            if(nums[i] > nums[i-1]){
                ++cur; 
                candies[i] = cur;
            }else{
                cur = 1;
            }
        }

        cur = 1;
        for(int i=n-2;i>=0;--i){
            if(nums[i] > nums[i+1]){
                ++cur;
                candies[i] = Math.max(candies[i],cur);
            }else{
                cur = 1;
            }
        }

        for(int i=0;i<n;++i){
            ans += Math.max(1,candies[i]);
        }

        return ans;
    }
}