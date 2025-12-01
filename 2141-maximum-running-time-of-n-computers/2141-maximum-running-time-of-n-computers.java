class Solution {
    public long maxRunTime(int n, int[] batteries) {
        long sum = 0;
        for (int b : batteries) sum += b;

        long left = 0, right = sum / n;

        while (left < right) {
            long mid = (left + right + 1) / 2;

            long usable = 0;
            for (int b : batteries)
                usable += Math.min(b, mid);

            if (usable >= mid * n)
                left = mid;   
            else
                right = mid - 1; 
        }

        return left;
    }
}
