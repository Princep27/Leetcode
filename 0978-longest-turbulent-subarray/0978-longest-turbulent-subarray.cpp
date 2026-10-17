class Solution {
public:
    int maxTurbulenceSize(vector<int>& arr) {
        int n = arr.size();
        vector<int> less(n+1,0);
        vector<int> great(n+1,0);

        less[0] = great[0] = 1;
        int ans = 1;

        for(int i=1;i<n;++i){
            if(arr[i] > arr[i-1]){
                great[i] = less[i-1] + 1;
                less[i] = 1;
            }else if(arr[i] < arr[i-1]){
                less[i] = great[i-1] + 1;
                great[i] = 1;
            }else{
                less[i] = 1;
                great[i] = 1;
            }
            ans = max({less[i],great[i],ans});
        }

        return ans;
    }
};