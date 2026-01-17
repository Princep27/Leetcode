class Solution {
    public long largestSquareArea(int[][] bottomLeft, int[][] topRight) {
        long ans = 0;
        int n = bottomLeft.length;

        for (int i = 0; i < n; i++) {
            int x1 = bottomLeft[i][0];
            int y1 = bottomLeft[i][1];
            int x2 = topRight[i][0];
            int y2 = topRight[i][1];

            for (int j = i + 1; j < n; j++) {
                int xx1 = bottomLeft[j][0];
                int yy1 = bottomLeft[j][1];
                int xx2 = topRight[j][0];
                int yy2 = topRight[j][1];

                int overlapWidth  = Math.max(0, Math.min(x2, xx2) - Math.max(x1, xx1));
                int overlapHeight = Math.max(0, Math.min(y2, yy2) - Math.max(y1, yy1));

                int side = Math.min(overlapWidth, overlapHeight);
                ans = Math.max(ans, (long) side * side);
            }
        }

        return ans;
    }
}
