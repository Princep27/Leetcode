class Solution {
public:
    int countPalindromicSubsequence(string s) {
        int ans = 0;
        vector<int> index[26];
        for(int i=0;i<s.length();++i){
            index[s[i]-'a'].push_back(i);
        }

        for(char ch1='a';ch1<='z';++ch1){
            for(char ch2='a';ch2<='z';++ch2){

                    char ch3 = ch1;

                    string str = {ch1, ch2, ch3}; 

                    if(index[ch1-'a'].size() == 0) continue;
                    int index1 = index[ch1-'a'][0];

                    auto it = upper_bound(index[ch2-'a'].begin(),index[ch2-'a'].end(),index1);
                    if(it == index[ch2-'a'].end()) continue;
                    int index2 = *it;

                    it = upper_bound(index[ch3-'a'].begin(),index[ch3-'a'].end(),index2);
                    if(it == index[ch3-'a'].end()) continue;
                    cout<<str<<" ";
                    ++ans;

                
            } 
        }

        return ans;
    }
};