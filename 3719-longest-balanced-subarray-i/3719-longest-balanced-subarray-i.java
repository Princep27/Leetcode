class Solution {
    public int longestBalanced(int[] nums) {
        int ans = 0;
        for(int i=0;i<nums.length;++i){
            int odd = 0, even = 0;
            HashMap<Integer,Integer> mp = new HashMap<>();
            for(int j=i;j<nums.length;++j){
                int val = nums[j];
                int count = 0;

                if(mp.containsKey(val)){
                    count = mp.get(val);
                }else{
                    if(val%2 == 1) ++odd;
                    else ++even;
                }

                mp.put(val,count+1);
                if(even == odd) ans = Math.max(ans, j-i+1);
            }
        }
        return ans;
    }
}