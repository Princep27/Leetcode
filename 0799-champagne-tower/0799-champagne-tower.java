class Solution {
    public double champagneTower(int poured, int query_row, int query_glass) {
        double[][] tower = new double[102][102];
        tower[0][0] = (double) poured;
        for(int i=1;i<=query_row;++i){
            for(int j=0;j<i;++j){
                if(tower[i-1][j] > 1){
                    tower[i][j] += (tower[i-1][j]-1)/2;
                    tower[i][j+1] += (tower[i-1][j]-1)/2;
                }
            }
        }

        if(tower[query_row][query_glass] > 1) return (double)1;
        else return tower[query_row][query_glass];
    }
}

/*

1
1/2 1/2
1/4 2/4 1/4
1/8 3/8 3/8 1/8
1/16 4/16 6/16 4/16 1/16
*/