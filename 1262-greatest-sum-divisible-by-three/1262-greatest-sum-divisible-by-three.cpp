class Solution {
public:
    int maxSumDivThree(vector<int>& nums) {
        int sum = 0,ans = 0; for(auto it: nums) sum += it;
        if(sum % 3 == 0) ans = sum;
        else if(sum % 3 == 1){
            int mini_two1 = INT_MAX, mini_two2 = INT_MAX,mini_one = INT_MAX;
            for(auto it: nums){
                if(it % 3 == 1) mini_one = min(mini_one,it);
            
                if(it % 3 == 2){
                    if(mini_two1 >= it){
                        mini_two2 = mini_two1; mini_two1 = it;
                    }else{
                        mini_two2 = min(mini_two2,it);
                    }
                }
            }
            if(mini_two2 != INT_MAX) ans = max(ans, sum - mini_two1 - mini_two2);
            if(mini_one != INT_MAX) ans = max(ans, sum - mini_one);
            cout<<mini_two1<<" "<<mini_two2<<" "<<mini_one<<endl;
        }else{
            int mini_one1 = INT_MAX, mini_one2 = INT_MAX,mini_two = INT_MAX;
            for(auto it: nums){
                if(it % 3 == 2) mini_two = min(mini_two,it);
            
                if(it % 3 == 1){
                    if(mini_one1 >= it){
                        mini_one2 = mini_one1; mini_one1 = it;
                    }else{
                        mini_one2 = min(mini_one2,it);
                    }
                }
            }
            if(mini_one2 != INT_MAX) ans = max(ans, sum - mini_one1 - mini_one2);
            if(mini_two != INT_MAX) ans = max(ans, sum - mini_two);
        }
        return ans;
    }
};

// +1. -> +2
// +2  -> +1