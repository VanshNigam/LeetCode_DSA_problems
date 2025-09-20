class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);

        int i = 0;
        int j = 0;
        int c = 0;

        int n = g.length;
        while (i < n && j < s.length) {
            if (g[i] <= s[j]) {
                c++;
                i++;
            }
            j++;
        }
        return c;
    }
}