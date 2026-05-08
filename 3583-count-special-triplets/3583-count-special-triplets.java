class Solution {
    public int specialTriplets(int[] nums) {
        int n = nums.length;
        long ans = 0;
        int mod = 1000000007;

        HashMap<Integer,Integer> left = new HashMap<>();
        HashMap<Integer,Integer> right = new HashMap<>();

        for(int i=2;i<n;++i) right.put(nums[i], right.getOrDefault(nums[i],0) + 1);

        left.put(nums[0],1);

        for(int i=1;i<n-1;++i){
            int l = left.getOrDefault(nums[i]*2,0);
            int r = right.getOrDefault(nums[i]*2,0);
            ans = (ans + ((long)l * (long)r))%mod;
            
            left.put(nums[i],left.getOrDefault(nums[i],0) + 1);
            right.put(nums[i+1], right.get(nums[i+1]) - 1);
        }

        return (int)ans;
    }
}