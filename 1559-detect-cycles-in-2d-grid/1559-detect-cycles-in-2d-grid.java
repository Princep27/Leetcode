class Solution {

    static int[] dir_x = {0,0,1,-1};
    static int[] dir_y = {1,-1,0,0};

    static boolean isValid(int i,int j,int n,int m){
        if(i < 0 || i >= n || j < 0 || j >= m) return false;
        return true;
    }

    static boolean check(char[][] grid,boolean[][] vis,int x,int y,int prev_x,int prev_y,int n,int m){
        vis[x][y] = true;
        for(int k=0;k<4;++k){
            int next_x = x + dir_x[k], next_y = y + dir_y[k];
            if(isValid(next_x,next_y,n,m) && !(next_x == prev_x && next_y == prev_y) && grid[x][y] == grid[next_x][next_y]){
                if(vis[next_x][next_y]) return true;
                else{
                    if(check(grid,vis,next_x,next_y,x,y,n,m)) return true;
                }
            }
        }

        return false;
    }

    public boolean containsCycle(char[][] grid) {
        int n = grid.length, m = grid[0].length;
        boolean[][] vis = new boolean[n][m];

        for(int i=0;i<n;++i){
            for(int j=0;j<m;++j){
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }
        
        for(int i=0;i<n;++i){
            for(int j=0;j<m;++j){

                if(!vis[i][j]){
                    if(check(grid,vis,i,j,-1,-1,n,m)){
                        System.out.print(i + " " +j +  grid[i][j]);
                        return true;
                    }
                }
            }
        }

        return false;
    }
}