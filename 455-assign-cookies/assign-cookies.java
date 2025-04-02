class Solution {
    public int findContentChildren(int[] g, int[] s) {
        int i = 0;
        int j = 0;

        Arrays.sort(g);
        Arrays.sort(s);

       while (i < g.length && j < s.length) {
            if (s[j] >= g[i]) { // A cookie can satisfy a child
                i++; // Move to the next child
            }
            j++; // Always move to the next cookie
        }
        return i; // Number of content children
    }
}