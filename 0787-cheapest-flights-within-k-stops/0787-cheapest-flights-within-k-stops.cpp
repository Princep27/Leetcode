class Solution {
public:
    int findCheapestPrice(int n, vector<vector<int>>& flights, int src, int dst, int k) {
        vector<vector<int>> distance(n+1,vector<int>(k+2,INT_MAX/2));
        vector<vector<pair<int,int>>> adj(n+1);
        priority_queue<tuple<int,int,int>,vector<tuple<int,int,int>>, greater<tuple<int,int,int>>> pq;
        //{cur_weg, u, stops}

        for(int i=0;i<flights.size();++i){
            int u = flights[i][0];
            int v = flights[i][1];
            int w = flights[i][2];
            adj[u].push_back({v,w});
        }

        distance[src][0] = 0;

        pq.push({0,src,0});
        
        while(!pq.empty()){
            auto [curweg,u,stops] = pq.top();
            pq.pop();

            if(curweg > distance[u][stops]) continue;

            for(auto [v,nextweg] : adj[u]){
                if(stops < k+1 && (nextweg + curweg < distance[v][stops+1])){
                    distance[v][stops+1] = nextweg + curweg;
                    pq.push({distance[v][stops+1],v,stops+1});
                }
            }
        }

        int ans = INT_MAX/2;
        for(int i=0;i<=k+1;++i){
            ans = min(ans, distance[dst][i]);
        }
        
        return ans != INT_MAX/2 ? ans : -1;
    }
};