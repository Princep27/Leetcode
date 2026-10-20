class Solution {
public:
    vector<bool> checkIfPrerequisite(int numCourses, vector<vector<int>>& prerequisites, vector<vector<int>>& queries) {

        int n = numCourses;
        vector<vector<int>> mat(n,vector<int>(n));
        for(int i=0;i<prerequisites.size();++i){
            int u = prerequisites[i][0];
            int v = prerequisites[i][1];
            mat[u][v] = 1;
        }

        for(int i=0;i<n;++i){
            for(int j=0;j<n;++j){
                if(i == j) mat[i][j] = 0;
                else if(mat[i][j] != 1) mat[i][j] = INT_MAX/2;
            }
        }

        for(int k=0;k<n;++k){
            for(int i=0;i<n;++i){
                for(int j=0;j<n;++j){
                    mat[i][j] = min(mat[i][j], mat[i][k] + mat[k][j]);
                }
            }
        }

        vector<bool> ans(queries.size());

        for(int i=0;i<queries.size();++i){
            if(mat[queries[i][0]][queries[i][1]] >= INT_MAX/2) ans[i] = false;
            else ans[i] = true;
        }

        return ans;
    }
};