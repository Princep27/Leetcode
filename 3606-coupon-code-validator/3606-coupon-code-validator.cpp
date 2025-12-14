class Solution {
public:
    bool valid(string code,string business,bool isActive){
        if(!isActive) return false;
        if(business == "electronics" || business == "grocery" || business == "pharmacy" || business == "restaurant") ;
        else return false;
        if(code.size() == 0) return false;
        for(int i=0;i<code.size();++i){
            char ch = code[i];
            if((ch <= 'z' && ch >= 'a') || (ch <= 'Z' && ch >= 'A') || (ch <= '9' && ch >= '0') || ch == '_'){
                continue;
            }else{
                return false;
            }
        }
        return true;
    }

    vector<string> validateCoupons(vector<string>& code, vector<string>& businessLine, vector<bool>& isActive) {
        int n = code.size();
        vector<pair<string,string>> vp;
        for(int i=0;i<n;++i){
            if(valid(code[i],businessLine[i],isActive[i])){
                vp.push_back({businessLine[i],code[i]});
            }
        }

        sort(vp.begin(),vp.end());
        vector<string> ans;
        for(auto it : vp){
            ans.push_back(it.second);
        }

        return ans;
    }
};