class Solution {
public:
    struct Node {
        int x;
        int y;
        int k;
        int dir;
        int cost;

        Node(int x, int y, int k, int dir, int cost) {
            this->x = x;
            this->y = y;
            this->k = k;
            this->dir = dir;
            this->cost = cost;
        }
    };

    struct cmp {
        bool operator()(const Node& n1, const Node& n2) {
            return n1.cost > n2.cost;
        }
    };

    int minCost(vector<vector<int>>& grid, int k) {
        int n = grid.size();
        int m = grid[0].size();

        vector<vector<vector<vector<int>>>> dist(
            n, vector<vector<vector<int>>>(
                m, vector<vector<int>>(
                    k + 1, vector<int>(4, INT_MAX / 2)
                )
            )
        );

        int dx[] = {0, 1, -1, 0};
        int dy[] = {1, 0, 0, -1};

        priority_queue<Node, vector<Node>, cmp> pq;

        pq.push(Node(0, 0, k, 0, grid[0][0]));
        pq.push(Node(0, 0, k, 1, grid[0][0]));

        dist[0][0][k][0] = grid[0][0];
        dist[0][0][k][1] = grid[0][0];

        while (!pq.empty()) {
            Node node = pq.top();
            pq.pop();

            for (int i = 0; i < 4; ++i) {

                int nx = node.x + dx[i];
                int ny = node.y + dy[i];

                int nk = node.k;
                int dir = i;

                if (nx < 0 || nx >= n || ny < 0 || ny >= m)
                    continue;

                if (node.dir == dir) {

                    if (grid[nx][ny] + node.cost <
                        dist[nx][ny][nk][dir]) {

                        dist[nx][ny][nk][dir] =
                            grid[nx][ny] + node.cost;

                        pq.push(Node(
                            nx, ny, nk, dir,
                            grid[nx][ny] + node.cost
                        ));
                    }
                }
                else {

                    if (nk > 0 &&
                        grid[nx][ny] + node.cost <
                        dist[nx][ny][nk - 1][dir]) {

                        dist[nx][ny][nk - 1][dir] =
                            grid[nx][ny] + node.cost;

                        pq.push(Node(
                            nx, ny, nk - 1, dir,
                            grid[nx][ny] + node.cost
                        ));
                    }
                }
            }
        }

        int ans = INT_MAX;

        for (int kk = 0; kk <= k; ++kk) {
            for (int dir = 0; dir < 4; ++dir) {
                ans = min(ans, dist[n - 1][m - 1][kk][dir]);
            }
        }

        return ans != INT_MAX/2 ? ans : -1;
    }
};