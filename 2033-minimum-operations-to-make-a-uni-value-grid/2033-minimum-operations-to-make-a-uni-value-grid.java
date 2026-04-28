class Solution {

    public int minOperations(int[][] grid, int x) {
        int n = grid.length, m = grid[0].length;
        int ans = Integer.MAX_VALUE;
        int[] arr = new int[n*m];
        int mini = Integer.MAX_VALUE;
        int maxi = Integer.MIN_VALUE;

        int idx = 0;
        for(int i=0; i<n; ++i){
            for(int j=0; j<m; ++j){
                arr[idx] = grid[i][j];
                if(idx != 0 && arr[idx]%x != arr[idx-1]%x) return -1; 
                ++idx;
            }
        }

        Arrays.sort(arr);
        int[] pref = new int[n*m];
        int[] suff = new int[n*m];

        for(int i=0;i<n*m;++i) pref[i] = arr[i] + (i != 0 ? pref[i-1] : 0);
        for(int i=n*m-1;i>=0;--i) suff[i] = arr[i] + (i != n*m-1 ? suff[i+1] : 0);

        for(int i=0; i<n*m; ++i){
            int target = arr[i];
            int leftCount = i+1;
            int rightCount = n*m - i;
            int leftSum = pref[i];
            int rightSum = suff[i];
            ans = Math.min(ans, (target*leftCount - leftSum)/x + (rightSum - target*rightCount)/x);
        }

        return ans;
    }
}