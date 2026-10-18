class Solution {
public:
    vector<int> shortestAlternatingPaths(int n, vector<vector<int>>& redEdges, vector<vector<int>>& blueEdges) {
        vector<vector<pair<int,int>>> adj(n);

        for (auto &e : redEdges)
            adj[e[0]].push_back({e[1], 0});

        for (auto &e : blueEdges)
            adj[e[0]].push_back({e[1], 1});

        queue<pair<int,int>> q;
        //{node,color}
        q.push({0,0});
        q.push({0,1});

        vector<vector<int>> ans(n,vector<int>(2,-1));
        ans[0][0] = 0;
        ans[0][1] = 0;

        while(!q.empty()){
            int u = q.front().first;
            int color = q.front().second;
            q.pop();
            for(auto &[v,colornext] : adj[u]){
                if(colornext == color || ans[v][colornext] != -1) continue;
                ans[v][colornext] = ans[u][color] + 1;
                q.push({v,colornext});
            }
        }

        vector<int> finalans(n);
        for (int i = 0; i < n; ++i) {
            if (ans[i][0] != -1 && ans[i][1] != -1)
                finalans[i] = min(ans[i][0], ans[i][1]);
            else if (ans[i][0] != -1)
                finalans[i] = ans[i][0];
            else
                finalans[i] = ans[i][1];
        }

        return finalans;
    }
};