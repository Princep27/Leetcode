class Solution {
public:
    void fill(vector<int> &tmp,int n){
        tmp.clear();
        for(int i=1;i<n;++i) tmp.push_back(i);
    }

    int minDeletionSize(vector<string>& strs) {

        int n = strs.size(), m = strs[0].size();
        vector<int> rows,rem_rows;
        int col = 0,cnt = 0;
        fill(rows,n);

        while(true){

            if(col == m) return cnt;
            for(int i=0;i<rows.size();++i){
                int row = rows[i];
                if(strs[row][col] == strs[row-1][col] && col != m-1){
                    rem_rows.push_back(row);
                }else if(strs[row][col] < strs[row-1][col]){
                    ++cnt; rem_rows = rows; 
                    break;
                }
            }

            if(rem_rows.size() == 0){
                return cnt;
            }else{
                rows = rem_rows; 
                rem_rows.clear();
                ++col;
            }
        }

    }
};