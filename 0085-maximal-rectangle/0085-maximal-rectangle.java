class Solution {

    static boolean isValid(int[][] sum,int row1,int col1,int row2,int col2){
        int total = sum[row2][col2];
        if(col1 != 0) total -= sum[row2][col1-1];
        if(row1 != 0) total -= sum[row1-1][col2];
        if(row1 != 0 && col1 != 0) total += sum[row1-1][col1-1];
        if(total == (row2-row1+1)*(col2-col1+1)) return true;
        else return false;
    }

    static int check(char[][] matrix,int[][] sum,int row,int col,int n,int m){
        int ans = 0,col_sum = 0,cnt = 0;

        for(int i=col;i<m;++i){
            col_sum = col_sum + (matrix[row][i] == '1' ? 1 : 0);
            ++cnt;
            if(cnt != col_sum) break;

            int l_row = row, r_row = n-1;
            while(l_row <= r_row){
                int mid = (l_row + r_row)/2;
                if(isValid(sum,row,col,mid,i)){
                    ans = Math.max(ans,(mid-row+1)*(i-col+1));
                    l_row = mid+1;
                }else{
                    r_row = mid-1;
                }
            }
        }

        return ans;
    }

    public int maximalRectangle(char[][] matrix) {

        int n = matrix.length, m = matrix[0].length;
        int[][] sum = new int[n][m];
        int ans = 0;

        for(int i=0;i<n;++i){
            for(int j=0;j<m;++j){
                if(j == 0) sum[i][j] = (matrix[i][j] == '1' ? 1 : 0);
                else sum[i][j] = sum[i][j-1] + (matrix[i][j] == '1' ? 1 : 0);
            }
        }

        for(int j=0;j<m;++j){
            for(int i=1;i<n;++i){
                sum[i][j] = sum[i-1][j] + sum[i][j];
            }
        }

        for(int i=0;i<n;++i){
            for(int j=0;j<m;++j){
                ans = Math.max(ans,check(matrix,sum,i,j,n,m));
            }
        }

        return ans;
    }
}