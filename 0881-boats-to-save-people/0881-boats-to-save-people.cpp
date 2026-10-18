class Solution {
public:
    int numRescueBoats(vector<int>& people, int limit) {
        int n = people.size();
        sort(people.begin(),people.end());
        int l = 0, r = n-1;
        int ans = 0;

        while(l < r){
            if(people[r] + people[l] > limit){
                --r;
            }else{
                ++l; --r;
            }
            ++ans;
        }

        if(l == r) ++ans;

        return ans;
    }
};