class Solution {
public:
    int dp[3001][31];

    int solve(int sum,int index,vector<int> &stones){
        if(index == stones.size()) return sum;
        if(dp[sum][index] != -1) return dp[sum][index];

        int ans = 101;
        if(stones[index] <= sum) ans = solve(sum-stones[index],index+1,stones);
        ans = min(ans, solve(sum,index+1,stones));
        return dp[sum][index] = ans;
    }

    int lastStoneWeightII(vector<int>& stones) {
        memset(dp,-1,sizeof(dp));
        int sum = 0;
        for(auto it: stones) sum += it;
        int half =  sum/2;
        int firsthalf = half - solve(half,0,stones);
        int secondhalf = sum - firsthalf;
        return abs(secondhalf-firsthalf);
    }
};

/*

*/