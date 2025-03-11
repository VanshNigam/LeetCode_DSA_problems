class Solution {
    public int numberOfSubstrings(String s) {
        int n = s.length();
        int c = 0;
        int l = 0;
        int r = 0;
        int fr[] = new int[26];

        while (r < n) {
            fr[s.charAt(r) - 'a']++;
            while ((fr[0] > 0) && (fr[1] > 0) && (fr[2] > 0)) {
                c += (n - r);
                fr[s.charAt(l) - 'a']--;
                l++;
            }
            r++;
        }
        return c;
    }
}