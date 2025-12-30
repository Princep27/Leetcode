class Solution {
public:
    bool valid(vector<vector<int>> &grid,int x,int y){
        if(x + 3 > grid.size() || y + 3 > grid[0].size()) return false;
        vector<int> cnt(10,0);
        int left_d = 0, right_d = 0;
        int tmp_x = x, tmp_y = y;

        for(int i=0;i<3;++i){
            left_d += grid[tmp_x][tmp_y]; ++tmp_x; ++tmp_y;
        }
        tmp_x = x, tmp_y = y+2;
        for(int i=0;i<3;++i){
            right_d += grid[tmp_x][tmp_y]; ++tmp_x; --tmp_y;
        }

        vector<int> row(3,0),col(3,0);
        for(int i=x;i<x+3;++i){
            for(int j=y;j<y+3;++j){

                if(grid[i][j] > 9 || grid[i][j] == 0 || cnt[grid[i][j]] == 1) return false;
                ++cnt[grid[i][j]];

                int r = i-x, c = j-y;
                row[r] += grid[i][j];
                col[c] += grid[i][j];
            }
        }

        if(row[1] != row[0] || row[2] != row[1]) return false;
        if(col[1] != col[0] || col[2] != col[1]) return false;
        if(col[0] != row[0]) return false;
        if(col[0] != left_d) return false;
        if(left_d != right_d) return false; 
        return true;
    }

    int numMagicSquaresInside(vector<vector<int>>& grid) {
        int n = grid.size(), m = grid[0].size(),ans = 0;
        for(int i=0;i<n;++i){
            for(int j=0;j<m;++j){
                if(valid(grid,i,j)) ++ans;
            }
        }
        return ans;
    }
};