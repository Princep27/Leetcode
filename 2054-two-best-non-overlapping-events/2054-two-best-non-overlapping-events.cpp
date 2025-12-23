class Solution {
public:
    
    static bool compare(vector<int> &a,vector<int> &b){
        return a[0] < b[0];
    }

    static bool upper_bound_comparator(int key,pair<int,int> &p){
        return key < p.first;
    }

    int maxTwoEvents(vector<vector<int>>& events) {
        int ans = 0;
        sort(events.begin(),events.end(),compare);
        vector<pair<int,int>> vp;
        for(int i=events.size()-1;i>=0;--i){
            if(i == events.size()-1) vp.push_back({events[i][0],events[i][2]});
            else vp.push_back({events[i][0],max(events[i][2], vp[vp.size()-1].second)});
        }
        reverse(vp.begin(),vp.end());

        for(int i=0;i<events.size();++i){
            int end = events[i][1], val = events[i][2];
            auto it = upper_bound(vp.begin(),vp.end(),end,upper_bound_comparator);
            if(it == vp.end()) ans = max(ans,val);
            else ans = max(ans, val + it->second);
        }

        return ans;
    }
};