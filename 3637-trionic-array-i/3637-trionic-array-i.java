class Solution {
    public boolean isTrionic(int[] nums) {
        int n = nums.length;
        int index = 1,prev = 1;

        while(index < n && nums[index] > nums[index-1]) ++index;
        if(prev == index || index == n) return false;
        prev = index;

        while(index < n && nums[index] < nums[index-1]) ++index;
        if(prev == index || index == n) return false;
        prev = index;

        while(index < n && nums[index] > nums[index-1]) ++index;
        if(prev == index || index != n) return false;
        return true;
        
    }
}