class Solution {
    public int minSubarray(int[] nums, int p) {
        int n = nums.length,ans = Integer.MAX_VALUE,extraMod = 0;
        for(int it : nums) extraMod = (extraMod + it)%p;
        if(extraMod == 0) return 0;

        HashMap<Integer,Integer> mp = new HashMap<>(); 
        int sum = 0; mp.put(0,-1);
        for(int i=0;i<n;++i){
            sum += nums[i]; sum %= p;
            if(mp.containsKey((p - extraMod + sum)%p)){
                ans = Math.min(ans,i-mp.get((p - extraMod + sum)%p));
            }
            mp.put(sum,i);
        }

        return ans == Integer.MAX_VALUE || ans == n ? -1 : ans;
    }
}