class Solution {
public:
    int smallestRepunitDivByK(int k) {
        int rem = 0,ans = 0;

        //reminders will be between 0 to k-1 when divided by k
        //it means there will be atleat one case when reminder will be zero
        //when cheacking for k times

        for(int i=1;i<=k;++i){
            rem = (rem*10 + 1)%k;
            ++ans;
            if(rem == 0) return ans;
        }

        return -1;

    }
};