class Solution {
    public int minimumHammingDistance(int[] source, int[] target, int[][] allowedSwaps) {
        int n = source.length;
        int ans = n;
        boolean vis[] = new boolean[n];

        for(int i=0;i<n;++i) vis[i] = false;

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>(n);
        for(int i=0;i<n;++i) adj.add(new ArrayList<>());

        for(int i=0;i<allowedSwaps.length;++i){
            int u = allowedSwaps[i][0], v = allowedSwaps[i][1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        for(int i=0;i<n;++i){
            int cur = i;

            if(vis[cur] == false){

                HashMap<Integer,Integer> mp = new HashMap<>();
                ArrayList<Integer> indexes = new ArrayList<>();
                Deque<Integer> q = new ArrayDeque<>();
                q.addLast(cur);
                vis[cur] = true;

                while(q.size() != 0){

                    int sz = q.size();
                    for(int j=0;j<sz;++j){
                        int val = q.pollFirst();
                        indexes.add(val);

                        int m = adj.get(val).size();
                        for(int k=0;k<m;++k){
                            int vall = adj.get(val).get(k);
                            if(!vis[vall]){
                                q.addLast(vall);
                                vis[vall] = true;
                            }
                        }
                    }
                }

                for(int j=0;j<indexes.size();++j){
                    int index = indexes.get(j);
                    int val = target[index];
                    int cnt = 0;
                    if(mp.containsKey(val)) cnt = mp.get(val);
                    mp.put(val,cnt+1);
                }

                for(int j=0;j<indexes.size();++j){
                    int index = indexes.get(j);  
                    int val = source[index];
                    if(mp.containsKey(val)){
                        --ans; 
                        if(mp.get(val) == 1) mp.remove(val);
                        else mp.put(val,mp.get(val)-1);
                    }
                }
            }
        }

        return ans;
    }
}