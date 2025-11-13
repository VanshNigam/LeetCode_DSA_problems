class Solution {
public:
    int maxOperations(string s) {
        int n = s.size();
        int count = 0;
        vector<int> a(n, 0);
        if (s[0] == '1')
            a[0] = 1;
        for (int i = 1; i < n; i++) {
            a[i] += a[i - 1];
            if (s[i] == '1') {
                a[i] += 1;
            }
        }
        for (int i = n - 1; i > 0; i--) {
            if (s[i] == '0') {
                while (i > 0 && s[i - 1] == '0')
                    --i;
                count += a[i];
            }
        }
        return count;
    }
};