class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        HashMap<Integer,Integer> mp = new HashMap<>();
        int l = 0, r = 0, n = nums.length;
        int ans = 0;

        while(r < n){

            int cnt = mp.getOrDefault(nums[r],0)+1;

            if(cnt > k){
                while(nums[l] != nums[r]){
                    mp.put(nums[l],mp.get(nums[l])-1);
                    ++l;
                }
                ++l;
            }else{
                mp.put(nums[r],cnt);
                ans = Math.max(ans, r-l+1);
            }

            ++r;
        }

        return ans;
    }
}