class Solution {
private:
    int help(vector<vector<int>>& dp, int x, int y,
             vector<vector<int>>& triangle) {
        if (x >= triangle.size() - 1)
            return triangle[x][y];
        if (dp[x][y] != INT_MAX)
            return dp[x][y];

        int first = help(dp, x + 1, y, triangle);
        int second = help(dp, x + 1, y + 1, triangle);

        return dp[x][y] = min(first+ triangle[x][y], second+ triangle[x][y]);
    }

public:
    int minimumTotal(vector<vector<int>>& triangle) {
        int m = triangle.size();
        vector<vector<int>> dp(m, vector<int>(m, INT_MAX));
        return help(dp, 0, 0, triangle);
    }
};