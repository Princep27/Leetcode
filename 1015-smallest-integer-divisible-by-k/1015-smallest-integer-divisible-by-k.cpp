class Solution {
public:
    int smallestRepunitDivByK(int k) {
        unordered_set<int> st; st.insert(1);
        int rem = 1,ans = 1;
        if(k == 1) return 1;
    
        while(rem){
            rem = (rem*10 + 1)%k;
            if(st.count(rem)) return -1;
            st.insert(rem);
            ++ans;
        }

        return ans;

    }
};