class Solution {
    public int minOperations(int[] nums, int x) {
        int n = nums.length;
        HashMap<Long, Integer> mp = new HashMap<>();
        long sum = 0;

        for (int i = n - 1; i >= 0; --i) {
            sum = sum + nums[i];   
            mp.put(sum, i);
        }

        int ans = n + 1;
        if(mp.containsKey((long)x)) ans = n - mp.get((long)x);
        sum = 0;

        for (int i = 0; i < n; ++i) {
            sum += nums[i];      

            if(sum == x){
                ans = Math.min(ans, i+1);
            }else if(mp.containsKey(x-sum) && mp.get(x-sum) > i){
                ans = Math.min(ans, i + 1 + n - mp.get(x-sum));
            }
        }

        return ans != n + 1 ? ans : -1;
    }
}