class Solution {
public:
    void rotate(vector<int>& nums, int k) {
        int n = nums.size();
        k = k%n;

        int cnt  = 0;
        int start = 0;

        int tmp;
        while(cnt < n){
            ++cnt;
            int cur = start;
            int next = (start+k)%n;
            int val = nums[start];

            while(next != start){
                ++cnt;
                int tmp = nums[next];
                nums[next] = val;
                val = tmp;
                cur = next;
                next = (next + k)%n;
            }

            nums[next] = val;
            ++start;
        }
    }
};

// n = 5, k = 2
// 0 -> 2 -> 4 -> 1 -> 3 -> 0
//k = 3
// 0 -> 3 -> 1 -> 4 -> 2 -> 0

//n = 6, k = 2
//0 -> 2 -> 4 -> 0
//k = 4
//0 -> 4 -> 2 -> 0
//0 1 2 3 4 5 