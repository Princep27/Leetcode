class Solution {
    public boolean uniformArray(int[] nums1) {
        int n = nums1.length;
        int minOdd = Integer.MAX_VALUE;
        int minEven = Integer.MAX_VALUE;

        for(int i=0;i<n;++i){
            if(nums1[i]%2 == 1){
                minOdd = Math.min(minOdd, nums1[i]);
            }else{
                minEven = Math.min(minEven,nums1[i]);
            }
        }

        return minOdd == Integer.MAX_VALUE || minEven > minOdd;
    }
}