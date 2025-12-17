class Solution {
public:
    vector<vector<vector<long long>>> dp;

    // 0 -> not picked, 1 -> normal transcation, 2 -> short selling transcation
    long long solve(vector<int> &price,int k,int index,int state,int n){
        if(k == 0) return 0;

        if(index == n){
            if(state == 0) return 0;
            else if(state == 1) return 0;
            else return INT_MIN;
        }

        if(dp[index][k][state] != -1) return dp[index][k][state];

        long long ans = 0;
        if(state == 0){
            ans =  max(solve(price,k,index+1,0,n), 
                    max(solve(price,k,index+1,1,n) - (long long)price[index], 
                        solve(price,k,index+1,2,n) + (long long)price[index])
                    );
        }else if(state == 1){
            long long included = solve(price,k-1,index+1,0,n) + (long long)price[index];
            long long not_included = solve(price,k,index+1,1,n);
            ans = max(included, not_included);
        }else{
            long long included = solve(price,k-1,index+1,0,n) - (long long)price[index];
            long long not_included = solve(price,k,index+1,2,n);
            ans = max(included, not_included);
        }

        return dp[index][k][state] = ans;
    }

    long long maximumProfit(vector<int>& prices, int k) {
        int n = prices.size();
        dp.resize(n+1,vector<vector<long long>>(k+1,vector<long long>(3,-1)));
        return solve(prices, k, 0, 0,n);
    }
};