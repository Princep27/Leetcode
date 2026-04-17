class Solution {
    static int rev(int num){
        int tmp = 0;
        while(num > 0){
            tmp = tmp*10 + num%10;
            num /= 10;
        }
        return tmp;
    }

    public int minMirrorPairDistance(int[] nums) {
        int n = nums.length;
        int ans = n;
        HashMap<Integer,Integer> mp = new HashMap<>();

        for(int i=n-1;i>=0;--i){
            int key = rev(nums[i]);
            if(mp.containsKey(key)){
                ans = Math.min(ans, mp.get(key)-i);
            }
            mp.put(nums[i],i);
        }

        return ans == n ? -1 : ans;
    }
}