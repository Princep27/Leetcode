class Solution {
public:

    long long dfs(int index,vector<bool> &vis,vector<vector<int>> &adj,vector<int> &values,int &cnt,int k){
        long long sum = values[index];
        for(auto it: adj[index]){
            if(!vis[it]){
                vis[it] = true; 
                sum += dfs(it,vis,adj,values,cnt,k);
            }
        }

        if(sum%k == 0){
            ++cnt; return 0;
        }else{
            return sum;
        }
    }

    int maxKDivisibleComponents(int n, vector<vector<int>>& edges, vector<int>& values, int k) {
        int cnt = 0;
        vector<vector<int>> adj(n);
        vector<bool> vis(n,false);
        for(int i=0;i<edges.size();++i){
            int u = edges[i][0], v = edges[i][1];
            adj[u].push_back(v); adj[v].push_back(u);
        }

        vis[0] = true;
        dfs(0,vis,adj,values,cnt,k);
        return cnt;
    }
};