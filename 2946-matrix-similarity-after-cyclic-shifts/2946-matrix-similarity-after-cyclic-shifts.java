class Solution {
    public boolean areSimilar(int[][] mat, int k) {
        int n = mat.length;
        int m = mat[0].length;
        
        // Copy original matrix
        int[][] arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            System.arraycopy(mat[i], 0, arr[i], 0, m);
        }

        for (int i = 0; i < n; i++) {
            if (i % 2 == 1) {
                for (int p = 0; p < k; p++) {
                    int temp = mat[i][m - 1];
                    for (int j = m - 1; j > 0; j--) {
                        mat[i][j] = mat[i][j - 1];
                    }
                    mat[i][0] = temp;
                }
            } else {
                for (int p = 0; p < k; p++) {
                    int temp = mat[i][0];
                    for (int j = 0; j < m - 1; j++) {
                        mat[i][j] = mat[i][j + 1];
                    }
                    mat[i][m - 1] = temp;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (mat[i][j] != arr[i][j]) {
                    return false;
                }
            }
        }

        return true;
    }
}