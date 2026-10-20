
class Solution {
public:
    int minCost(int maxTime, vector<vector<int>>& edges, vector<int>& passingFees) {

        int n = passingFees.size();
        vector<vector<int>> cost(n, vector<int>(maxTime + 1, INT_MAX / 2));
        vector<vector<pair<int,int>>> adj(n);
        priority_queue<tuple<int,int,int>, vector<tuple<int,int,int>>, greater<tuple<int,int,int>>> pq;
        // {cost, node, time}

        for(int i = 0; i < edges.size(); ++i) {
            int u = edges[i][0];
            int v = edges[i][1];
            int w = edges[i][2];
            adj[u].push_back({v, w});
            adj[v].push_back({u, w});
        }

        cost[0][0] = passingFees[0];
        pq.push({passingFees[0], 0, 0});

        while(!pq.empty()) {
            auto [curprice, u, curtime] = pq.top();
            pq.pop();

            if(curprice != cost[u][curtime]) continue;

            if(u == n - 1) return curprice;

            for(auto [v, nexttime] : adj[u]) {
                int newtime = curtime + nexttime;
                if(newtime > maxTime) continue;

                int nextprice = curprice + passingFees[v];

                if(nextprice < cost[v][newtime]) {
                    cost[v][newtime] = nextprice;
                    pq.push({nextprice, v, newtime});
                }
            }
        }

        return -1;
    }
};
