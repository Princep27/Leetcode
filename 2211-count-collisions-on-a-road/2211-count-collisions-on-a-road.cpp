class Solution {
public:
    int countCollisions(string directions) {
        int l = 0,r = 0,s = 0, ans = 0;
        for(int i = 0;i < directions.size(); ++i){
            char d = directions[i];
            if(d == 'L'){
                if(r){
                    ans = ans + r + 1; r = 0; s = 1;
                }else if(s){
                    ++ans;
                }
            }else if(d == 'R'){
                ++r;
            }else{
                ans += r; r = 0; s = 1;
            }
        }

        return ans;
    }
};