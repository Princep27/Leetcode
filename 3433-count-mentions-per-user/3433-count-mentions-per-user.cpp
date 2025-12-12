class Solution {
public:

    static bool comp(const vector<string> &a, const vector<string> &b) {
        int t1 = stoi(a[1]);
        int t2 = stoi(b[1]);

        if (t1 != t2) return t1 < t2;

        if(a[0] == "OFFLINE") return true;
        return false;
    }

    int findId(const string &str) {
        return stoi(str.substr(2)); 
    }

    vector<int> countMentions(int numberOfUsers, vector<vector<string>>& events) {
        vector<int> ans(numberOfUsers, 0);
        vector<bool> online(numberOfUsers, true);

        sort(events.begin(), events.end(), comp);

        queue<pair<int,int>> online_q;

        for (auto &e : events) {
            int time = stoi(e[1]);

            while (!online_q.empty() && online_q.front().first <= time) {
                online[online_q.front().second] = true;
                online_q.pop();
            }

            if (e[0] == "OFFLINE") {
                int id = stoi(e[2]);
                online[id] = false;
                online_q.push({time + 60, id});
            }
            else { 
                const string& msg = e[2];

                if (msg == "ALL") {
                    for (int i = 0; i < numberOfUsers; i++) ans[i]++;
                }
                else if (msg == "HERE") {
                    for (int i = 0; i < numberOfUsers; i++)
                        if (online[i]) ans[i]++;
                }
                else {
                    stringstream ss(msg);
                    string token;
                    while (ss >> token) {
                        int id = findId(token);
                        ans[id]++;
                    }
                }
            }
        }

        return ans;
    }
};
