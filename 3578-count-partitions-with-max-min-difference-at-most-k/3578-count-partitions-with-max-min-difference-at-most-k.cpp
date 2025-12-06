class Solution {
public:
    static int countPartitions(vector<int>& nums, int k) {
        int n = nums.size();
        const int MOD = 1e9 + 7;

        multiset<int> win;
        long long cnt = 0;

        vector<int> sum(n + 2, 0);
        sum[1] = 1;

        for (int left = 0, right = 0; right < n; ++right) {
            win.insert(nums[right]);

            while (*(prev(win.end())) - *win.begin() > k) {
                win.erase(win.lower_bound(nums[left]));
                ++left;
            }

            cnt = (MOD + sum[right + 1] - sum[left]) % MOD;
            sum[right + 2] = (sum[right + 1] + cnt) % MOD;
        }

        return cnt;
    }
};

