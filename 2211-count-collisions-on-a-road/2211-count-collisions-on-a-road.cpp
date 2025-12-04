class Solution {
public:
    int countCollisions(string directions) {
        stack<char> st;
        int cnt = 0,ans = 0;
        for(int i = 0;i < directions.size(); ++i){
            char d = directions[i];
            if(d == 'L'){
                if(st.empty()) continue;
                else if(st.top() == 'S') ++ans;
                else if(st.top() == 'R'){
                    ++ans;
                    while(!st.empty() && st.top() == 'R'){
                        st.pop(); ++ans;
                    }
                    st.push('S');
                }else{
                    st.push('L');
                } 
            }else if(d == 'R'){
                if(st.empty()) st.push('R');
                else if(st.top() == 'R') st.push('R');
                else if(st.top() == 'L'){
                    st.push('R');
                }else{
                    st.push('R');
                }
            }else{
                while(!st.empty() && st.top() == 'R'){
                    ++ans; st.pop();
                }
                st.push('S');
            }
        }

        return ans;
    }
};