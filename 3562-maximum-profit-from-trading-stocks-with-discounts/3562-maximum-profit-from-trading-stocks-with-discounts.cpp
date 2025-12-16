class Solution {
public:
    vector<int> solve(int index,int discount,int n,vector<int> &present,vector<int> &future,int budget,vector<vector<int>> &adj,vector<vector<vector<int>>> &dp){

        if (dp[index][discount].size())
            return dp[index][discount];

        vector<int> profit_dp(budget + 1, 0);

        vector<int> option1(budget + 1, 0);
        for (auto it : adj[index]) {
            vector<int> child = solve(it, 0, n, present, future, budget, adj, dp);
            vector<int> temp(budget + 1, 0);

            for (int i = 0; i <= budget; ++i) {
                for (int bud_allocated = 0; bud_allocated <= i; ++bud_allocated) {
                    temp[i] = max(temp[i], child[bud_allocated] + option1[i - bud_allocated]);
                }
            }
            option1 = temp;
        }

        vector<int> option2(budget + 1, 0);
        vector<int> tmp_option2(budget + 1, 0);

        int cur_cost = discount ? present[index] / 2 : present[index];
        int profit = future[index] - cur_cost;

        if (cur_cost <= budget) {
            for (auto it : adj[index]) {
                vector<int> child = solve(it, 1, n, present, future, budget, adj, dp);
                vector<int> temp(budget + 1, 0);

                for (int i = 0; i <= budget; ++i) {
                    for (int bud_allocated = 0; bud_allocated <= i; ++bud_allocated) {
                        temp[i] = max(
                            temp[i],
                            child[bud_allocated] + tmp_option2[i - bud_allocated]
                        );
                    }
                }
                tmp_option2 = temp;
            }

            for (int i = cur_cost; i <= budget; ++i)
                option2[i] = profit + tmp_option2[i - cur_cost];
        }

        for (int i = 0; i <= budget; ++i) {
            profit_dp[i] = max(option1[i], option2[i]);
        }

        dp[index][discount] = profit_dp;
        return profit_dp;
    }

    int maxProfit(int n,vector<int>& present,vector<int>& future,vector<vector<int>>& hierarchy,int budget) {
        vector<vector<int>> adj(n);
        for (int i = 0; i < hierarchy.size(); ++i) {
            int u = hierarchy[i][0] - 1;
            int v = hierarchy[i][1] - 1;
            adj[u].push_back(v);
        }

        vector<vector<vector<int>>> dp(n, vector<vector<int>>(2));
        vector<int> v = solve(0, 0, n, present, future, budget, adj, dp);

        int ans = 0;
        for (auto it : v) ans = max(ans, it);
        return ans;
    }
};
