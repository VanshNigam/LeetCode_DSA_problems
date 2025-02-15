
class Solution {
public:
    int maxPointsInsideSquare(vector<vector<int>>& points, string s) {
        map<int, string> mpp;  
        int ma = 0;
        for (int i = 0; i < points.size(); ++i) {
            int x = abs(points[i][0]);
            int y = abs(points[i][1]);
            int dist = max(x, y); 
            mpp[dist] += s[i];
        }
        vector<int> count(26, 0);
        for (auto& it : mpp) {            
            bool flag = true;
            for (char ch : it.second) {
                count[ch - 'a']++;
                if (count[ch - 'a'] > 1) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                ma +=(it.second.length());
            }
            else break;
        }

        return ma;
    }
};