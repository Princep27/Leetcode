class Solution {
    public int largestInteger(int[] nums, int k) {
        int n = nums.length;
        int ans = -1;
        for(int i=0;i<n;++i){
            int num = nums[i];
            int cnt = 0;

            for(int j=0;j<=n-k;++j){
                for(int p=j;p<j+k;++p){
                    if(nums[p] == num){
                        ++cnt; break;
                    }
                }
            }

            if(cnt == 1) ans = Math.max(ans, num);
        }

        return ans;
    }
}