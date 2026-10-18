class Solution {
public:
    int maxValue(int n, int index, int maxSum) {
        long long l = 1,  r = 1000000008;
        long long ans = 0;

        while(l <= r){
            long long mid = (r-l)/2 + l;
            //nums[index] = mid 
            // 0 1 2 3 4 
            long long sum = 0;
            long long rightcnt = 1LL*n - index;
            long long leftcnt = index;

            long long rightsum = (mid*(mid+1))/2;
            if(rightcnt < mid){
                rightsum -= (((mid-rightcnt)*(mid-rightcnt+1))/2);
            }else{
                rightsum += (rightcnt - mid);
            }
            

            long long leftsum = (mid*(mid-1))/2;
            if(leftcnt < mid-1){
                leftsum -= (((mid-1-leftcnt)*(mid-1-leftcnt+1))/2);
            }else{
                leftsum += (leftcnt - (mid-1));
            }

            sum = rightsum + leftsum;

            cout<<l<<" "<<mid<<" "<<r<<" "<<leftsum<<" "<<rightsum<<endl;
            if(sum <= 1LL*maxSum){
                ans = mid;
                l = mid+1;
            }else{
                r = mid-1;
            }
        }

        return (int)ans;
    }
};