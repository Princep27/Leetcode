class Solution {
    public int minimumCost(int[] nums) {
        int len = nums.length;
        int first = nums[1], second = 100;
        for(int i=2;i<len;++i){
            if(nums[i] <= first){
                second = first;
                first = nums[i]; 
            }else{
                second = Math.min(second,nums[i]);
            }
        }
        return nums[0] + first + second;
    }
}