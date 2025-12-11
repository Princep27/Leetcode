class Solution {
public:
    int countCoveredBuildings(int n, vector<vector<int>>& buildings) {
        vector<int> left(n+1,INT_MAX),right(n+1,INT_MIN);
        vector<int> up(n+1,INT_MAX),down(n+1,INT_MIN);
        int ans = 0;
        
        for(int i=0;i<buildings.size();++i){
            int row = buildings[i][0], col = buildings[i][1];
            left[row] = min(left[row],col);
            right[row] = max(right[row],col);
            up[col] = min(up[col],row);
            down[col] = max(down[col],row);
        }

        for(int i=0;i<buildings.size();++i){
            int row = buildings[i][0], col = buildings[i][1];
            if(left[row] < col && right[row] > col && up[col] < row && down[col] > row) ++ans;
        }
        
        return ans;
    }
};