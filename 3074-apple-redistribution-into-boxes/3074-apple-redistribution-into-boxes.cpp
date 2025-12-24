class Solution {
public:
    int minimumBoxes(vector<int>& apple, vector<int>& capacity) {
        
        sort(capacity.begin(),capacity.end(),greater<int>());
        int sum = 0,ans = 0; for(auto it : apple) sum += it;
        for(int i=0;i<capacity.size();++i) 
            if(sum <= 0) return ans;
            else{
                ++ans; sum -= capacity[i];
            }
        return ans;
    }
};