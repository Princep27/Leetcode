class Solution {
public:
    int countPermutations(vector<int>& complexity) {
        int temp = complexity[0], n = complexity.size();
        for(int i=1;i<n;++i) if(complexity[i] <= temp) return 0;
        long ans = 1,mod = 1000000007;
        for(long i=2;i<n;++i) ans = (ans*i)%mod;
        return ans;
    }
};

/*

1. less than 0th exit not possible


*/