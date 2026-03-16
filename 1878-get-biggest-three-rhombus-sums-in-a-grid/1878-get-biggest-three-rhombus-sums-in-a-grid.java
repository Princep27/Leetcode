
class Solution {
    public int[] getBiggestThree(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        Set<Integer> uniqueSum = new TreeSet<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                uniqueSum.add(grid[i][j]);

                for (int len = 1; i + 2 * len < n && j - len >= 0 && j + len < m; len++) {
                    int currentSum = 0;

                    for (int ind = 0; ind < len; ind++)
                        currentSum += grid[i + ind][j + ind];

                    for (int ind = 0; ind < len; ind++)
                        currentSum += grid[i + len + ind][j + len - ind];

                    for (int ind = 0; ind < len; ind++)
                        currentSum += grid[i + 2 * len - ind][j - ind];

                    for (int ind = 0; ind < len; ind++)
                        currentSum += grid[i + len - ind][j - len + ind];

                    uniqueSum.add(currentSum);
                }
            }
        }

        List<Integer> list = new ArrayList<>(uniqueSum);
        Collections.sort(list, Collections.reverseOrder());

        int size = Math.min(3, list.size());
        int[] ans = new int[size];

        for (int i = 0; i < size; i++) {
            ans[i] = list.get(i);
        }

        return ans;
    }
}