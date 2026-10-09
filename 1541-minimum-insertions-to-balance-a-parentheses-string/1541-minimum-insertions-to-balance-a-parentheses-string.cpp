class Solution {
public:
    int minInsertions(string s) {
        int openCount = 0;
        int n = s.length();
        int ans = 0;
        for(int i=0;i<n;++i){
            //open bracket case
            if(s[i] == '('){
                ++openCount;
            }

            //close bracket
            else{

                //reached last and single close
                if(i == n-1){
                    if(openCount > 0){
                        ++ans; --openCount;
                    }
                    else {
                        ans += 2;
                    }
                }
                
                //two close 
                else if(s[i+1] == ')'){
                    if(openCount > 0){
                        --openCount; ++i;
                    }else{
                        ans += 1; ++i; 
                    }
                }
                
                //singel close
                else{
                    if(openCount > 0){
                        ans += 1; --openCount;
                    }else{
                        ans += 2;
                    }
                    
                }
            }
        }

        return ans + 2*openCount;
    }
};