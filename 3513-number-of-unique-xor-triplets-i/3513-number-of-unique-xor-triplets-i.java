class Solution {
    public int uniqueXorTriplets(int[] nums) {
        int n = nums.length;
        int maxi = 0;
        if(n <= 2) return n;
        for(int i=0;i<n;++i){
            maxi |= nums[i];
        }
        return maxi + 1;
    }
}