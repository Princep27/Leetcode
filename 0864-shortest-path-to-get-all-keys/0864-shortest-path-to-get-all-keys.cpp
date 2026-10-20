class Solution {
public:
    int shortestPathAllKeys(vector<string>& grid) {
        int n = grid.size();
        int m = grid[0].size();

        vector<vector<vector<bool>>> vis(
            64, vector<vector<bool>>(n, vector<bool>(m, false))
        );

        int x = 0, y = 0, keys = 0;

        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                if (grid[i][j] == '@') {
                    x = i;
                    y = j;
                }
                else if (grid[i][j] >= 'a' && grid[i][j] <= 'f') {
                    ++keys;
                }
            }
        }

        queue<tuple<int, int, int>> q;
        q.push({x, y, 0});
        vis[0][x][y] = true;

        int scnt = 0;
        int dx[4] = {0, 0, -1, 1};
        int dy[4] = {1, -1, 0, 0};

        while (!q.empty()) {
            int sz = q.size();

            while (sz--) {
                auto [i, j, hash] = q.front();
                q.pop();

                if (hash == (1 << keys) - 1)
                    return scnt;

                for (int k = 0; k < 4; ++k) {
                    int newx = i + dx[k];
                    int newy = j + dy[k];

                    if (newx < 0 || newx >= n ||
                        newy < 0 || newy >= m)
                        continue;

                    char c = grid[newx][newy];
                    if (c == '#') continue;

                    int newhash = hash;

                    if (c >= 'a' && c <= 'f') {
                        int pos = c - 'a';
                        newhash |= (1 << pos);
                    }

                    if (c >= 'A' && c <= 'F') {
                        int pos = c - 'A';
                        if (!(hash & (1 << pos))) continue;
                    }

                    if (!vis[newhash][newx][newy]) {
                        vis[newhash][newx][newy] = true;
                        q.push({newx, newy, newhash});
                    }
                }
            }

            ++scnt;
        }

        return -1;
    }
};