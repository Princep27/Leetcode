class Solution {

    static boolean dfs(int[][] grid,boolean[][] vis,int x,int y,int n,int m){

        if(x == n-1 && y == m-1) return true;
        vis[x][y] = true;
        boolean valid = false;

        int[][][] dir = new int[7][][];
        dir[1] = new int[][]{{0,-1},{0,1}};
        dir[2] = new int[][]{{-1,0},{1,0}};
        dir[3] = new int[][]{{0,-1},{1,0}};
        dir[4] = new int[][]{{0,1},{1,0}};
        dir[5] = new int[][]{{0,-1},{-1,0}};
        dir[6] = new int[][]{{0,1},{-1,0}};

        for(int[] arr : dir[grid[x][y]]){
            int new_x = x + arr[0];
            int new_y = y + arr[1];
            if(new_x < 0 || new_y < 0 || new_x >= n || new_y >= m || vis[new_x][new_y]) continue;

            //checking valid or not
            for(int[] tmp : dir[grid[new_x][new_y]]){
                int back_x = new_x + tmp[0];
                int back_y = new_y + tmp[1];
                if(back_x == x && back_y == y){
                    if(dfs(grid,vis,new_x,new_y,n,m)) 
                        valid = true;
                }
            }
        }

        return valid;
    }

    public boolean hasValidPath(int[][] grid) {

        int n = grid.length, m = grid[0].length;
        boolean[][] vis = new boolean[n][m];

        int x = 0, y = 0;
        if(dfs(grid,vis,x,y,n,m)) return true;
        return false;

    }
}