class Solution {
    public int minJumps(int[] arr) {
        int n = arr.length;

        HashMap<Integer,List<Integer>> mp = new HashMap<>();
        for(int i=0;i<n;++i){
            if(!mp.containsKey(arr[i])) mp.put(arr[i],new ArrayList<>());
            mp.get(arr[i]).add(i);
        }

        int[] dist = new int[n];
        for(int i=1;i<n;++i) dist[i] = Integer.MAX_VALUE/2;

        Deque<Integer> q = new LinkedList<>();
        q.addLast(0); 

        while(!q.isEmpty()){
            int qs = q.size();
            for(int i=0;i<qs;++i){
                int u = q.pollFirst();
                int v1 = u-1;
                int v2 = u+1;
                if(v1 >= 0 && (dist[u] + 1) < dist[v1]){
                    dist[v1] = dist[u] + 1; q.addLast(v1);
                }
                if(v2 < n && (dist[u] + 1) < dist[v2]){
                    dist[v2] = dist[u] + 1; q.addLast(v2);
                }
                List<Integer> index = mp.get(arr[u]);
                for(int j=0;j<index.size();++j){
                    int v = index.get(j);
                    if(v != u && dist[u]+1 < dist[v]){
                        dist[v] = dist[u]+1;
                        q.push(v);
                    } 
                }
                index.clear();
            }
        }

        return dist[n-1];
    }
}