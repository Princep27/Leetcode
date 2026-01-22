class Solution {

    public static boolean valid(int[] nums,int n){
        if(n == 1) return true;
        for(int i=1;i<n;++i)
            if(nums[i] < nums[i-1]) return false;
        return true;
    }

    public int minimumPairRemoval(int[] nums) {
        int n = nums.length,ans = 0;

        while(!valid(nums,n)){
            int minIndex = 0;
            for(int i=1;i<n-1;++i){
                if(nums[i]+nums[i+1] < nums[minIndex] + nums[minIndex+1]) 
                    minIndex = i;
            }

            nums[minIndex] = nums[minIndex] + nums[minIndex+1];
            for(int i=minIndex+1;i<n-1;++i)
                nums[i] = nums[i+1];

            --n;
            ++ans;
        }

        return ans;
    }
}