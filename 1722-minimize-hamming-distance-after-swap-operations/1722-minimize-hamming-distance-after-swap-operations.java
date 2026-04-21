class Solution {
    public int minimumHammingDistance(int[] source, int[] target, int[][] allowedSwaps) {
        int n = source.length, ans = n;
        boolean[] vis = new boolean[n];

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());

        for (int[] s : allowedSwaps) {
            adj.get(s[0]).add(s[1]);
            adj.get(s[1]).add(s[0]);
        }

        for (int i = 0; i < n; i++) {
            if (vis[i]) continue;

            HashMap<Integer, Integer> mp = new HashMap<>();
            ArrayList<Integer> comp = new ArrayList<>();
            Deque<Integer> q = new ArrayDeque<>();

            q.add(i);
            vis[i] = true;

            while (!q.isEmpty()) {
                int v = q.poll();
                comp.add(v);

                for (int nei : adj.get(v)) {
                    if (!vis[nei]) {
                        vis[nei] = true;
                        q.add(nei);
                    }
                }
            }

            for (int idx : comp)
                mp.put(target[idx], mp.getOrDefault(target[idx], 0) + 1);

            for (int idx : comp) {
                if (mp.getOrDefault(source[idx], 0) > 0) {
                    ans--;
                    mp.put(source[idx], mp.get(source[idx]) - 1);
                }
            }
        }
        return ans;
    }
}