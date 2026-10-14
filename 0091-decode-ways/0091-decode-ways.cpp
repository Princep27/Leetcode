class Solution {
public:
    int numDecodings(string s) {
        bool invalid = false;
        int n = s.length();
        if(s[0] == '0') return 0;

        int end1 = 1;
        int end2 = 0;

        cout<<end1<<" "<<end2<<endl;

        for(int i=1;i<n;++i){

            if(s[i] == '0'){
                if(s[i-1] == '1' || s[i-1] == '2'){
                    end2 = end1;
                    end1 = 0;
                }else{
                    invalid = true;
                    break;
                }
            }
            
            else{
                int last2digit = (s[i-1]-'0')*10 + (s[i]-'0');
                int tmpend1 = end2 + end1;
                int tmpend2 = (last2digit < 27 ? end1 : 0);
                end1 = tmpend1;
                end2 = tmpend2;
            }

            cout<<end1<<" "<<end2<<endl;
        }
        
        if(invalid) return 0;
        else return end1 + end2;
    }
};