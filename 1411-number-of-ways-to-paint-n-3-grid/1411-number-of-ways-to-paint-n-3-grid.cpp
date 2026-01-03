class Solution {
public:

    int solve(vector<vector<int>> &arr,vector<vector<int>> &dp,int option,int n){
        if(dp[option][n] != -1) return dp[option][n];
        if(n == 0) return 1;
        int ans = 0;
        for(int i=0;i<arr[option].size();++i) ans = (ans +  solve(arr,dp,arr[option][i],n-1))%1000000007;
        return dp[option][n] = ans;
    }
    
    int numOfWays(int n) {

        vector<vector<int>> arr(13);
        vector<string> tmp = {"ryr","ryg","rgr","rgy","yry","yrg","ygr","ygy",
                              "gry","grg","gyr","gyg"};
        
        for(int i=0;i<tmp.size();++i){
            for(int j=0;j<tmp.size();++j){
                if(tmp[i][0] != tmp[j][0] && tmp[i][1] != tmp[j][1] && tmp[i][2] != tmp[j][2]) arr[i+1].push_back(j+1);
            }
        }

        //for(int i=0;i<13;++i) cout<<arr[i].size()<<" "; cout<<endl;

        vector<vector<int>> dp(13,vector<int>(n+1,-1));
        for(int i=1;i<=12;++i) arr[0].push_back(i);

        return solve(arr,dp,0,n);
    }
};

// 1 -> 5 
// 2 -> 4
// 3 -> 5
// 4 -> 4
// 5 -> 5
// 6 -> 4
// 7 -> 1 3 -> 4
// 8 -> 2 3 -> 5
// 9 -> 1 3 -> 4
//10 -> 2 3 -> 5
//11 -> 3 1 -> 4
//12 -> 3 2 -> 5
