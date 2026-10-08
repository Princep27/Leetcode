class Solution {
public:
    int maxProduct(vector<int>& nums) {
        long maxNegative = LONG_MIN;
        long prod = 1;
        long ans = LONG_MIN;

        for(long num: nums){
            if(num == 0){
                prod = 1;
                ans = max(ans, num);
                maxNegative = LONG_MIN;
            }else{
                prod *= num;
                if(prod < 0 && maxNegative != LONG_MIN){
                    ans = max(ans, prod/maxNegative);
                }else{
                    ans = max(ans, prod);
                }

                if(prod < 0) maxNegative = max(maxNegative, prod);
            }
        }

        return ans;
    }
};