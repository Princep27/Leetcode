class Solution {

    static int[] next_x = {0, 1, 0, -1};
    static int[] next_y = {1, 0, -1, 0};

    static void rotate(int i, int[][] grid, int n, int m) {

        int x = i, y = i;
        int tmp = grid[i][i];
        int cur = 0;

        while (true) {

            int xx = x + next_x[cur];
            int yy = y + next_y[cur];

            if (xx == i && yy == i) {
                grid[x][y] = tmp;
                break;
            }
            else if (xx < i || yy < i || xx > (n - 1 - i) || yy > (m - 1 - i)) {
                ++cur;
            }
            else {
                grid[x][y] = grid[xx][yy];
                x = xx;
                y = yy;
            }
        }
    }

    public int[][] rotateGrid(int[][] grid, int k) {

        int n = grid.length;
        int m = grid[0].length;

        for (int i = 0; i < Math.min(n / 2, m / 2); ++i) {

            int rows = n - 2 * i;
            int cols = m - 2 * i;
            int cnt = k % (2 * (rows + cols) - 4);

            while (cnt > 0) {
                rotate(i, grid, n, m);
                --cnt;
            }
        }

        return grid;
    }
}