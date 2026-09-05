class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int n = nums.length;
        int[] miniNum = new int[n];
        int maxi = Integer.MIN_VALUE, mini;
        miniNum[n-1] = nums[n-1];

        for(int i=n-2;i>=0;--i) miniNum[i] = Math.min(nums[i],miniNum[i+1]);
        for(int i=0;i<n;++i){
            maxi = Math.max(maxi,nums[i]);
            mini = miniNum[i];
            if(maxi - mini <= k) return i;
        }
        return -1;
    }
}