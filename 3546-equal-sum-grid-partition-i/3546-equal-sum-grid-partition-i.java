class Solution {
    public boolean canPartitionGrid(int[][] grid) {

        int n = grid.length, m = grid[0].length;
        long col[] = new long[m];
        long row[] = new long[n];
        long colSum = 0,rowSum = 0,sum = 0;

        for(int i=0;i<n;++i) for(int j=0;j<m;++j) sum += (long)grid[i][j];
        if(sum % 2 == 1) return false;

        for(int i=0;i<n;++i){
            for(int j=0;j<m;++j){
                row[i] += grid[i][j];
                col[j] += grid[i][j];
            }
        }

        for(int i=0;i<n;++i){
            rowSum += row[i];
            if(rowSum == sum/2) return true;
            else if(rowSum > sum/2) break;
        }

        for(int i=0;i<m;++i){
            colSum += col[i];
            if(colSum == sum/2) return true;
            else if(colSum > sum/2) break;
        }
        
        return false;
    }

}