class Solution {
public:
    long long maxProfit(vector<int>& prices, vector<int>& strategy, int k) {
        long long ans = 0,str = 0, sum = 0;
        for(int i=0;i<prices.size();++i) sum += (prices[i]*strategy[i]);
        ans = sum;

        for(int i=0;i<prices.size();++i){

            if(i < k){
                if(i >= k/2){
                    str += (long long)prices[i];
                }

                sum -= (long long)(prices[i]*strategy[i]);

                if(i == k-1) ans = max(ans,sum+str);
              
            }
            
            else{
                str += (long long)(1*prices[i]);
                str -= (long long)(1*prices[i-k/2]);
                sum -= (long long)(strategy[i]*prices[i]);
                sum += (long long)(strategy[i-k]*prices[i-k]);

                ans = max(ans,sum+str);

            }
        }

        return ans;
    }
};