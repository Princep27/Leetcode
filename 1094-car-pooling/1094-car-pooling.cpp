class Solution {
public:
    static bool comparator(const vector<int> &a,const vector<int> &b){
        if(a[1] == b[1]) return a[2] < b[2];
        return a[1] < b[1];
    }

    bool carPooling(vector<vector<int>>& trips, int capacity) {
        int n = trips.size();
        int cnt = 0;

        sort(trips.begin(),trips.end(),comparator);

        priority_queue<pair<int,int>,vector<pair<int,int>>,greater<pair<int,int>>> pq; 
        //<time,dropcnt>

        for(int i=0;i<n;++i){
            int p = trips[i][0];
            int u = trips[i][1];
            int v = trips[i][2];
            while(!pq.empty() && pq.top().first <= u){
                cnt -= pq.top().second;
                pq.pop();
            }

            cnt += p;
            if(cnt > capacity) return false;
            pq.push({v,p});
        }

        return true;
    }
};