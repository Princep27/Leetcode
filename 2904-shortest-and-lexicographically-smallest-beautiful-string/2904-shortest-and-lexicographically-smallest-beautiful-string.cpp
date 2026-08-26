class Solution {
public:
    
    int count(string &str,int k){
        int cnt = 0;
        for(int i=0;i<str.length();i++){
            if(str[i] == '1')
                ++cnt;
        }
        if(cnt == k) return true;
        return false;
    }
    
    string shortestBeautifulSubstring(string s, int k) {
        int n = s.length();
        string mini = "";
        
        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
                
                string temp = s.substr(i,j-i+1);
                if(count(temp,k)){
                    if(mini == ""){
                        mini = temp;
                    }else if(mini.length() > temp.length()){
                        mini = temp;
                    }else if(mini.length() == temp.length() && temp < mini){
                        mini = temp;
                    }
                }
                
            }
        }
        
        return mini;
    }
};