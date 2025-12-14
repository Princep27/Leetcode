class Solution {
public:
    int numberOfWays(string corridor) {
        long ans = 1;
        long ways = 1;
        bool s_exist = false;

        int i = 0;
        while(i < corridor.size() && corridor[i] == 'P'){
            ++i;
        }

        while(i < corridor.size()){

            bool possible = false;
            if(corridor[i] == 'P') ++ways;
            if(corridor[i] == 'S'){

                s_exist = true;
                int j = i+1;
                while( j < corridor.size()){
                    if(corridor[j] == 'S'){
                        possible = true; break;
                    }
                    ++j;
                }

                if(possible){
                    ans = (ans * ways)%1000000007; ways = 1; i = j; 
                }else{
                    return 0;
                }
            }
            ++i;
        }

        if(s_exist) return max(1,(int)ans);
        else return 0;
    }
};