class Solution {
    public int longestBalanced(int[] nums) {
        int ans = 0,times = 0;
        HashMap<Integer,Integer> mp = new HashMap<>();
        for(int i=0;i<nums.length;++i){
            int odd = 0, even = 0; ++times;
            for(int j=i;j<nums.length;++j){
                int val = nums[j];
                int time = 0;

                if(mp.containsKey(val))
                    time = mp.get(val);
                
                if(time != times){
                    if(val % 2 == 1) ++odd;
                    else ++even;
                }

                mp.put(val,times);
                if(even == odd) ans = Math.max(ans, j-i+1);
            }
        }
        return ans;
    }
}