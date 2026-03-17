class Solution {
    public int largestSubmatrix(int[][] matrix) {
        int ans = 0;
        int n = matrix.length, m = matrix[0].length;
        for(int col=0;col<m; ++col){
            for(int row=1;row<n; ++row){
                if(matrix[row][col] == 1) matrix[row][col] += matrix[row-1][col];
            }
        }

        for(int row=0;row<n;++row){
            Arrays.sort(matrix[row]);
            for(int col=m-1;col >=0; --col){
                ans = Math.max(ans, matrix[row][col]*(m-col));
            }
        }

        return ans;
    }
}