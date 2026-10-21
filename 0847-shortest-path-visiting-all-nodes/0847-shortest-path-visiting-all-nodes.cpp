class Solution {
public:
    int shortestPathLength(vector<vector<int>>& graph) {
        int n = graph.size();

        vector<vector<bool>> vis(n,vector<bool>(pow(2,n),false));
        queue<pair<int,int>> q;
        //{node,hash}

        vector<int> in(n,0);

        for(int i=0;i<n;++i){
            int start = i;
            int hash = (1 << start);
            q.push({start,hash});
            vis[start][hash] = true;
        }

        int steps = 0;

        while(!q.empty()){
            int sz = q.size();

            for(int i=0;i<sz;++i){
                auto [u,curhash] = q.front();
                q.pop();

                if(curhash == pow(2,n)-1) 
                    return steps;
                
                for(auto v : graph[u]){

                    int newhash = curhash;

                    if(!((curhash >> v) & 1)){
                        newhash = curhash | (1 << v);
                    }

                    if(vis[v][newhash] == false){
                        vis[v][newhash] = true;
                        q.push({v,newhash});
                    }
                    
                }

            }
            
            ++steps;
        }

        return -1;
    }
};