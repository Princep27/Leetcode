class Solution {
    int dfs(int[] dis,ArrayList<Integer> adj[],int u){
        int maxi = 0;
        for(int v : adj[u]){
            if(dis[v] == 0){
                maxi = Math.max(maxi, dfs(dis,adj,v));
            }else{
                maxi = Math.max(maxi, dis[v]);
            }
        }

        dis[u] = maxi + 1;
        return dis[u];
    }

    public int maxJumps(int[] arr, int d) {
        int n = arr.length;
        ArrayList<Integer> adj[] = new ArrayList[n];
        for(int i=0;i<n;++i) adj[i] = new ArrayList<>();
        int[] dis = new int[n];
        int ans = 0;

        for(int i=0;i<n;++i){
            //checking left
            for(int j=i-1; j>=0 && j>=i-d; --j) 
                if(arr[j] >= arr[i]) break;
                else adj[i].add(j);

            //checking right
            for(int j=i+1; j<n && j<=i+d; ++j)
                if(arr[j] >= arr[i]) break;
                else adj[i].add(j);
        }

        for(int i=0;i<n;++i){
            if(dis[i] == 0){
                dfs(dis,adj,i);
            }
        }

        for(int i=0;i<n;++i) ans = Math.max(ans, dis[i]);
        return ans;
    }
}