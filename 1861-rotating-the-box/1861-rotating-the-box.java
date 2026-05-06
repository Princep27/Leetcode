class Solution {
    public char[][] rotateTheBox(char[][] boxGrid) {
        int n = boxGrid.length;
        int m = boxGrid[0].length;

        for(int row=0;row<n;++row){
            int x = row, y = m-1;
            for(int col=m-1;col>=0;--col){

                //obstacle
                if(boxGrid[row][col] == '*'){
                    y = col;
                }

                //stone
                else if(boxGrid[row][col] == '#'){
                    if(boxGrid[x][y] == '.'){
                        boxGrid[row][col] = '.';
                        boxGrid[x][y] = '#';
                    }
                    --y;
                }

                //empty
                else{
                    if(boxGrid[x][y] != '.') y = col;
                }
            }
        }

        char[][] ans = new char[m][n];
        for(int i=0;i<m;++i){
            for(int j=0;j<n;++j){
                ans[i][n-1-j] = boxGrid[j][i];
            }
        }

        return ans;
    }
}