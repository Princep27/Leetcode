class Solution {
public:
    int solve(vector<int> &slices,int n,int index,int cnt,int zeropicked,vector<vector<vector<int>>> &dp){

        if(cnt == n/3) return 0;

        if(index >= n){
            if(cnt == n/3) return 0;
            else return INT_MIN/2;
        }

        if(dp[index][cnt][zeropicked] != -1) 
            return dp[index][cnt][zeropicked];

        if(index == 0){
            return dp[index][cnt][zeropicked] = max(
                slices[index] + solve(slices,n,index+2,cnt+1,1,dp),
                solve(slices,n,index+1,cnt,0,dp)
            );
        }

        if(index == n-1){
            //not picked
            int tmp = solve(slices,n,index+1,cnt,zeropicked,dp);
            //pick only when zero index is not picked
            if(!zeropicked)
                tmp = max(tmp, slices[index] + solve(slices,n,index+2,cnt+1,zeropicked,dp));
            return dp[index][cnt][zeropicked] = tmp;
        }

        return dp[index][cnt][zeropicked] = max(
            slices[index] + solve(slices,n,index+2,cnt+1,zeropicked,dp), 
            solve(slices,n,index+1,cnt,zeropicked,dp)
        );
    }

    int maxSizeSlices(vector<int>& slices) {
        int n = slices.size();
        vector<vector<vector<int>>> dp(n+1,vector<vector<int>>(n/3+1,vector<int>(2,-1)));
        return solve(slices,n,0,0,1,dp);
    }
};