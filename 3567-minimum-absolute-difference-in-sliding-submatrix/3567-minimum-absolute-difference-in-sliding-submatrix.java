class Solution {
    public int[][] minAbsDiff(int[][] grid, int k) {
        int n = grid.length, m = grid[0].length;
        int ans[][] = new int[n-k+1][m-k+1];
        for(int i=0; i<n; ++i){
            for(int j=0;j<m;++j){

                if(i+k > n || j+k > m) continue;
                int tmp[] = new int[k*k]; int index = 0;

                for(int p=i;p<i+k;++p){
                    for(int q=j;q<j+k;++q){
                        tmp[index] = grid[p][q];
                        ++index;
                    }
                }

                Arrays.sort(tmp);
                if(k == 1) ans[i][j] = 0;
                else{
                    ans[i][j] = 100000000;
                    for(int p=1;p<k*k;++p){
                        if(tmp[p] != tmp[p-1])
                            ans[i][j] = Math.min(ans[i][j], Math.abs(tmp[p]-tmp[p-1]));
                    }

                    if(ans[i][j] == 100000000) ans[i][j] = 0;
                }
            }
        }

        return ans;
    }
}