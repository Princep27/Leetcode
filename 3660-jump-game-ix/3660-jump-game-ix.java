class Solution {
    public int[] maxValue(int[] nums) {
        int n = nums.length;
        int[] suffix = new int[n];
        int[] prefix = new int[n];
        int[] ans = new int[n];

        TreeSet<Integer> set = new TreeSet<Integer>((a,b)->nums[a] == nums[b] ? a-b : Integer.compare(nums[a],nums[b]));

        suffix[n-1] = n-1;
        set.add(n-1);

        for(int i=n-2; i>=0; --i){
            if(nums[set.first()] >= nums[i]){
                set.add(i);
                suffix[i] = i;
            }
            else if(nums[set.first()] < nums[i]){
                suffix[i] = set.lower(i);
            }
        }

        prefix[0] = 0;
        for(int i=1;i<n;++i){
            if(nums[prefix[i-1]] <= nums[i]){
                prefix[i] = i;
            }else{
                prefix[i] = prefix[i-1];
            }
        }

        ans[n-1] = nums[prefix[n-1]];
        for(int i=n-2;i>=0;--i){
            int ansIndex = suffix[prefix[i]];
            if(ansIndex != i){
                ans[i] = ans[ansIndex];
            }else{
                ans[i] = nums[prefix[i]];
            }
        }

        return ans;
    }
}