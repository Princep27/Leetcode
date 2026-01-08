class Solution {
public:

    vector<vector<int>> dp;

    int solve(vector<int> &nums1,vector<int> &nums2,int n,int m){
        if(n == 0 || m == 0) return 0;
        if(dp[n][m] != INT_MIN) return dp[n][m];
        int take = nums1[n-1]*nums2[m-1] + solve(nums1,nums2,n-1,m-1);
        int notTake1 = solve(nums1,nums2,n-1,m);
        int notTake2 = solve(nums1,nums2,n,m-1);
        return dp[n][m] = max(take,max(notTake1,notTake2));
    }

    int maxDotProduct(vector<int>& nums1, vector<int>& nums2) {
        dp.resize(nums1.size()+1,vector<int>(nums2.size()+1,INT_MIN));
        int ans = solve(nums1,nums2,nums1.size(),nums2.size());
        if(ans == 0){
            ans = INT_MIN;
            for(int i=0;i<nums1.size();++i){
                for(int j=0;j<nums2.size();++j){
                    ans = max(ans, nums1[i]*nums2[j]);
                }
            }
        }
        return ans;
    }
};