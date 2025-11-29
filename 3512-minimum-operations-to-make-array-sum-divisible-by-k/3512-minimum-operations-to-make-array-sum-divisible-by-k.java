class Solution {
    public int minOperations(int[] nums, int k) {
        int sum = 0;
        for(int it : nums) sum += it;
        return sum%k;
    }
}