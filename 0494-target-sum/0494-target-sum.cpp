class Solution {
public:
    int solve(vector<int> &num,int target,int i){
        if(i == 0)
            if(target == 0)
                return 1;
            else
                return 0;
        
    
        return solve(num,target-num[i-1],i-1) + 
                       solve(num,target+num[i-1],i-1);
        
    }
    
    int findTargetSumWays(vector<int>& nums, int target) {
        return solve(nums,target,nums.size());
    }
};