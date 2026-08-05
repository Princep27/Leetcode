class Solution {
    void fill(List<List<Integer>> adj, boolean[] sus, boolean[] vis, int n, int node, boolean val) {
        Queue<Integer> q = new LinkedList<>();
        q.add(node);
        vis[node] = true;

        while (!q.isEmpty()) {
            int curNode = q.poll();
            sus[curNode] = val;

            for (int next : adj.get(curNode)) {
                if (!vis[next]) {
                    vis[next] = true;
                    q.add(next);
                }
            }
        }
    }

    public List<Integer> remainingMethods(int n, int k, int[][] invocations) {
        boolean[] sus = new boolean[n];
        List<List<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++)
            adj.add(new ArrayList<>());

        for (int[] edge : invocations) {
            adj.get(edge[0]).add(edge[1]);
        }

        boolean[] vis = new boolean[n];
        fill(adj, sus, vis, n, k, true);

        for (int[] edge : invocations) {
            int u = edge[0];
            int v = edge[1];

            if (!sus[u] && sus[v]) {
                List<Integer> ans = new ArrayList<>();
                for (int i = 0; i < n; i++)
                    ans.add(i);
                return ans;
            }
        }

        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (!sus[i])
                ans.add(i);
        }

        return ans;
    }
}