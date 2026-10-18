class Solution {
public:
    int minSetSize(vector<int>& arr) {
        int n = arr.size();
        int half = n/2;
        unordered_map<int,int> mp;
        for(auto it: arr) ++mp[it];
        vector<int> tmp;

        for(auto &it: mp){
            tmp.push_back(it.second);
        }

        sort(tmp.begin(),tmp.end());
        reverse(tmp.begin(),tmp.end());

        int ans = 0;
        for(auto it: tmp){
            half -= it;
            ++ans;
            if(half <= 0)
                return ans;
        }

        return ans;
    }
};